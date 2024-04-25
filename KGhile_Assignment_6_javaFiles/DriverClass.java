 
 

public class DriverClass {

	public static void main(String[] args) {

		int tempAge, tempOrderNo;

		Customer tempCustomer;
		int anInvalidTime = 8, anotherInvalidTime = 24;

		BevShop b = new BevShop();
		
		if ( !b.isValidTime(anInvalidTime))
			System.out.println( "Failed the test for invalid time!!"); 
		 
		if ( b.isValidTime(anotherInvalidTime))
			System.out.println( "Failed the test for invalid time!!");  
		
		System.out.println(b.getMaxOrderForAlcohol()); 
		System.out.println(b.getMinAgeForAlcohol()); 
		System.out.println("Start a new order"); 
		b.startNewOrder(12, Day.MONDAY, "John", 23);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 

		tempCustomer = b.getCurrentOrder().getCustomer();

		tempCustomer.setName("kim");
		tempCustomer.setAge(10);

		System.out.println(b.getCurrentOrder().getCustomer().getName()); 
		System.out.println(b.getCurrentOrder().getCustomer().getAge()); 

		tempAge = b.getCurrentOrder().getCustomer().getAge();
		System.out.println(b.isValidAge(tempAge)); 
		if (b.isValidAge(tempAge)) {
			System.out.println("Add alcohol drink"); 

			b.processAlcoholOrder("Mohito", Size.SMALL);
		}

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println(b.isEligibleForMore()); // true

		System.out.println("Add second alcohol drink"); 
		b.processAlcoholOrder("tonic", Size.LARGE);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println(b.getNumOfAlcoholDrink()); 

		System.out.println("Add third alcohol drink"); 
														
		b.processAlcoholOrder("wine", Size.SMALL);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 

		System.out.println(b.getNumOfAlcoholDrink()); 

		if (!b.isEligibleForMore())
			System.out.println("Maximum alcohol drink for this order"); 

		System.out.println("Add a COFFEE to order"); 
		b.processCoffeeOrder("cappuchino", Size.SMALL, true, true);
		System.out.println(b.getNumOfAlcoholDrink()); 

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1) {
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); 
		}

		else

			System.out.println("order not found! Should not get to here!");

		System.out.println("Start a new order"); 

		b.startNewOrder(10, Day.SUNDAY, "Mary", 12);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println("Add a SMOOTHIE to order"); 
		b.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println("Add a COFFEE to order");
		b.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println(b.getNumOfAlcoholDrink()); // 0
		if (b.isValidAge(b.getCurrentOrder().getCustomer().getAge())) {
			System.out.println("Should not get to here!!!");
			b.processAlcoholOrder("mohito", Size.MEDIUM);
		} else
			System.out.println("Age not appropriate for alcohol drink!!"); 

		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1)
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); 
		else {
			System.out.println("Order not found. Should no get to here!!");
		}

		int numOfFruits = 6;
		if (b.isMaxFruit(numOfFruits)) {
			
			System.out.println("Maximum number of fruits\n"); 
																
		}
		numOfFruits = 5;

		b.processSmoothieOrder("Detox", Size.LARGE, numOfFruits, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); 
		System.out.println("Total amount for all orders:" + b.totalMonthlySale()); 
		}

}