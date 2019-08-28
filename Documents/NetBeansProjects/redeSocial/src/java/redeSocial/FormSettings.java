/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocial;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Andrik
 */
@ManagedBean
@SessionScoped
public class FormSettings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isPortuguese=true;
	private final Locale English=new Locale("en");
	private final Locale Portuguese=new Locale("pt");

	public Locale getLocale(){
		if(isPortuguese)
			return Portuguese;
		else
			return English;
	}
	
	public void swapLocale1(ActionEvent event){
		switchLocale();
	}
	
	public void swapLocale2(ValueChangeEvent event){
		Boolean frag = (Boolean)event.getNewValue();
		if(frag)
			switchLocale();
	}
	
	public void switchLocale(){
		isPortuguese=!isPortuguese;
		Locale newLocale;
		if(isPortuguese)
			newLocale=Portuguese;
		else
			newLocale=English;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(newLocale);
	}
}
