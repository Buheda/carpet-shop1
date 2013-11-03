import java.util.HashMap;

public class Order {
	public String shopTitle;
	public String clientName;
	public int clientId;
	public String clientPhone;
	public int productId;
	public double price;
	public int count;
	public HashMap<String, Integer> listMaterials;
	public int quality;
	public int delivery;
	private String status;
	private double advance;
	private double remain;
	
	public Order(String title,int clId, int idProduct, int prCount,double summaryPrice, 
			HashMap<String, Integer> materials, 
			int prQuality, int termOfDelivery) {
		shopTitle=title;
		clientId=clId;
		count=prCount;
		clientName=Shop.getClientFromBook(clId).name;
		clientPhone=Shop.getClientFromBook(clId).getClientPhone();
		productId=idProduct;
		listMaterials=materials;
		price=summaryPrice;
		quality=prQuality;		
		delivery=termOfDelivery;		
	}
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAdvance(double money) {
		setStatus("advancepay");
		advance=money;
	}
	public double getAdvance() {
		return advance;
	}
	public void setRemain(double money) {
		setStatus("remainpay");
		remain=money;
	}
	public double getRemain() {
		return remain;
	}
	
}
