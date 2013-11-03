public class Client {
public String name;
//сколько денег клиент готов заплатить за кв. метр покрытия 
private double money;
public int count;
private int quality;
//сроки ожидания заказа в днях
private int waitTime;

public Client(String clName,int clWaitTime,double clMoney,int clQuality) {
	name=clName;
	money=clMoney;
	quality=clQuality;
	waitTime=clWaitTime;
}

public boolean toBuy(int prQuality, double price, int time) {
	return ((prQuality>=quality)&&(price<=money)&&(time<=waitTime));
		}

public void payAdvance(Order order,double advance) {
	order.setAdvance(advance);
	money=money-advance;	
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