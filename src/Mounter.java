import java.util.HashMap;

public class Mounter {
private double workPrice;
public String name;

public Mounter(String mName)
{
	name=mName;
}

public HashMap<String, Comparable> getMeasuring(){
	String material=null;//using product
	int optimalCountProduct=0; // count of using material
	boolean using=false; //select list of materials
	HashMap<String, Comparable> listMaterials=new HashMap<String, Comparable>(); //array of using material and its count
	listMaterials.put("workPrice",workPrice);
	int i=1;
	while (using) 
	{
	listMaterials.put("material",material);
	listMaterials.put("count",optimalCountProduct);
	i++;
	}
return listMaterials;	
}

public void install(Order order){
//install carpet at client with order
}

}
