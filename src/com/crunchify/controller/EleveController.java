package com.crunchify.controller;
 
import java.sql.SQLException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dao.EleveDAO;
import com.dao.UtilisateurDAO;
import com.ecole.Eleve;
import com.ecole.Parent;
import com.ecole.Utilisateur;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class EleveController {

	@RequestMapping("/eleve") 
	
	public ModelAndView show(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

	  //  String number = ServletRequestUtils.getStringParameter((ServletRequest) request, "number");
	  //  ModelAndView mav = new ModelAndView("/eleve.jsp");
		System.out.println("User Page Requested");
		
		Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory fac = new XmlBeanFactory(r);
        
        Utilisateur user = (Utilisateur)fac.getBean("user");
        
 		Eleve eleve = (Eleve)fac.getBean("el");
        Parent parent = (Parent)fac.getBean("p");
        eleve.addParent(parent);
        eleve.afficher();
        
        UtilisateurDAO userDao = (UtilisateurDAO) fac.getBean("utilisateurDAO");

        // DAO ajout d'un nouvel utilisateur
        userDao.setUser(user);
        userDao.enregistrer();
        
		// DAO ELEVE
        EleveDAO model = (EleveDAO) fac.getBean("eleveDAO");
        model.setEleve(eleve);
        model.enregistrer();
        
        String message = "<br><div style='text-align:center;'>" +
   		"<h3>********** Hello Eleve</h3></div><br><br>"
   		; return new ModelAndView("eleve", "message", message); }

}


