/*
 * $Id: PatientAcceptanceAgreement.java,v 1.7 2005/11/15 23:52:35 tryggvil Exp $
 * Created on 24.10.2005 in project se.idega.ehealth
 * 
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to
 * license terms.
 */
package se.idega.ehealth.presentation;

import java.io.IOException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import se.idega.ehealth.business.PatientLogicBean;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.ui.BackButton;

/**
 * <p>
 * A UI Component to display the "Agreement" that a patient has to accept before
 * being created as a user.
 * </p>
 * Last modified: $Date: 2005/11/15 23:52:35 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.7 $
 */
public class PatientAcceptanceAgreement extends IWBaseComponent implements ActionListener {

	// static constants:
	static String BUNDLE_IDENTIFIER = "se.idega.ehealth";
	//localization keys
	static String ACCEPT_KEY = "patientacceptance.accept";
	static String NOT_ACCEPT_KEY = "patientacceptance.not_accept";
	//parameters
	static String PARAM_GIVEN_NAME = "nbs_given_name";
	static String PARAM_SURNAME = "nbs_surname";
	static String PARAM_PERSONAL_ID = "nbs_personal_id";
	// instance variables:
	private String givenName;
	private String surName;
	private String personalId;
	private String uriToRedirectTo;

	/**
	 * @return Returns the uriToRedirectTo.
	 */
	public String getUriToRedirectTo() {
		return uriToRedirectTo;
	}

	/**
	 * @param uriToRedirectTo
	 *            The uriToRedirectTo to set.
	 */
	public void setUriToRedirectTo(String uriToRedirectTo) {
		this.uriToRedirectTo = uriToRedirectTo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.presentation.IWBaseComponent#decode(javax.faces.context.FacesContext)
	 */
	public void decode(FacesContext context) {
	}

	/**
	 * <p>
	 * TODO tryggvil describe method setGivenName
	 * </p>
	 * 
	 * @param prmGivenName
	 */
	private void setGivenName(String prmGivenName) {
		this.givenName = prmGivenName;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method setSurName
	 * </p>
	 * 
	 * @param prmSurName
	 */
	private void setSurName(String prmSurName) {
		this.surName = prmSurName;
	}

	/**
	 * @return Returns the personalId.
	 */
	public String getPersonalId() {
		return personalId;
	}

	/**
	 * @param personalId
	 *            The personalId to set.
	 */
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	/**
	 * 
	 */
	public PatientAcceptanceAgreement() {
		super();
	}

	public void initializeComponent(FacesContext context) {
		IWResourceBundle iwrb = getIWResourceBundle(context, BUNDLE_IDENTIFIER);
		String prmGivenName = (String) context.getExternalContext().getRequestParameterMap().get(PARAM_GIVEN_NAME);
		String prmSurName = (String) context.getExternalContext().getRequestParameterMap().get(PARAM_SURNAME);
		String prmPersonalId = (String) context.getExternalContext().getRequestParameterMap().get(PARAM_PERSONAL_ID);
		if (prmGivenName != null) {
			setGivenName(prmGivenName);
		}
		if (prmSurName != null) {
			setSurName(prmSurName);
		}
		if (prmPersonalId != null) {
			setPersonalId(prmPersonalId);
		}
		HtmlForm form = new HtmlForm();
		add(form);
		HtmlCommandButton acceptButton = new HtmlCommandButton();
		acceptButton.setValue(iwrb.getLocalizedString(ACCEPT_KEY, "I accept"));
		acceptButton.addActionListener(this);
		BackButton button = new BackButton(iwrb.getLocalizedString(NOT_ACCEPT_KEY, "I do not accept"));
		form.getChildren().add(acceptButton);
		form.getChildren().add(button);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.ActionListener#processAction(javax.faces.event.ActionEvent)
	 */
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean succesFul = getPatientLogic().createAndLoginPatient(getPersonalId(), getGivenName(), getSurName(),
				context);
		if (succesFul) {
			// try do redirect:
			String uri = getUriToRedirectTo();
			try {
				context.getExternalContext().redirect(uri);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * <p>
	 * TODO tryggvil describe method getSurName
	 * </p>
	 * 
	 * @return
	 */
	private String getSurName() {
		return surName;
	}

	/**
	 * <p>
	 * TODO tryggvil describe method getGivenName
	 * </p>
	 * 
	 * @return
	 */
	private String getGivenName() {
		return givenName;
	}

	public PatientLogicBean getPatientLogic() {
		return new PatientLogicBean();
	}

	/**
	 * @see javax.faces.component.UIComponentBase#saveState(javax.faces.context.FacesContext)
	 */
	public Object saveState(FacesContext ctx) {
		Object values[] = new Object[5];
		values[0] = super.saveState(ctx);
		values[1] = personalId;
		values[2] = givenName;
		values[3] = surName;
		values[4] = uriToRedirectTo;
		return values;
	}

	/**
	 * @see javax.faces.component.UIComponentBase#restoreState(javax.faces.context.FacesContext,
	 *      java.lang.Object)
	 */
	public void restoreState(FacesContext ctx, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(ctx, values[0]);
		personalId = (String) values[1];
		givenName = (String) values[2];
		surName = (String) values[3];
		uriToRedirectTo = (String) values[4];
	}
}
