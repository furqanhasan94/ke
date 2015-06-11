/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.learn;

import com.lsms.entities.Groups;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.security.acl.Group;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author furqan
 */

@WebServlet(urlPatterns = {"/S1"})
public class S1 extends HttpServlet{
    
    @EJB
    NewSessionBean newSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newSessionBean.persist();
    }
}
