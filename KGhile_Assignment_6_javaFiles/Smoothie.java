
public class Smoothie extends Beverage {
	private final double PROTEIN_COST =1.5;
	private final double FRUIT_COST =0.5;
	protected int numOfFruits;
	private boolean addProtein;
	
	
	
	   public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		   super(bevName ,Type.SMOOTHIE , size);
		   this.numOfFruits =numOfFruits;
		   this.addProtein = addProtein;
		   
	   }
	   

		public double calcPrice() {
			double price = BASE_PRICE + (numOfFruits * FRUIT_COST);
			
			if(getSize() == size.MEDIUM) {
				price += (ADD_SIZE_PRICE); 
			}
			else if(getSize() == size.LARGE) {
				price += (ADD_SIZE_PRICE * 2); 
			}
			
			if (addProtein) {
				price +=  PROTEIN_COST ;	
			}
			
			return price;
			
		}
		
		public boolean equals(Object obj) {
			Smoothie smo = (Smoothie) obj;
			return this == obj  && getClass() == obj.getClass()  ;
				
			
		}
		
		public boolean getAddProtein() {
			return  addProtein;
		}
		
		public int getNumOfFruits() {
			return numOfFruits;
			
		}
		
		public String toString() {
			 return "---------Drink  " + getBevName() + " "+ getSize() + " " + getType()+ " " +getNumOfFruits()+ " $" +  calcPrice();
		}

}
