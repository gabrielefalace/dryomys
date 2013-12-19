package main;


import java.util.Map;

import org.dryomys.core.NumericMap;
import org.dryomys.core.NumericSet;
import org.dryomys.exceptions.UnsupportedTypeException;

public class MapMain {
	
	public static void main(String ... args) throws UnsupportedTypeException{
		
		Double delta = 0.00001;
		
		Map<Number,String> map = new NumericMap<String>(delta);
		
		String v1 = "Topo di fogna";
		String v2 = "Cane volante";
		String v3 = "Oloturia";
		String v4 = "Opossum";
		
		double k1 = 3.5;
		double k2 = 4.0;
		double k3 = 4.1;
		
		double k4 = 4.101;
		
		map.put(k1, v1);
		map.put(k2, v2);
		map.put(k3, v3);
		map.put(k4, v4);
		
		System.out.println("Mappa creata e popolata");
		
		NumericSet ns = (NumericSet) map.keySet();
		
		for(Number n: ns){
			System.out.println("Found key: " + n + " has value: "+map.get(n));
		}
		
		
		NumericSet selection = ns.getByRange(4.0, true, 4.1, false);
		
		System.out.println("Selected ones: ");
		for(Number num: selection){
			System.out.print(num + " ");
		}
	
		System.out.println("\n\n");
		
		map.put(6.5d, "Mongolo");	//replaces topo di fogna?
		
		System.out.println(map);
	}

}
