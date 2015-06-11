/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.learn;

import com.lsms.entities.Block;
import com.lsms.entities.Categories;
import com.lsms.entities.Feeder;
import com.lsms.entities.Grids;
import com.lsms.entities.Groups;
import com.lsms.entities.Overloading;
import com.lsms.entities.Transformer;
import com.lsms.entities.UnscheduledLs;
import java.sql.Date;
import java.sql.Time;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author furqan
 */
@Stateless
public class NewSessionBean {
    
    @PersistenceContext
    EntityManager em ;
    
    Time et = new Time(11, 31, 0);
    Time st = new Time(10, 36, 0);
    Date ed = new Date(2015, 6, 11);
    
    public void persist(){
        
        Grids g;
        UnscheduledLs uls = new UnscheduledLs();
        uls.setEntryTime(et);
        uls.setEntryDate(ed);
        uls.setReason("fault in transmission");
        uls.setStartTime(st);
        uls.setEndTime(null);
        g = em.find(Grids.class, "gr_1");
        uls.setGridId(g);
        em.persist(uls);
    }
    

}