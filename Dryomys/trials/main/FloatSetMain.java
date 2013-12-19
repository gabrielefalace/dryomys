package main;

import java.util.HashSet;
import java.util.Set;

import org.dryomys.core.NumericSet;

public class FloatSetMain {
	
	public static void main(String ... argums){
		
		Float d = new Float(0f);
		
		Set<Number> floatti = new NumericSet(d);
		
		System.out.println("[Set of Float] Testing add method ... ");
		floatti.add(4.5f);
		floatti.add(5.6f);
		floatti.add(6.7f);
		floatti.add(7.8f);
		floatti.add(8.9f);
		floatti.add(9.10f);
		
		
		for(Number f: floatti)
			System.out.println("in set: "+f);
		
		System.out.println("\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n\n");
		
		System.out.println("[Set of Float] Testing retainAll method ... ");
		
		Set<Float> other = new HashSet<Float>();
		other.add(4.5f);
		other.add(5.6f);
		
		floatti.retainAll(other);
		
		for(Number f: floatti)
			System.out.println("in set: "+f);
		
		
	}

}
