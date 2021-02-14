package com.ecole;

import com.dao.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory fac = new XmlBeanFactory(r);

        // Utilisateur
        Utilisateur user = (Utilisateur)fac.getBean("user");
        System.out.println(user.getNom());

        Enseignant enseignant = (Enseignant)fac.getBean("e");
        System.out.println(enseignant.getNom());

        Eleve eleve = (Eleve)fac.getBean("el");
        Parent parent = (Parent)fac.getBean("p");
        eleve.addParent(parent);
        eleve.afficher();

        Fichier fichier = (Fichier)fac.getBean("f");
        fichier.addEleve(eleve);
        fichier.afficher();

        Devoir devoir = (Devoir)fac.getBean("devoir");
        devoir.addFichier(fichier);
        devoir.afficher();

        Mot mot = (Mot)fac.getBean("m");
        mot.addEleve(eleve);

        mot.addEnseignant(enseignant);
        mot.addParent(parent);
        mot.afficher();

        UtilisateurDAO userDao = (UtilisateurDAO) fac.getBean("utilisateurDAO");

        // DAO ajout d'un nouvel utilisateur
        userDao.setCoach(user);
        userDao.enregistrer();

        // DAO ENSEIGNANT
        EnseignantDAO enseignantDao = (EnseignantDAO) fac.getBean("enseignantDAO");
        enseignantDao.setEnseignant(enseignant);
        enseignantDao.enregistrer();

        // DAO ajout d'un nouvel utilisateur
        userDao.setCoach(user);
        userDao.enregistrer();

        // DAO PARENT
        ParentDAO parentDAO = (ParentDAO) fac.getBean("parentDAO");
        parentDAO.setParent(parent);
        parentDAO.enregistrer();

        // DAO CLASSE
        ClasseDAO classeDao = (ClasseDAO) fac.getBean("classeDAO");
        Classe classe = (Classe) fac.getBean("classe");
        classeDao.setClasse(classe);
        classeDao.enregistrer();

        // DAO ajout d'un nouvel utilisateur
        userDao.setCoach(user);
        userDao.enregistrer();

        // DAO ELEVE
        EleveDAO eleveDAO = (EleveDAO) fac.getBean("eleveDAO");
        eleveDAO.setEleve(eleve);
        eleveDAO.enregistrer();

        // DAO FICHIER
        FichierDAO fichierDAO = (FichierDAO) fac.getBean("fichierDAO");
        fichierDAO.setFichier(fichier);
        fichierDAO.enregistrer();


        // DAO DEVOIR
        DevoirDAO devoirDAO = (DevoirDAO) fac.getBean("devoirDAO");
        devoirDAO.setDevoir(devoir);
        devoirDAO.enregistrer();










    }
}


