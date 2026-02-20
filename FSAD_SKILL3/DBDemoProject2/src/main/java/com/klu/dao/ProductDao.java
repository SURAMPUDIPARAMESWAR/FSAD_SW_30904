package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.klu.entity.products;
import com.klu.util.ProductUtil;


public class ProductDao {
	   public void addProduct(products p) {
	        Transaction tx = null;
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            tx = s.beginTransaction();
	            s.save(p);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        }
	    }

	    /* -----------------------------
	     * READ
	     * ----------------------------- */
	    public List<products> getAllProducts() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery("FROM products", products.class).list();
	        }
	    }

	    public products getById(int productid) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.get(products.class, productid);
	        }
	    }

	    /* -----------------------------
	     * UPDATE
	     * ----------------------------- */
	    public void updateproduct(products p) {
	        Transaction tx = null;
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            tx = s.beginTransaction();
	            s.merge(p);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        }
	    }

	    /* -----------------------------
	     * DELETE
	     * ----------------------------- */
	    public void deleteProduct(int productid) {
	        Transaction tx = null;
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            tx = s.beginTransaction();
	            products p = s.get(products.class, productid);
	            if (p != null) s.delete(p);
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        }
	    }

	    /* -----------------------------
	     * SORTING (HQL)
	     * ----------------------------- */
	    public List<products> sortByPriceAsc() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p ORDER BY p.price ASC", products.class
	            ).list();
	        }
	    }

	    public List<products> sortByPriceDesc() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p ORDER BY p.price DESC", products.class
	            ).list();
	        }
	    }

	    public List<products> sortByQuantityDesc() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p ORDER BY p.quantity DESC", products.class
	            ).list();
	        }
	    }

	    /* -----------------------------
	     * PAGINATION
	     * ----------------------------- */
	    public List<products> getProductsWithPagination(int start, int size) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            Query<products> q = s.createQuery("FROM products", products.class);
	            q.setFirstResult(start);
	            q.setMaxResults(size);
	            return q.list();
	        }
	    }

	    /* -----------------------------
	     * AGGREGATE FUNCTIONS
	     * ----------------------------- */
	    public Long countAllProducts() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "SELECT COUNT(p) FROM products p", Long.class
	            ).uniqueResult();
	        }
	    }

	    public Long countAvailableProducts() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "SELECT COUNT(p) FROM products p WHERE p.quantity > 0",
	                Long.class
	            ).uniqueResult();
	        }
	    }

	    public void countByCategory() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            List<Object[]> list = s.createQuery(
	                "SELECT p.category, COUNT(p) FROM products p GROUP BY p.category"
	            ).list();

	            for (Object[] obj : list) {
	                System.out.println(obj[0] + " : " + obj[1]);
	            }
	        }
	    }

	    public void minMaxPrice() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            Object[] result = (Object[]) s.createQuery(
	                "SELECT MIN(p.price), MAX(p.price) FROM products p"
	            ).uniqueResult();

	            System.out.println("Min Price: " + result[0]);
	            System.out.println("Max Price: " + result[1]);
	        }
	    }

	    /* -----------------------------
	     * GROUP BY
	     * ----------------------------- */
	    public void groupByCategory() {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            List<Object[]> list = s.createQuery(
	                "SELECT p.category, COUNT(p) FROM products p GROUP BY p.category"
	            ).list();

	            for (Object[] obj : list) {
	                System.out.println(obj[0] + " -> " + obj[1]);
	            }
	        }
	    }

	    /* -----------------------------
	     * WHERE + LIKE
	     * ----------------------------- */
	    public List<products> getProductsByPriceRange(int min, int max) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            Query<products> q = s.createQuery(
	                "FROM products p WHERE p.price BETWEEN :min AND :max",
	                products.class
	            );
	            q.setParameter("min", min);
	            q.setParameter("max", max);
	            return q.list();
	        }
	    }

	    public List<products> nameStartsWith(String s1) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p WHERE p.name LIKE :val", products.class
	            ).setParameter("val", s1 + "%").list();
	        }
	    }

	    public List<products> nameEndsWith(String s1) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p WHERE p.name LIKE :val", products.class
	            ).setParameter("val", "%" + s1).list();
	        }
	    }

	    public List<products> nameContains(String s1) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p WHERE p.name LIKE :val", products.class
	            ).setParameter("val", "%" + s1 + "%").list();
	        }
	    }

	    public List<products> nameWithExactLength(int len) {
	        try (Session s = ProductUtil.getSessionFactory().openSession()) {
	            return s.createQuery(
	                "FROM products p WHERE LENGTH(p.name) = :len",
	                products.class
	            ).setParameter("len", len).list();
	        }
	    }
	
		
	

	
	
}
