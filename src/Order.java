public class Order {
public static String clientName;
private static Product product;
private static int quality;
private static int count;
private static int delivery;
private double advance;
private double remain;

public Order(String name, Product pr, int productCount, int productQuality, int productDelivery) {
	clientName=name;
	product=pr;
	count=productCount;
	quality=productQuality;
	delivery=productDelivery;
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
