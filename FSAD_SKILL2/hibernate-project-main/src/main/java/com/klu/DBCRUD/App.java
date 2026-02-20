package com.klu.DBCRUD;

import java.util.List;

//import java.util.List;

//import org.hibernate.SessionFactory;

import com.klu.dao.ProductDao;
import com.klu.entity.products;
//import com.klu.util.UserUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //SessionFactory sf = UserUtil.getSessionFactory();
    	
    	products p1 = new products();
    	p1.setProductid(76);
    	p1.setName("Telephone");
    	p1.setCategory("Communication");
    	p1.setPrice(5000);
    	ProductDao pdao = new ProductDao();
    	pdao.saveProduct(p1);
    	products p2 = new products();
    	p2.setProductid(76);
    	p2.setName("Car");
    	p2.setCategory("Travel");
    	p2.setPrice(1000000);
    	pdao.saveProduct(p2);
    	
    	List<products> li1=pdao.getAllProducts();
    	for(products st:li1) {
    		System.out.println(st);
    	}
    	
    	
    	products st1 = pdao.getById(3);
    	System.out.println(st1);
    	
    	products st2 = new products();
    	st2.setName("PlayStation");
    	st2.setCategory("Gaming");
    	st2.setPrice(500000);
    	pdao.updateproduct(st2);
    	System.out.println(st2);
    	
    	pdao.deleteProduct(2);
    	
    	List<products> li2=pdao.getAllProducts();
    	for(products st:li2) {
    		System.out.println(st);
    	}	
    	
    	
    }
}
