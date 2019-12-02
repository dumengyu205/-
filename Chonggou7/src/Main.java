import movie.*;
import customer.*;
import rental.*;
import java.util.Enumeration;
import java.util.Vector;
public class Main {
  public static void main(String [] args) {
	  Movie movie1 = new Movie("两只两虎",0);
	  Movie movie2 = new Movie("千与千寻",1); 
	  Movie movie3 = new Movie("罗小黑战记",2); 
	  Rental rental1 = new Rental(movie1,12); 
	  Rental rental2 = new Rental(movie2,8);
	  Rental rental3 = new Rental(movie3,6);
	  Customer customer = new Customer("王陆"); 
	  customer.addRental(rental1);
	  customer.addRental(rental2);  
	  customer.addRental(rental3);  
	  System.out.println(customer.statement());
  }
}
//继承//