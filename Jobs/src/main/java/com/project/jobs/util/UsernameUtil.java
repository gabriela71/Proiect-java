/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.util;

import com.project.jobs.common.UserDetails;
import com.project.jobs.ejb.UserBean;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author stefi
 */
public class UsernameUtil {
   
   // @Inject
  //  private UserBean userBean;
    
    public static String createUsername(String nume, String prenume,List<UserDetails> users){
        
        String username;
        String litera;
        if(nume.length()>5)
        {
            username=nume.substring(0, 5);
        }
        else
        {
            username=nume;
        }
        litera= prenume.substring(prenume.length()-1,prenume.length());
        username+=litera;
        
       
        for(UserDetails user : users)
        {
            int i=1;
            while(username.equals(user.getUsername()))
            {
                litera=prenume.substring(prenume.length()-i-1,prenume.length()-i);
                username+=litera;
            }
        }
       
       return username;
        
    }
}
