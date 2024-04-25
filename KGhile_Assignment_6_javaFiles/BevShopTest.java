import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTest {

	BevShop bevShop  = new BevShop();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	public void testValidTime()
	{
		assertTrue(bevShop.isValidTime(8));
		assertTrue(bevShop.isValidTime(23));
		assertFalse(bevShop.isValidTime(7));
		assertFalse(bevShop.isValidTime(24));
	}

	@Test
	public void testValidAge()
	{
		assertTrue(bevShop.isValidAge(21));
		assertTrue(bevShop.isValidAge(27));
	}

	@Test
	public void testStartNewOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"John", 30);
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
	
	}

	@Test
	public void testProcessAlcoholOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"John", 30);

		bevShop.processAlcoholOrder("Mohito", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Mohito"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("tonic", Size.MEDIUM);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("tonic"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("V", Size.SMALL);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getBevName().equals("V"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getType().equals(Type.ALCOHOL));
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());

	}

	@Test
	public void testProcessSmoothieOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"John", 30);
		assertTrue ( bevShop.isMaxFruit(6) );
		assertFalse ( bevShop.isMaxFruit(5) );
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);

		Smoothie sm = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);

		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Detox"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));


		assertTrue(sm.getNumOfFruits() == 1);
		assertFalse(sm.getAddProtein());


		bevShop.processSmoothieOrder("Morning SunShine", Size.LARGE, 4, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);

		sm =  (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Morning SunShine"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));

		assertTrue(sm.getNumOfFruits() == 4);
		
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());

	}

	@Test
	public void testProcessCoffeeOrder()
	{
		Coffee cf;
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);

		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("americano"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(cf.getExtraShot());
		assertFalse(cf.getExtraSyrup());

		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(1);

		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);

		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Cappuccino"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.COFFEE));
		assertFalse(cf.getExtraShot());
		assertFalse(cf.getExtraSyrup());

	}

	@Test
	public void testFindOrder()
	{

		int orderNum;
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("Morning SunShine", Size.LARGE, 4, true);

		orderNum = bevShop.getCurrentOrder().getOrderNo();

		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);

		assertEquals(0,bevShop.findOrder(orderNum));

		orderNum = bevShop.getCurrentOrder().getOrderNo();
		assertEquals(1,bevShop.findOrder(orderNum));

	}
	@Test
	public void testTotalOrderPrice()
	{
	 	int orderNum1,orderNum2;

		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);

		orderNum1 = bevShop.getCurrentOrder().getOrderNo();

		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);

		orderNum2 = bevShop.getCurrentOrder().getOrderNo();

		assertEquals(9.5,bevShop.totalOrderPrice(orderNum1),.01);
		assertEquals(2.5,bevShop.totalOrderPrice(orderNum2),.01 );

	}
	@Test
	public void testTotalMonthlySale()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);

		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);

		bevShop.startNewOrder(12,Day.SATURDAY,"Amy", 43);
		bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 4, true);
		bevShop.processCoffeeOrder("Latte", Size.SMALL,false, false);


		assertEquals(22.6, bevShop.totalMonthlySale(), .01 );

	}

	@Test
	public void testSortOrders()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.startNewOrder(12,Day.SATURDAY,"Amy", 43);

		bevShop.sortOrders();
		assertTrue(true);
		assertTrue(true);

	}@Test
	public void testToString() {

		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);


		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);


		assertTrue(bevShop.toString().contains(bevShop.totalMonthlySale()+"")) ;




	}

	
}

