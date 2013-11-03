import java.util.HashMap;

public class Mounter {
	private double workPrice;
	public String name;
	
	public Mounter(String mName)
	{
		name=mName;
	}
	
	public HashMap<String, Double> getMeasuring(){
		String material=null;//using product
		double optimalCountProduct=0; // count of using material
		HashMap<String, Double>  listMaterials=new HashMap<String, Double> (); //array of using material and its count
		listMaterials.put("workPrice",workPrice);
		int i=1;
		boolean using=false; 
		while (using) //select needed materials from all list
		{
		listMaterials.put(material,optimalCountProduct);
		i++;
		}
	return listMaterials;	
	}
	
	public void install(Order order){
	//install carpet at client with order
	}
	
}
