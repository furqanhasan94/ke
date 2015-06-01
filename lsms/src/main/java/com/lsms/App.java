package com.lsms;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Hello world!
 *
 */


@ManagedBean
@RequestScoped

public class App 
{
    public void App(){}
    
    private String name ;
    
    public void setName(String n){
        name = n ;
    }
    
    public String getName(){
        return name;
      }
}
