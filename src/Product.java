//информация о товарах
public class Product {
	//кач-во товара
	public static int quality;
	//цена товара
	public static int price;
	
	//сколько есть на складе
	private static int existCount;
	//время доставки готовой продукции со склада
	private static int delivery;
	//время на изготовление 1-й ед. изделия
	private static int createTime;
	
	private static int getExistCount() {
		return existCount;
	}		
	public int getTermOfDelivery(int count) {
		if (count<=getExistCount())
				return delivery;
		else return delivery+createTime*(count-getExistCount());
	}
	
	public int getQuality() {
		return quality;
		}	
}
