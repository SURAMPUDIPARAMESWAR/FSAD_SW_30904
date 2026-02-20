package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.products;
import com.klu.util.ProductUtil;


public class ProductDao {
	public void saveProduct(products st) {
	try (Session s= ProductUtil.getSessionFactory().openSession()){
		Transaction tx=s.beginTransaction();
		s.save(st);
		tx.commit();
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
	public List<products> getAllProducts(){
		try (Session s= ProductUtil.getSessionFactory().openSession()){
			return s.createQuery("from products",products.class).list();	
		}
	}
	
	public products getById(int productid) {
		try (Session s= ProductUtil.getSessionFactory().openSession()){
				return s.get(products.class, productid);
		}			
	}
	
	public void updateproduct(products st) {
		Transaction tx=null;
		try (Session s= ProductUtil.getSessionFactory().openSession()){
			 tx=s.beginTransaction();
			s.merge(st);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}	
	}
	
	public void deleteProduct(int productid) {
		Transaction tx=null;
		try (Session s= ProductUtil.getSessionFactory().openSession()){
			 tx=s.beginTransaction();
			 products st = s.get(products.class, productid);
			 if(st!=null) s.delete(st);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}	
	}

	
		
	

	
	
}
