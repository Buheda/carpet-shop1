public class Client {
public String name;
private double money;
public int count;
private int quality;
private int waitTime;

public Client(String clName,int clWaitTime,double clMoney,int clQuality, int clCount) {
	name=clName;
	money=clMoney;
	quality=clQuality;
	waitTime=clWaitTime;
	count=clCount;
}

public boolean toBuy(int prQuality, double price, int time) {
	return ((prQuality>=quality)&&(price<=money)&&(time<=waitTime));
		}

public double payAdvance(Order order) {
	double advance=order.price/100*70;
	//order.setAdvance(advance);
	money=money-advance;	
	return advance;
	}

public void payRemain(Order order) {
	//клиент пришел
	//клиент оплачивает остаток по заказу
	order.setRemain(money);
	Salesman.installProduct(order);
	}

public static void happyClient() {
	//клиенту установили покрытие и он счастлив
	System.out.print("i'm happy");
}
}