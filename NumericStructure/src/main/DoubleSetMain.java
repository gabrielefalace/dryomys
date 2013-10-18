package main;

import java.util.HashSet;
import java.util.Set;

import numeric_core.NumericSet;

public class DoubleSetMain {

	public static void main(String ... argums){
				
		Set<Number> dobbli = new NumericSet(0d);
		
		System.out.println("[Set of Double] Testing add method ... ");
		dobbli.add(4.5f);
		dobbli.add(5.6f);
		dobbli.add(6.7f);
		dobbli.add(7.8f);
		dobbli.add(8.9f);
		dobbli.add(9.10f);
		
		
		for(Number d: dobbli)
			System.out.println("in set: "+d);
		
		System.out.println("\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n\n");
		
		System.out.println("[Set of Double] Testing retainAll method ... ");
		
		Set<Number> other = new HashSet<Number>();
		other.add(4.5d);
		other.add(5.6d);
		
		dobbli.retainAll(other);
		
		for(Number d: dobbli)
			System.out.println("in set: "+d);
		
		
	}

	
}
