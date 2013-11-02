
public class Manager {
	public String name;
	private Product[] assortiment;

	public Manager(String mngName){
		name=mngName;
	}

	public void setAssortiment(Product[] productsList){
		assortiment=productsList;
		Administrator.setAssortiment(assortiment);
	}	 

	public Product[] getAssortiment(){
		return assortiment;
	}

	public void getAccount(){
		Supplier.setPayAccount(Administrator.payAccount(Supplier.createAccount()));
	}
	
	public void sentProduct(String place){
		if (Product.getPlace()=="sklad")
		Salesman.sentProduct("sklad");
	}

}