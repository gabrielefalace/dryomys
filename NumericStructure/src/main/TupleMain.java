package main;

import java.math.BigDecimal;
import java.util.Iterator;

import tuples.Element;
import tuples.Pair;
import tuples.Triple;
import tuples.Tuple;

public class TupleMain {
	
	public static void main(String ... args){
		
		Element e = new Element(new BigDecimal("965869578493202395894368098343248589349584069586495723978.4658734563756347878982984940234832872374"));
		
		Pair p = new Pair(23f, 33f);
		
		Triple tr = new Triple(399.44d, 59.994d, 22d);
		
		Tuple t = new Tuple(10f, 30f, 120f, 33f, 938.33f, 22.92f);
		
		Tuple[] tArray = {e, p, tr, t};
		
		System.out.println(" ******************************** ");
		for(Tuple cur: tArray){
			System.out.println(cur);
		}
		System.out.println(" ******************************** \n");
		
		System.out.println("Tuple: " + t);
		
		System.out.println("Pair: " + p);
		
		System.out.println("Triple: " + tr);
		
		
		
		System.out.println("\nFOR-EACH:");
		
		// summing the elements of the tuple ... 
		for(Number n : t){
			System.out.print(n);
		}
		
		System.out.println("\nITERATOR:");
		
		Iterator<Number> iter = t.iterator();
		if(iter != null ){
			while(iter.hasNext()){
				System.out.print(iter.next());
			}
		}
		
	}
	
}
