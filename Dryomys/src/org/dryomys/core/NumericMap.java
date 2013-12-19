package org.dryomys.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.dryomys.exceptions.InconsistentNumberTypeException;
import org.dryomys.exceptions.Messages;
import org.dryomys.exceptions.UnsupportedTypeException;
import org.eclipse.jdt.annotation.Nullable;

/**
 * 
 * @author gabriele
 *
 * @param <V>
 */
public class NumericMap<V> extends NumericStructure implements Map<Number, V> {

	/**
	 * the map holding the data of this Map
	 */
	private Map<Number, V> numericMap;


	
	/**
	 * Constructs the NumericMap, with a given delta and a distance provider
	 * @param delta the delta to be used for considering two elements equal
	 */
	public NumericMap(Number delta){
		super.delta = delta;
		this.numericMap = new HashMap<Number, V>();
	}
	
	
	
	@Override
	public void clear() {
		this.numericMap.clear();
	}


	@Override
	public @Nullable Set<Entry<Number, V>> entrySet() {
		return this.numericMap.entrySet();
	}
	
	@Override
	public boolean isEmpty() {
		return this.isEmpty();
	}
	
	
	@Override
	public int size() {
		return this.numericMap.size();
	}

	@Override
	public @Nullable Collection<V> values() {
		return this.numericMap.values();
	}
	
	@Override
	public boolean containsValue(@Nullable Object value) {
		return this.numericMap.containsValue(value);
	}

	
	
	/**
	 * This method returns the set of this map's keys in the form of a NumericSet. 
	 * The returned NumericSet will have the same delta and DistanceProvider as this map.
	 * @return a NumericSet with all the keys, if constructing a numeric set succeeds, null otherwise.
	 */
	@Override
	public Set<Number> keySet() {
		Set<Number> keySet = this.numericMap.keySet();
		NumericSet numericSet = new NumericSet(this.delta);
		numericSet.addAll(keySet);
		return numericSet;
	}

	
	/**
	 * Checks if a Number approximately equal to a given key is contained in the keySet of this Map.
	 */
	@Override
	public boolean containsKey(@Nullable Object key) {
		boolean result = false;
		Set<Number> keySet = numericMap.keySet();
		if(key==null){
			if(keySet.contains(null)){
				result = true;
			}
			else{
				result = false;
			}
		}
		else{
			try{
				Number keyNumber = (Number)key;
				for(Number element: keySet){
					if(element == null){
						throw new NullPointerException(Messages.NULL_IN_COLLECTION);
					}
					else if(engine.approximatelyEqual(element, keyNumber, delta)) {
						result = true;
						break;
					}
				}
			}
			catch(UnsupportedTypeException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
	/**
	 * Retrieves the Value associated with the map's key which is closest to the passed one.
	 */
	@Override
	public @Nullable V get(@Nullable Object passedObjectKey) {
		V result = null;
		if(passedObjectKey==null){
			result = numericMap.get(null);
		}
		else{
			Number passedKey = (Number)passedObjectKey;
			Number[] keys = keysAsArray();
			
			try{
				Number closestKey = engine.getClosest(passedKey, keys);
				if(closestKey!=null && engine.approximatelyEqual(closestKey, passedKey, delta)){
					result = this.numericMap.get(closestKey);
				}
			}
			catch (UnsupportedTypeException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

	/**
	 * Insert a new entry in the map: if there's a key approximately equal to the passed key, the value is replaced, while the old key value is kept.
	 * If there's no matching key in the keySet, a new entry is inserted in this Map. 
	 */
	@Override
	public @Nullable V put(Number passedKey, V value) {
		V result = null;
		if(this.numericMap.isEmpty()){
			result = this.numericMap.put(passedKey, value);
		} 
		else{
			try {
				if(isTypeConsistent(passedKey)){			
					Number[] keys = keysAsArray();
					Number closestKey = engine.getClosest(passedKey, keys);
					
					if(closestKey!=null && engine.approximatelyEqual(closestKey, passedKey, delta)){
						// in this case we have to replace closestKey, not to have 2 keys which are approximatelyEquals
						result = this.numericMap.put(closestKey, value);
					}
					else{
						// in this case we can insert passedKey, instead
						result = this.numericMap.put(passedKey, value);
					}
				}
			} 
			catch (InconsistentNumberTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (UnsupportedTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	
	/**
	 * Tries to add each entry of the passed Map to this Map.
	 * I would be appropriate if the passed Map would be a NumericMap to avoid the possible discarding of
	 * entries due to "duplicate check" (through approximatelyEquals)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends Number, ? extends V> argMap) {
		Set<Number> keys = (Set<Number>) argMap.keySet();
		for(Number number: keys){
			V value = argMap.get(number);
			if(number != null && value != null){
				this.put(number, value);
			}
			else{
				throw new NullPointerException(Messages.NULL_ARGUMENT);
			}
		}
	}

	
	/**
	 * Removes the entry corresponding to the key in the map closer to the passed one (under delta distance).
	 * It doesn't anything and returns null when the closest key in the map has distance greater than delta.
	 */
	@Override
	public @Nullable V remove(@Nullable Object passedObject) {
		V result = null;
		
		Number passedKey = (Number)passedObject;
		Number[] keys = keysAsArray();
		
		if(passedKey==null){
			result = numericMap.remove(null);
		}
		else{
			try{
				Number closestKey = engine.getClosest(passedKey, keys);
				
				if(closestKey!=null && engine.approximatelyEqual(closestKey, passedKey, delta)){
					result = this.numericMap.remove(closestKey);
				}
			}
			catch (UnsupportedTypeException e) {
				e.getMessage();
			}
		}
		
		return result;
	}
	
	
	/**
	 * Produces an array containing the keySet of this Map
	 * @return an array Number[] with the keys
	 */
	private final Number[] keysAsArray(){
		Number[] result = new Number[numericMap.size()];
		result = numericMap.keySet().toArray(result);
		if(result != null){
			return result;
		}
		else{
			throw new NullPointerException(Messages.NULL_RECEIVED);
		}
	}

	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		Set<Number> keys = numericMap.keySet();
		for(Number k: keys){
			V v = numericMap.get(k);
			result.append(k.toString() + " : " + v + "\n");
		}
		
		String str = result.toString();
		
		if(str != null){
			return str;
		}
		else{
			throw new NullPointerException(Messages.NULL_RECEIVED);
		}
	}
}
