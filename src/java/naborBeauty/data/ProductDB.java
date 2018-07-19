/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naborBeauty.data;

import java.sql.*;

import naborBeauty.business.Product;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author hyejeongkim
 */
public class ProductDB {
 /**
  * static method to insert product to database
  * @param product 
  */
 public static void insert(Product product){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
 /**
  * static method to update with new information on a product
  * @param product 
  */
 public static void update(Product product){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(product);
            trans.commit();
            //System.out.println("find merge");
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
 /**
  * to find a product with same code and return the product
  * @param code
  * @return product
  */
 public static Product codeExists(String code){
     Product p = selectProduct(code);   
        return p;
 }
 /**
  * static method to delete a product 
  * @param product 
  */    
 public static void delete(Product product) {
          EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
 /**
  * static method to find a product which has the specific code
  * @param productCode
  * @return product
  */
 public static Product selectProduct(String productCode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " +
                "WHERE p.productCode = :productCode";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("productCode", productCode);
        try {
            Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
 }
 /**
  * select all product from database to display all products in table
  * @return List<Product>
  */       
 public static List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<Product>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();  
   
        String qString = "SELECT p FROM Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        try {
            products = (List<Product>) q.getResultList();
            return (List<Product>) products;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
        
   