package util;

import org.eclipse.jdt.annotation.Nullable;
import tuples.Tuple;
import distance.ManhattanDistanceProvider;
import distance.TupleDistanceProvider;
import exceptions.UnsupportedTypeException;


/*
 * TODO under construction ... 
 * 
 */
public class TupleUtils implements Utils<Tuple>{

	private static TupleDistanceProvider distanceProvider = new ManhattanDistanceProvider();
	
	private static TupleUtils tupleUtils = new TupleUtils(distanceProvider);
	
	private static NumericUtils numericUtils = NumericUtils.getInstance();
	
	private TupleUtils(TupleDistanceProvider aDistanceProvider){
		distanceProvider = aDistanceProvider;
	}
	
	
	public TupleUtils getInstance(){
		return tupleUtils;
	}
	
	
	public TupleDistanceProvider getDistanceProvider(){
		return distanceProvider;
	}
	
	public void setDistanceProvider(TupleDistanceProvider aProvider){
		distanceProvider = aProvider;
	}
	
	
	public final boolean approximatelyEqual(Tuple t1, Tuple t2, Number delta) throws UnsupportedTypeException {
		Number distance = distanceProvider.distance(t1, t2);
		boolean result = false;
		if(distance != null){
			result = numericUtils.lessThan(distance, delta, false);
		}
		return result;
	}
	
	
	
	
	public final @Nullable Tuple getClosest(Tuple tuple, Tuple[] array) throws UnsupportedTypeException {
		if(array.length==0){
			throw new NullPointerException("method \"getClosest\" called on an empty structure");
		}
		else{
			Tuple currentBest = array[0];
			Number currentDist;
			if(currentBest == null){
				throw new NullPointerException("A null element was found in the collection!");
			}
			else{
				currentDist = distanceProvider.distance(currentBest, tuple);
				
				for(Tuple elem: array){
					if(elem == null){
						throw new NullPointerException("A null element was found in the collection!");
					}
					else{
						Number tmpDist = distanceProvider.distance(elem, tuple);
						if(tmpDist != null && currentDist != null && numericUtils.lessThan(tmpDist, currentDist, NumericUtils.STRICT)){
							currentBest = elem;
							currentDist = tmpDist;
						}
					}
				}
			}

			return currentBest;
		}
	}


	@Override
	public boolean isExactlyIn(Tuple number, Tuple[] array) {
		boolean result = false;
		for(Tuple current: array){
			if(number.equals(current)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	
	public boolean isProper(Tuple tuple){
		if(tuple.isEmpty()){
			return true;
		}
		else{
			Number first = tuple.get(0);
			boolean result = true;
			String className = first.getClass().getName();
			for(Number number: tuple){
				if(!className.equals(number.getClass().getName())){
					result = false;
					break;
				}
			}
			return result;
		}
	}
	
}
