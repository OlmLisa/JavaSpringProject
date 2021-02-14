package com.crunchify.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.DevoirDAO;

import com.ecole.Devoir;
@Controller
public class MotController {

    @RequestMapping(value = "/devoir", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("devoirs", "devoir", new Devoir());
    }
 
    @RequestMapping(value = "/addDevoir", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("devoir")Devoir devoir, 
      BindingResult result, DevoirDAO model) throws SQLException {
        if (result.hasErrors()) {
            return "error";
        }
        
        model.setDevoir(devoir);
        model.enregistrer();
        return "devoirView";
    }
}