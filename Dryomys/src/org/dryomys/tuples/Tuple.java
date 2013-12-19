package org.dryomys.tuples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;


/**
 * A Tuple is an Iterable object made of a list of Number.
 * 
 * @author gabriele
 */
public class Tuple implements Iterable<Number> {
	
	/**
	 * inner List of Number objects, representing tuple values
	 */
	private List<Number> values;
	
	
	
	/**
	 * Constructor for the Tuple
	 * @param values an array or explicit list of Number objects which will form this Tuple.
	 */
	public Tuple(Number ... values){
		List<Number> tmpValues = Arrays.asList(values); 
		if(tmpValues != null){
			this.values = tmpValues;
		}
		else{
			throw new RuntimeException();
		}
	}
	
	/**
	 * Gives the number of the elements in this Tuple
	 * @return the size of the underlying list
	 */
	public int getDimension(){
		return values.size();
	}
	
	/**
	 * Gives the values of this Tuple
	 * @return a List of Number
	 */
	public List<Number> getValues(){
		return this.values;
	}
	
	/**
	 * 
	 * @param values
	 */
	public void setValues(List<Number> values){
		this.values = values;
	}
	
	/**
	 * 
	 * @return an array containing the values
	 */
	public @Nullable Object[] toArray() {
		return values.toArray(); 
	}

	/**
	 * 
	 * @param array the array into which the elements of this Tuple are to be stored
	 * @return an array containing the elements of this Tuple
	 */
	public @Nullable Object[] toArray(Object[] array) {
		return values.toArray(array);
	}
	
	/**
	 * 
	 * @param index the index of the element to replace
	 * @param element element to be stored at the specified position 
	 * @return the element previously at the specified position 
	 */
	public @Nullable Number set(int index, Number element) {
		return values.set(index, element);
	}

	/**
	 * 
	 * @param index the index of the element to return 
	 * @return the element at the specified position in this list
	 */
	public @Nullable Number get(int index) {
		return values.get(index);
	}
	
	/**
	 * Tests if this Tuple has dimension zero
	 * @return true if the values List is empty
	 */
	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	
	
	@Override
	@SuppressWarnings("null")
	public String toString(){
		StringBuilder s = new StringBuilder("(");
		final String comma = new String(", ");
		if(values.size() >= 1){
			Number[] asArray = new Number[values.size()];
			asArray = values.toArray(asArray);
			s.append(asArray[0]);
			for(int i=1; i<asArray.length; i++){
				s.append(comma + asArray[i]);
			}
		}
		s.append(")");
		return s.toString();
	}
	
	
	public boolean equals(@Nullable Object o){
		boolean result = true;	
		if(o != null && o instanceof Tuple){
			Tuple other = (Tuple)o;
			if(this.getDimension() == other.getDimension()){
				Iterator<Number> iThis = this.iterator();
				Iterator<Number> iOther = other.iterator();
				if(iThis != null && iOther != null){
					while(iThis.hasNext()){
						Number curThis = iThis.next();
						Number curOther = iOther.next();
						if(!curThis.equals(curOther)){
							result = false;
							break;
						}
					}
				}
				else{
					throw new NullPointerException("couldn't iterate over tuples in method \"equals\"");
				}
			}
		}
		else{
			result = false;
		}
		return result;
	}

	
	@Override
	public @Nullable Iterator<Number> iterator() {
		return values.iterator();
	}

	
}
