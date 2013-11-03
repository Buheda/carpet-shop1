public class Order {
	public static String clientName;
	public String shopTitle;
	public double price;
	private String status;
	private int productId;
	private int quality;
	private int count;	
	private int delivery;
	private double advance;
	private double remain;
	
	public Order(String clName, int idProduct, int prCount, int prQuality,
			double prPrice, int termOfDelivery) {
		clientName=clName;
		productId=idProduct;
		count=prCount;
		quality=prQuality;
		price=prPrice;
		delivery=termOfDelivery;
	}

	public int getQuality() {
		return quality ;
	}
		
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDelivery() {
		return delivery ;
	}
	
	public void setAdvance(double money) {
		setStatus("advancepay");
		advance=money;
	}
	public void setRemain(double money) {
		setStatus("remainpay");
		remain=money;
	}
}
