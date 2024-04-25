
public class Alcohol extends Beverage {
	
	protected final double WEEKEND_PRICE = 0.6;
	
	protected boolean isWeekend ;
	
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName,Type.ALCOHOL, size);
		
			this.isWeekend = isWeekend;
	}
	
	public double calcPrice() {
		double price = BASE_PRICE;
		if(super.getSize() == Size.MEDIUM)
			price += ADD_SIZE_PRICE;
		else if(super.getSize() == Size.LARGE)
			price += (2 * ADD_SIZE_PRICE);
		
		if(isWeekend)
			price += WEEKEND_PRICE;
		
		return price;
    
    	
    	
    	
    
    	
	}
	public boolean isWeekend() {
		return isWeekend;
	}
	
	public boolean equals(Object obj) {
		Alcohol alc = (Alcohol) obj;
		return this == obj  && getClass() == obj.getClass() && isWeekend() == alc.isWeekend();
	}
	

	
	public String toString() {
		return "---------Drink  " + getBevName() + " "+ getSize() + " " + getType() + " $" +  calcPrice();
	}
	

}
