
public class Manager {
	public String name;
	private Product[] assortiment;

	public Manager(String mngName){
		//get manager to work
		name=mngName;
	}

	public void setAssortiment(Product[] productsList){
		assortiment=productsList;
		Shop.administrator.setAssortiment(assortiment);
	}	 

	public Product[] getAssortiment(){
		return assortiment;
	}

	public void getOrder(Order order){
		
		Supplier.setPayAccount(Shop.administrator.payAccount(Shop.supplier.createAccount(),order));
	}
	
	public void sentProduct(String place){
		if (Product.getPlace()=="sklad")
		Salesman.sentProduct("sklad");
	}

}