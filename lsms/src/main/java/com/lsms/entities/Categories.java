/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "catagories")
public class Categories implements Serializable {
   
    @Id
    @Column(name = "cat_id")
    private String catId;
    
    @NotNull
    @Column(name = "cat_name")
    private String catName ;
    
    public String getCatId(){
        return catId ;
    }
    
    public String getCatName(){
        return catName ;
    }
    
    
    public void setCatId(String id){
        this.catId = id ;
    }
    
    public void setCatName(String name){
        this.catName = name ;
    }
    
    @Override
    public String toString() {
        return "com.lsms.entities.Categories[ id=" + catId + " ]";
    }
    
}
