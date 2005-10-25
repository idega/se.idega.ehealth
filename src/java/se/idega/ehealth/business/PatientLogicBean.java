/*
 * $Id: PatientLogicBean.java,v 1.1 2005/10/25 06:17:36 tryggvil Exp $
 * Created on 25.10.2005 in project se.idega.ehealth
 *
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package se.idega.ehealth.business;

import java.rmi.RemoteException;
import java.sql.Date;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.faces.context.FacesContext;
import se.idega.block.pki.business.NBSLoginBusinessBean;
import se.idega.util.PIDChecker;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.core.accesscontrol.business.AccessController;
import com.idega.core.accesscontrol.business.LoginBusinessBean;
import com.idega.core.data.ICApplicationBinding;
import com.idega.core.data.ICApplicationBindingHome;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.user.business.GenderBusiness;
import com.idega.user.business.GenderBusinessBean;
import com.idega.user.business.GroupBusiness;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.Gender;
import com.idega.user.data.Group;
import com.idega.user.data.GroupHome;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;


/**
 * <p>
 * Class to manipulate data about patients registered as users in the system.
 * </p>
 *  Last modified: $Date: 2005/10/25 06:17:36 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.1 $
 */
public class PatientLogicBean {

	/**
	 * 
	 */
	public PatientLogicBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p>
	 * TODO tryggvil describe method createAndLoginPatient
	 * </p>
	 * @param personalId
	 * @param fullName
	 * @param surName 
	 * @param context
	 * @return
	 */
	public boolean createAndLoginPatient(String personalId, String givenName, String surName, FacesContext context) {
		// TODO Auto-generated method stub
		
		try {
			User user = createPatient(personalId,givenName,surName);
			NBSLoginBusinessBean loginbean = NBSLoginBusinessBean.createNBSLoginBusiness();
			IWContext iwc = IWContext.getIWContext(context);
			loginbean.logInByPersonalID(iwc,personalId,false);
			return true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method createPatient
	 * </p>
	 * @param personalId
	 * @param fullName
	 * @return
	 */
	protected User createPatient(String personalId, String givenName,String surName) throws Exception{
		UserBusiness ub = (UserBusiness) IBOLookup.getServiceInstance(getApplicationContext(),UserBusiness.class);
		GroupBusiness gb = (GroupBusiness) IBOLookup.getServiceInstance(getApplicationContext(),GroupBusiness.class);
		Group patientGroup = getPatientGroup();
		PIDChecker pidUtil = PIDChecker.getInstance();
		String displayName = givenName + " " + surName;
		GenderBusinessBean genderBusiness = (GenderBusinessBean) IBOLookup.getServiceInstance(getApplicationContext(),GenderBusiness.class);
		Gender maleGender = genderBusiness.getMaleGender();
		Gender femaleGender = genderBusiness.getFemaleGender();
		Gender gender = null;
		Date birthDate = pidUtil.getDateFromPersonalID(personalId);
		
		IWTimestamp birthStamp = new IWTimestamp(birthDate);
		Integer genderId=null;
		if(pidUtil.isMale(personalId)){
			genderId=(Integer)maleGender.getPrimaryKey();
			gender=maleGender;
		}
		else if(pidUtil.isFemale(personalId)){
			genderId=(Integer)femaleGender.getPrimaryKey();
			gender=femaleGender;
		}
		Integer groupId = (Integer)patientGroup.getPrimaryKey();
		
		User user = ub.createUserByPersonalIDIfDoesNotExist(givenName,null,surName,personalId,gender,birthStamp);
		user.setPrimaryGroup(patientGroup);
		user.store();
		gb.addUser(groupId.intValue(),user);
		
		return user;
	}
	
	
	protected Group getPatientGroup(){
		String groupKey = "patientGroup";
		String roleKey = "patients";
		String groupId=null;
		Group group=null;
		try {
			ICApplicationBindingHome bindingHome = (ICApplicationBindingHome) IDOLookup.getHome(ICApplicationBinding.class);
			GroupHome gHome = (GroupHome) IDOLookup.getHome(Group.class);
			GroupBusiness gBusiness = (GroupBusiness) IBOLookup.getServiceInstance(getApplicationContext(),GroupBusiness.class);
			ICApplicationBinding binding= null;
			try {
				binding = bindingHome.findByPrimaryKey(groupKey);
				groupId = binding.getValue();
				group = gHome.findByPrimaryKey(Integer.valueOf(groupId));
			}
			catch (FinderException e) {
				
				try {
					group = gBusiness.createGroup("Patients");
					//group.setName("Patients");
					group.store();
					groupId = group.getPrimaryKey().toString();
					AccessController ac = getApplicationContext().getIWMainApplication().getAccessController();
					try{
						ac.createRoleWithRoleKey(roleKey);
					}
					catch(Exception roleEx){
						roleEx.printStackTrace();
					}
					ac.addRoleToGroup(roleKey,group,getApplicationContext());
					
					binding = bindingHome.create();
					binding.setKey(groupKey);
					binding.setValue(groupId);
					binding.store();
				}
				catch (CreateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		
		}
		catch (IDOLookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IBOLookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return group;
	}
	
	
	protected IWApplicationContext getApplicationContext(){
		return IWMainApplication.getDefaultIWApplicationContext();
	}
}
