import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface , Comparable  {

	  private int  orderTime ;                                                
	  private Day orderDay ;                                                  
	  private Customer customer ;                                                 
	  private int orderNo;  
	  ArrayList<Beverage> Beverages = new ArrayList<>();
	  
	  
	  
	  public Order(int orderTime, Day orderDay, Customer cust) {
		  this.orderTime =orderTime;
		  this.orderDay = orderDay;
		  this.customer = cust;
		  this.orderNo = generateOrder();
	  }
	  
	 public void addNewBeverage( String bevName, Size  size) {
		 Alcohol alc = new Alcohol(bevName , size ,this.isWeekend());
		 Beverages.add(alc);
	 }
	 
	 public void addNewBeverage( String bevName,  Size size, boolean extraShot,  boolean extraSyrup) {
		 Coffee cof = new Coffee( bevName,  size, extraShot, extraSyrup);
		 Beverages.add(cof);
		
	 }
	 
	 public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		 Beverage smo = new Smoothie(bevName, size, numOfFruits,  addProtein);
		 Beverages.add(smo);
	 }
	 
	 public double calcOrderTotal() {
		 double total = 0;
		 for(Beverage bg : Beverages) {
			 total += bg.calcPrice();
		 }
		 return total;
	 }
	
		 
	 
	 public int findNumOfBeveType(Type type) {
		 int num = 0;
		 for (Beverage bv : Beverages) {
			 if(bv.getType() == type) 
				 num++;
			 }
		 return num;
	 }
	 
	 

	 public int generateOrder() {
		 Random rand = new Random();
		 return rand.nextInt(9000-1000 +1) + 1000;
	 }
	 
	 public Beverage getBeverage(int itemNo) {
		 return Beverages.get(itemNo);
	 }
	 
	 public Customer getCustomer() {
		 return  new Customer (customer);
	 }
	 
	 public Day getDay() {
		 return getOrderDay();
		 
	 }

	 public Day getOrderDay() {
		 return this.orderDay;
		 
	 }
	 
	 public int getOrderNo() {
		 return this.orderNo;
		 
	 }
	 public int getOrderTime() {
		 return this.orderTime;
	 }
	 
	 public int getTotalItems() {
		 
		 return Beverages.size();
		 
	 }
	 
	 public  boolean isWeekend() {
		 
		 return this.getDay() == Day.SATURDAY || this.getDay() == Day.SUNDAY;
		 
	 }
	 
	 public String toString () {
		 return orderDay + " " + orderTime + " " + customer.getName() + " " + customer.getAge();
	 }

	@Override
	public int compareTo(Object o) {
		if(((Order) o).getOrderNo() == this.getOrderNo()) {
			return 0;
		}
		else if(((Order) o).getOrderNo() < this.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	 
	 
	  
	  

	  
	  
	  
}



