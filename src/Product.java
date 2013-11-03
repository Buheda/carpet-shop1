//информация о товарах
public class Product {
	public int id;
	public String title;
	private String place;
	public int quality;
	public double price;
	private int existCount;
	private int deliveryTime;
	private int createTime;
	
	private int getExistCount() {
		return existCount;
	}		
	public Product(int idProduct,String prTitle,double prPrice, int prQuality){
	id=idProduct;
	title=prTitle;
	price=prPrice;
	quality=prQuality;
	}
	
	public int getTermOfDelivery(int count) {
		if (count<=getExistCount())
				return deliveryTime;
		else return deliveryTime+createTime*(count-getExistCount());
	}
	
	public int getQuality() {
		return quality;
		}	
	
	public String getPlace() {
		return place;
		}
}
