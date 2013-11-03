import java.util.ArrayList;


public class Manager {
	public String name;
	private ArrayList<Product> assortment;

	public Manager(String mngName){
		//get manager to work
		name=mngName;		
	}

	public void setAssortment(ArrayList<Product> productsList){
		assortment=productsList;
		Shop.administrator.setAssortment(assortment);
	}	 

	public ArrayList<Product> getAssortment(){
		return assortment;
	}

	public void getOrder(int orderId){
		Order order= Shop.getOrderFromBook(orderId);
		if (Shop.administrator.payAccount(Shop.supplier.createAccount(order.shopTitle,order.clientName,order.productId,order.price,order.quality), orderId))
			{
			Shop.getOrderFromBook(orderId).setStatus("prepaid");
			Supplier.setPayAccount(orderId);	
			}
		//if account - class - we may use this structure: 
		//Supplier.setPayAccount(Shop.administrator.payAccount(Shop.supplier.createAccount(),order));
	}
	
	public void sentProduct(int orderId){
		Order order=Shop.getOrderFromBook(orderId);		 
		if (order.getStatus().equals("send"))
		    // manager send message that product was sent
			Shop.salesman.sentProduct(orderId);
		}

}