
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

	public void getOrder(int orderId){
		if (Shop.administrator.payAccount(Shop.supplier.createAccount(orderId),orderId))
			{
			Supplier.setPayAccount(orderId,"prepaid");	
			}
		//if account - class - we may use this structure: 
		//Supplier.setPayAccount(Shop.administrator.payAccount(Shop.supplier.createAccount(),order));
	}
	
	public void sentProduct(int orderId, Product pr){
		Order order=Shop.getOrderFromBook(orderId);
		if (order.getStatus().equals("send"))
			{
			//Thread.currentThread().sleep(1000*60*60*24*order.getDelivery);
			//we wait order.getDelivery days to bring product and then
			  if (order.getStatus().equals("storage"))
			     Shop.salesman.sentProduct(orderId,pr);
			}
	}

}