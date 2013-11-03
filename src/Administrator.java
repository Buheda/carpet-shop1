import java.util.HashMap;


public class Administrator {
	public String name;
	
	public Administrator(String aName){
	name=aName;
	Shop.setAssortiment(Shop.manager.getAssortiment());
	}

	public double getPriceMeasuring(HashMap<String, Double> listMaterials){
		double summaryPrice=listMaterials.get("workPrice");		
		int i,j;
		for (i=1;i<listMaterials.size();i++){
			for (j=0;j<Shop.assortiment.length;j++)
				summaryPrice+=listMaterials.get(Shop.assortiment[j].title);	
		}
		return summaryPrice;		
	}
			
	public Order createOrder(String clName, int idProduct,int prCount, int prQuality, double prPrice){
		return new Order(clName,
						idProduct,
						prCount,
						prQuality,
						prPrice,
						Shop.assortiment[idProduct].getTermOfDelivery(prCount));
		
	}
	public void toProcessAdvance(Order order,Client client){
		
		order.setAdvance(client.payAdvance(order));
	}
	
	public void setAssortiment(Product[] newAssortiment) {
		Shop.setAssortiment(newAssortiment);		
	}

	public Object payAccount(Object createAccount, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
