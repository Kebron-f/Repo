
public abstract class Beverage  {
	
	protected final double BASE_PRICE =2.0;
	protected final double ADD_SIZE_PRICE =0.5;
	protected String bevName ="";                    
	protected Type type ;                       
	protected Size size; 
	
 
	  
	public Beverage(String bevName, Type type, Size size) {
		this.bevName =bevName;
		this.type= type;
		this.size =size;
		 
		  	}
	 
	public Beverage() {
			
		}

	public double getBasePrice() {
			  return BASE_PRICE;
	    }
	
	public Type getType() {
		return type;
	 	}
	 
	public String getBevName() {
			 return bevName;
	 }
	 
	public Size getSize() {
		return size;
			  
		  }
		  
   public double addSizePrice() {
		return  ADD_SIZE_PRICE ;
			  
		  }
   abstract double calcPrice() ;
			  
    public String toString() {
			  return "---------Drink ;" + getBevName() + " " + getType() + " " + getSize() + " " ;
		  }
		  
   public boolean equals(Object obj) {
	   Beverage bev = (Beverage) obj;
		return this == obj  && getClass() == obj.getClass() &&  bev.getType() == getType();
	}
		
	  
   }
		
	 
	


