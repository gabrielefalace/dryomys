package numeric_core;

import org.eclipse.jdt.annotation.Nullable;

import distance.DefaultDistanceProvider;
import distance.DistanceProvider;
import distance.ManhattanDistanceProvider;
import tuples.Tuple;
import util.NumericUtils;
import exceptions.UnsupportedTypeException;

/**
 * 
 * @author gabriele
 *
 */
public class TupleEngine {

	


	private DistanceProvider<Tuple> distanceProvider;
	
	/**
	 * 
	 */
	public TupleEngine(){
		distanceProvider = new ManhattanDistanceProvider();
		/*
		 * TODO default constructor
		 */
	}
	
	
	/**
	 * 
	 * @param aProvider
	 */
	public TupleEngine(DistanceProvider<Tuple> aProvider){
		distanceProvider = aProvider;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public DistanceProvider<Tuple> getDistanceProvider() {
		return distanceProvider;
	}


	/**
	 * 
	 * @param distanceProvider
	 */
	public void setDistanceProvider(DistanceProvider<Tuple> distanceProvider) {
		this.distanceProvider = distanceProvider;
	}

	
	
	/**
	 * 
	 * @param t1
	 * @param t2
	 * @param delta
	 * @return
	 * @throws UnsupportedTypeException
	 */
	public final boolean approximatelyEqual(Tuple t1, Tuple t2, Number delta) throws UnsupportedTypeException {
		Number distance = distanceProvider.distance(t1, t2);
		boolean result = false;
		if(distance != null){
			result = NumericUtils.lessThan(distance, delta, false);
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param tuple
	 * @param array
	 * @return
	 * @throws UnsupportedTypeException
	 */
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
						if(tmpDist != null && currentDist != null && NumericUtils.lessThan(tmpDist, currentDist, NumericUtils.STRICT)){
							currentBest = elem;
							currentDist = tmpDist;
						}
					}
				}
			}

			return currentBest;
		}
	}
	
}
