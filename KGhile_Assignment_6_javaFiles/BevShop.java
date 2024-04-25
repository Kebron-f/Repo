//import java.util.ArrayList;
//
//public class BevShop implements BevShopInterface {
//	
//	private ArrayList<Order> orderList = new ArrayList<>();
//	 int currentOrderIndex;
//	
//	
//	public BevShop() {
//		
//	}
//	
//
//	public int findOrder(int orderNo) {
//		for (int i= 0; i < orderList.size(); i++) {
//			if(orderList.get(i).getOrderNo() == orderNo) {
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	public Order getCurrentOrder() {
//		return orderList.get(currentOrderIndex);
//		
//	}
//	
//	
//	public int getMaxNumOfFruits() {
//		return MAX_FRUIT;
//		
//	}
//	
//	public int getMaxOrderOfAlcohol() {
//		return MAX_ORDER_FOR_ALCOHOL;
//	}
//	
//	public int getMinAgeForAlchohol() {
//		return MIN_AGE_FOR_ALCOHOL;
//		
//	}
//	
//	public Order getOrderAtIndex(int index) {
//		return orderList.get(index);
//		
//	}
//	public boolean isEligibleForMore() {
//		return this.getNumOfAlcoholDrink()<= this.getMaxOrderForAlcohol();
//		
//	}
//
//	public boolean isValidAge() {
//		return this.getMinAgeForAlchohol() >= this.getCurrentOrder().getCustomer().getAge();
//		
//	}
//
//	public void sortOrders() {
//		for(int i = 0; i<orderList.size()-1; i++) {
//			int minOrder = i;
//			for (int j = i + 1; j < orderList.size(); j++) {
//				if(orderList.get(j).getOrderNo() < orderList.get(minOrder).getOrderNo()) {
//					minOrder = j;
//				}
//			}
//			Order swap = orderList.get(minOrder);
//			orderList.set(minOrder, orderList.get(i));
//			orderList.set(i, swap);
//		}
//	}
//	
//
//	public double totalMonthlySale() {
//		double sum = 0;
//		for (int i = 0; i < orderList.size(); i++) {
//			sum += orderList.get(i).calcOrderTotal();
//		}
//		return sum;
//	}
//	public int totalNumOfMonthlyOrders() {
//		return orderList.size();
//	}
//	
//	public double totalOrderPrice(int orderNo) {
//		return orderList.get(findOrder(orderNo)).calcOrderTotal();
//		
//	}
//
//	@Override
//	public boolean isValidTime(int time) {
//		
//		return time >= 8 && time <=23;
//	}
//
//	@Override
//	public int getMinAgeForAlcohol() {
//		
//		return MIN_AGE_FOR_ALCOHOL;
//	}
//
//	@Override
//	public boolean isMaxFruit(int numOfFruits) {
//		
//		return numOfFruits < getMaxNumOfFruits();
//	}
//
//	@Override
//	public int getMaxOrderForAlcohol() {
//		
//		return MAX_ORDER_FOR_ALCOHOL;
//	}
//
//	@Override
//	public int getNumOfAlcoholDrink() {
//		int num = 0;
//		
//		for(Beverage bv :getCurrentOrder().Beverages ) {
//			if(bv.getType()== Type.ALCOHOL) {
//				num++;
//			}
// 		}
//		return num;
//		
//
//		
//	}
//
//	@Override
//	public boolean isValidAge(int age) {
//		
//		return age >= MIN_AGE_FOR_ALCOHOL;
//	}
//
//	@Override
//	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
//		Customer newCustomer = new Customer(customerName, customerAge);
//		Order no= new Order(time, day, newCustomer);
//		 orderList.add( no);
//		 currentOrderIndex = orderList.indexOf(no);
//		
//		
//	}
//
//	@Override
//	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
//		
//		this.getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
//		
//	}
//
//	@Override
//	public void processAlcoholOrder(String bevName, Size size) {
//		ogetCurrentOrder().addNewBeverage(bevName, size);
//	}
//
//	@Override
//	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
//		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
//		
//	}
//
//	public String toString() {
//		return "Monthly Orders : " + this.totalNumOfMonthlyOrders() + "\n Monthly Sales : " + totalMonthlySale();
//	}
//
//
//	 
//	
//
//}
import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private ArrayList<Order> orders;
	private int currentOrderIndex;
	private int numAlcohol;
	
	public BevShop() {
		orders = new ArrayList<>();
	}

	@Override
	public boolean isValidTime(int time) {
		return (time >= MIN_TIME) && (time <= MAX_TIME);
	}

	@Override
	public boolean isEligibleForMore() {
		if(numAlcohol < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIndex = orders.indexOf(order);
		numAlcohol = 0;
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtien) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i= 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double sum = 0;
		for (int i = 0; i < orders.size(); i++) {
			sum += orders.get(i).calcOrderTotal();
		}
		return sum;
	}
	
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		for(int i = 0; i<orders.size()-1; i++) {
			int minOrder = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).getOrderNo() < orders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}
			Order swap = orders.get(minOrder);
			orders.set(minOrder, orders.get(i));
			orders.set(i, swap);
		}
		
	}

	public Order getCurrentOrder() {
		return orders.get(currentOrderIndex);
	}
	
	public int getNumOfAlcoholDrink() {
		return numAlcohol;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public boolean isMaxFruit(int i) {
		return i > MAX_FRUIT;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public String toString() {
		String str = "BEV SHOP\nMINTHLY SALES:"+ totalMonthlySale() + "\n\n";
		for (int i = 0; i < orders.size(); i++) {
			str +="Order "+i+ "\n";
			str +=orders.get(i).toString();
		}
		return str;
	}


	@Override
	public int getMaxNumOfFruits() {
		// TODO Auto-generated method stub
		return 0;
	}

	




	
}