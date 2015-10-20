/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.beans;

import com.lsms.entities.Block;
import com.lsms.entities.Grids;
import com.lsms.entities.Groups;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author furqan
 */
@Named
@Stateless
public class GridBean {

    @PersistenceContext
    EntityManager em;

    private String grName ;
    private String blName ;
    private boolean extState;                              //    for chescking extended ls status of grid
    private boolean unSchLsState ;                         //    for chescking unscheduled ls status of grid
    private boolean overloadState ;                        //    for chescking overloading status of grid
    private Query q;
    private List<String> nameList ;
    private List<Grids> gridList;
    private static final String qForB_id = "SELECT b FROM Block b WHERE b.blockName = :blName" ;

   
    /**
     * @return the grName
     */
    public String getGrName() {
        return grName;
    }

    /**
     * @param grName the grName to set
     */
    public void setGrName(String grName) {
        this.grName = grName;
    }

    /**
     * @return the blName
     */
    public String getBlName() {
        return blName;
    }

    /**
     * @param blName the blName to set
     */
    public void setBlName(String blName) {
        this.blName = blName;
    }
   
    /**
     * @return the nameList
     */
    public List<String> getNameList() {
        blockNames();
        return nameList;
    }

    /**
     * @param nameList the nameList to set
     */
    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
    
    /**
     * @return the extState
     */
    public boolean getExtState() {
        return extState;
    }

    /**
     * @param extState the extState to set
     */
    public void setExtState(boolean extState) {
        this.extState = extState;
    }

    /**
     * @return the unSchLsState
     */
    public boolean getUnSchLsState() {
        return unSchLsState;
    }

    /**
     * @param unSchLsState the unSchLsState to set
     */
    public void setUnSchLsState(boolean unSchLsState) {
        this.unSchLsState = unSchLsState;
    }

    /**
     * @return the overloadState
     */
    public boolean getOverloadState() {
        return overloadState;
    }

    /**
     * @param overloadState the overloadState to set
     */
    public void setOverloadState(boolean overloadState) {
        this.overloadState = overloadState;
    }

    /**
     * @return the gridList
     */
    public List<Grids> getGridList() {
        listOfGridsNames();
        return gridList;
    }

    /**
     * @param gridList the gridList to set
     */
    public void setGridList(List<Grids> gridList) {
        this.gridList = gridList;
    }

    
    public void blockNames(){
        q = em.createQuery("SELECT b.blockName FROM Block b");
        setNameList(q.getResultList());
    }
    
    public void gridCreator(){
        
        Grids g = new Grids();
        Block b ;
        
        g.setGridName(grName);
        q = em.createQuery(qForB_id).setParameter("blName", getBlName());
        b = (Block) q.getSingleResult();
        g.setBlockId(b);
        em.persist(g);
    }

    public void listOfGridsNames(){
        q = em.createQuery("SELECT g FROM Grids g");
        setGridList(q.getResultList());
    }


}
