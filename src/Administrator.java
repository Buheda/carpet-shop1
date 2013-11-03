import java.util.HashMap;


public class Administrator {
	public String name;
	
	public Administrator(String aName){
	name=aName;
	Shop.setAssortiment(Shop.manager.getAssortiment());
	}

	public double getPriceMeasuring(HashMap<String, Integer> listMaterials){
		double priceMeasuring=listMaterials.get("workPrice");		
		int i,j;
		for (i=1;i<listMaterials.size();i++){
			for (j=0;j<Shop.assortiment.length;j++)
				priceMeasuring+=listMaterials.get(Shop.assortiment[j].title);	
			}
		return priceMeasuring;		
	}
			
	public int createOrder(Client client, int prId, int count,
			double summaryPrice, HashMap<String, Integer> listMaterials, int quality) {		
		int id = Shop.addToClientsBook(client);
		Order order=new Order("ShopTitle", id, prId, summaryPrice, listMaterials, quality, Shop.assortiment[prId].getTermOfDelivery(count));
		id = Shop.addToOrdersBook(order);
		return id;
	}
	
	public void setAssortiment(Product[] newAssortiment) {
		Shop.setAssortiment(newAssortiment);		
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
		Order order=Shop.getOrderFromBook(orderId);
		//client pay advance and admin set advance in order
		double money=Shop.getClientsFromBook(order.clientId).payAdvance(orderId);		
		Shop.setCashdesk(Shop.getCashdesk()+money);
		order.setAdvance(money);
	}
	public void getRemain(int orderId){
		Order order=Shop.getOrderFromBook(orderId);
		//client pay remain and admin set remain in order
		double money=Shop.getClientsFromBook(order.clientId).payRemain(orderId);
		Shop.setCashdesk(Shop.getCashdesk() + money);
		order.setRemain(money);		
	}
	
	public boolean payAccount(String account, int orderId) {
		//administrator pay bankAccount of supplier
		return true;
	}
}
