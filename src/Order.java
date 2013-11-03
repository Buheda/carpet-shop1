public class Order {
	public static String clientName;
	public double price;
	private  int productId;
	private  int quality;
	private  int count;	
	private  int delivery;
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
	
	public void setAdvance(double money) {
		advance=money;
	}
	public void setRemain(double money) {
		remain=money;
	}
}
