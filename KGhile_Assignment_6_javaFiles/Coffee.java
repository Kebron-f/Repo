
public class Coffee extends Beverage {
	
	protected final double ADD_EXTRA_SHOT = 0.5;
	protected final double ADD_EXTRA_SYRUP = 0.5;
	protected boolean extraShot;
	protected boolean extraSyrup;
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup){
		super(bevName , Type.COFFEE , size);

		this.extraShot =extraShot;
		this.extraSyrup =extraSyrup;
	}
	
	
    public double calcPrice() {
		double price =0 ;
		switch(size) {
		case SMALL:
			price = BASE_PRICE ;
			break;
		case MEDIUM:
			price = BASE_PRICE + ADD_SIZE_PRICE ;
			break;
		
    	case LARGE :
    		price = BASE_PRICE + 2* ADD_SIZE_PRICE ;
    		break;
		}
    	if (extraShot) 
    		price += ADD_EXTRA_SHOT;
    	
    	if(extraSyrup)
    		price += ADD_EXTRA_SYRUP;
    	
    	return price;
    	
  
	}
		
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}	

	
	public boolean equals(Object obj) {
		Coffee cof = (Coffee) obj;
		return this == obj  && getClass() == obj.getClass() && cof.getExtraShot()==extraShot && cof.getExtraSyrup() == extraSyrup ;
	}
		
		
	
	

	
	public String toString() {
		return "---------Drink " + getBevName() + " "+ getSize() + " " + getType()+ " " + " $" +  calcPrice();
	}

}
