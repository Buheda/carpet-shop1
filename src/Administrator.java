import java.util.HashMap;


public class Administrator {
	public String name;
	
	public Administrator(String aName){
	name=aName;
	Shop.setAssortiment(Shop.manager.getAssortiment());
	}

	public double getPriceMeasuring(HashMap<String, Double> listMaterials){
		double priceMeasuring=listMaterials.get("workPrice");		
		int i,j;
		for (i=1;i<listMaterials.size();i++){
			for (j=0;j<Shop.assortiment.length;j++)
				priceMeasuring+=listMaterials.get(Shop.assortiment[j].title);	
		}
		return priceMeasuring;		
	}
			
	public Order createOrder(String clName, int idProduct,int prCount, int prQuality, double prPrice){
		return new Order(clName,
						idProduct,
						prCount,
						prQuality,
						prPrice,
						Shop.assortiment[idProduct].getTermOfDelivery(prCount));		
	}
	
	public void setAssortiment(Product[] newAssortiment) {
		Shop.setAssortiment(newAssortiment);		
	}
	
	public void getAdvance(Order order,Client client){
		//client pay advance and admin set advance in order
		double money=client.payAdvance(order);
		Shop.cashdesk+=money;
		order.setAdvance(money);
	}
	public void getRemain(Order order,Client client){
		//client pay remain and admin set remain in order
		double money=client.payRemain(order);
		Shop.cashdesk+=money;
		order.setRemain(money);		
	}
	
	public boolean payAccount(String account, Order order) {
		//administrator pay bankAccount of supplier
		return true;
	}

}
