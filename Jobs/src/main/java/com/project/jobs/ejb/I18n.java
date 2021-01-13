/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Alex
 */
@Stateful
@SessionScoped
public class I18n {

    Locale locale_en=new Locale("en");
    Locale locale_ro=new Locale("ro");
    Locale locale_de=new Locale("de");
    
    String language="ro";
    
    ResourceBundle resourceBundle_en = ResourceBundle.getBundle("com.project.i18n.language", locale_en);
    ResourceBundle resourceBundle_ro = ResourceBundle.getBundle("com.project.i18n.language", locale_ro);
    ResourceBundle resourceBundle_de = ResourceBundle.getBundle("com.project.i18n.language", locale_de);
    
    public ResourceBundle getResourceBundle() {
        if(language.equals("ro")) return resourceBundle_ro;
        if(language.equals("de")) return resourceBundle_de;
        if(language.equals("en")) return resourceBundle_en;
        
        return resourceBundle_en;
    }
    
    public void changeLanguage(String newLanguage){
        language=newLanguage;
    }
    
    
    
    
    
    
}
