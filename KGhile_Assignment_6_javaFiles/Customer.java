
public class Customer {
	
	protected int age ;
	protected String name ;

	public Customer(Customer c) {
		
	}
	
	public Customer(String name, int age) {
		this.name =name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge( int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Customer : " +  getName() + " " +  getAge() + "  \n" ;
	}
}
