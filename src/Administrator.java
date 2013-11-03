import java.util.ArrayList;
import java.util.HashMap;


public class Administrator {
	public String name;
	
	public Administrator(String aName){
		name=aName;
		Shop.setAssortment(Shop.manager.getAssortment());
		}

	public double getPriceMeasuring(HashMap<String, Integer> listMaterials){
		double priceMeasuring=listMaterials.get("workPrice");		
		int i,j;
		for (i=1;i<listMaterials.size();i++){
			for (j=0;j<Shop.assortment.size();j++)
				priceMeasuring+=listMaterials.get(Shop.getProductFromAssortmentById(j).title);	
			}
		return priceMeasuring;		
	}
			
	public int createOrder(Client client, int prId, int count,
			double summaryPrice, HashMap<String, Integer> listMaterials, int quality) {		
		//client's id and order id - is the identical
		int id = Shop.addToClientsBook(client);
		Order order=new Order("ShopTitle", id, prId, count ,summaryPrice, listMaterials, quality, Shop.getProductFromAssortmentById(prId).getTermOfDelivery(count));
		Shop.addToOrdersBook(id, order);
		return id;
		}
	
	public void setAssortment(ArrayList<Product> newAssortment) {
		Shop.setAssortment(newAssortment);		
		}
	
	/*
	 *  we can transmit Client and Order as instants of class, or as link on Book of instances
	public void getAdvance(Order order){
		//client pay advance and admin set advance in order
		double money=Shop.getClientsFromBook(order.clientId).payAdvance(order);		
		Shop.setCashdesk(Shop.getCashdesk()+money);
		order.setAdvance(money);
	}*/
	public void getAdvance(int orderId){
		//client pay advance and admin set advance in order
		double money=Shop.getClientFromBook(orderId).payAdvance(orderId);		
		Shop.setCashdesk(Shop.getCashdesk()+money);
		Shop.getOrderFromBook(orderId).setAdvance(money);
	}
	public void getRemain(int orderId){
		//client pay remain and admin set remain in order
		if (Shop.getOrderFromBook(orderId).getRemain()<Shop.getOrderFromBook(orderId).price)
			{
			double money=Shop.getClientFromBook(orderId).payRemain(orderId);
			Shop.setCashdesk(Shop.getCashdesk() + money);		
			Shop.getOrderFromBook(orderId).setRemain(money);
			}
	}
	
	public boolean payAccount(HashMap<Integer, String> account, int orderId) {
		//administrator pay bankAccount of supplier
		return true;
	}
}
