/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.*;

/**
 *
 * @author Alejandro
 */
public class JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        CONFIGURAR PRIMERO EL ARCHIVO persistence.xml:
        En services -> Databases -> Java DB.
        click derecho 'start server'
        click derecho 'Create Database'
        meter los datos de la base de datos en persistence.xml
        En javax.persistence.jdbc.url despues del puerto 1527/ va el nombre de la base de datos
        
        Para las nuevas entidades deben añadirse al archivo de persistence.xml con <class>
        */

        // TODO Auto-generated method stub
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        // 3-Persists the book to the database
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
        
        em.close();
        emf.close();
        
    }
    
}
