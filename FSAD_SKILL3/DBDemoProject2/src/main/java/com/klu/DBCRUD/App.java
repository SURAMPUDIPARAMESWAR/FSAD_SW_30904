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
    	
    	
    	ProductDao pdao = new ProductDao();
    	
    	 pdao.addProduct(new products(201, "Laptop", 55000, "Electronics", 10));
         pdao.addProduct(new products(202, "Mouse", 500, "Electronics", 25));
         pdao.addProduct(new products(203, "Keyboard", 1200, "Electronics", 15));
         pdao.addProduct(new products(204, "Chair", 3500, "Furniture", 5));
         pdao.addProduct(new products(205, "Table", 7000, "Furniture", 3));
         pdao.addProduct(new products(206, "Bottle", 300, "Kitchen", 20));

         /* -------------------------------------------------
          * 3. Sort by price
          * ------------------------------------------------- */
         System.out.println("\nProducts sorted by price (ASC):");
         List<products> asc = pdao.sortByPriceAsc();
         asc.forEach(System.out::println);

         System.out.println("\nProducts sorted by price (DESC):");
         List<products> desc = pdao.sortByPriceDesc();
         desc.forEach(System.out::println);

         /* -------------------------------------------------
          * 4. Sort by quantity (highest first)
          * ------------------------------------------------- */
         System.out.println("\nProducts sorted by quantity (DESC):");
         List<products> qty = pdao.sortByQuantityDesc();
         qty.forEach(System.out::println);

         /* -------------------------------------------------
          * 5. Pagination
          * ------------------------------------------------- */
         System.out.println("\nFirst 3 products:");
         List<products> page1 = pdao.getProductsWithPagination(0, 3);
         page1.forEach(System.out::println);

         System.out.println("\nNext 3 products:");
         List<products> page2 = pdao.getProductsWithPagination(3, 3);
         page2.forEach(System.out::println);

         /* -------------------------------------------------
          * 6. Aggregate functions
          * ------------------------------------------------- */
         System.out.println("\nTotal products count: " + pdao.countAllProducts());
         System.out.println("Products with quantity > 0: " + pdao.countAvailableProducts());

         System.out.println("\nCount grouped by category:");
         pdao.countByCategory();

         System.out.println("\nMinimum and Maximum price:");
         pdao.minMaxPrice();

         /* -------------------------------------------------
          * 7. GROUP BY category
          * ------------------------------------------------- */
         System.out.println("\nProducts grouped by category:");
         pdao.groupByCategory();

         /* -------------------------------------------------
          * 8. Filter by price range
          * ------------------------------------------------- */
         System.out.println("\nProducts between 1000 and 10000:");
         List<products> range = pdao.getProductsByPriceRange(1000, 10000);
         range.forEach(System.out::println);

         /* -------------------------------------------------
          * 9. LIKE queries
          * ------------------------------------------------- */
         System.out.println("\nNames starting with 'L':");
         pdao.nameStartsWith("L").forEach(System.out::println);

         System.out.println("\nNames ending with 'e':");
         pdao.nameEndsWith("e").forEach(System.out::println);

         System.out.println("\nNames containing 'top':");
         pdao.nameContains("top").forEach(System.out::println);

         System.out.println("\nNames with length = 5:");
         pdao.nameWithExactLength(5).forEach(System.out::println);
    	}	
    	
    	
    
}
