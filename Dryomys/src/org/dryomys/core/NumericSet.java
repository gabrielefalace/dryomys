package org.dryomys.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.dryomys.exceptions.UnsupportedTypeException;
import org.dryomys.util.NumericUtils;
import org.eclipse.jdt.annotation.Nullable;


/*
 * To comply with the Collection contract, when a UnsupportedNumberTypeException is thrown
 * it gets catched and a ClassCastException is thrown in its place, with the message coming from the first. 
 * 
 */


/**
 * 
 * This collection is not synchronized
 * This collection does not support null values
 * 
 * @author Gabriele Falace
 * @since 2013 October 1
 *
 */
public class NumericSet extends NumericStructure implements Set<Number> {

	/**
	 * the delta defining the concept of approximately equal
	 */
	private Number delta;
	
	
	/**
	 * the Set of Number which compose this numericSet  
	 */
	private Set<Number> numericSet;
	
	
	
	/**
	 * Constructor of the Set of Number
	 * @param delta
	 */
	public NumericSet(Number delta){
		this.delta = delta;
		this.numericSet = new HashSet<Number>();
	}

	
	/**
	 * Adds the element to this Set. Since duplicates are not allowed, it checks if the collection contains an approximatelyEqual element. 
	 * In this case, the element id not added.
	 */
	@Override
	public boolean add(@Nullable Number element) {
		boolean outcome = false; 
		if(element==null){
			throw new NullPointerException();
		}
		else if(!NumericUtils.isProper(element)){
			throw new ClassCastException();
		}
		else{
			if(!contains(element)){
			    numericSet.add(element);
			    outcome = true;
			}
		}
		return outcome;
	}

	
	/**
	 * Adds each element of the passed collection to this collection, if the element is not contained.
	 */
	@Override
	public boolean addAll(@Nullable Collection<? extends Number> collection) {
		boolean outcome = false;
		if(collection == null){
			throw new NullPointerException();
		}
		else{
			for(Number addingElement: collection){
				if(!contains(addingElement)){
					this.add(addingElement);
					outcome = true;
				}
			}
		}
		return outcome;
	}

	
	@Override
	public void clear() {
		numericSet.clear();
	}

	
	/**
	 * The collection contains an element if there's one element in it
	 * whose distance from it is less or equal to delta.
	 */
	@Override
	public boolean contains(@Nullable Object element) {
		boolean contains = false;
		if(element == null){
			throw new NullPointerException();
		}
		else if(!(element instanceof Number)){
			throw new ClassCastException();
		}
		else{
			Number floatArgument = (Number)element;
			try{
				for(Number number: numericSet){
					if(number != null && engine.approximatelyEqual(number, floatArgument, delta)){
						contains = true;
						break;
					}
				}
			}
			catch(UnsupportedTypeException unte){
				throw new ClassCastException(unte.getMessage());
			}
		}
		return contains;
	}

	
	/**
	 * Checks if for all element in the passed collection, there's at least one element in this collection
	 * which is approximately equal to that.
	 */
	@Override
	public boolean containsAll(@Nullable Collection<?> collection) {
		boolean outcome = true;
		if(collection == null){
			throw new NullPointerException();
		}
		else{
			for(Object element: collection){
				outcome = outcome && contains((Number)element);
			}
		}
		return outcome;
	}

	
	@Override
	public boolean isEmpty() {
		return numericSet.isEmpty();
	}

	
	@Override
	public @Nullable Iterator<Number> iterator() {
		return numericSet.iterator();
	}


	/**
	 * Removes from this collection any object being approximatelyEqual to the passed one. 
	 * Therefore, more than one object could be removed.
	 */
	@Override
	public boolean remove(@Nullable Object obj){
		boolean outcome = false;
		if(obj == null){
			throw new NullPointerException();
		}
		else{
			try{
				Number passedFloat = (Number)obj;
				
				Iterator<Number> iterator = numericSet.iterator();
				while(iterator.hasNext()){
					Number element = iterator.next();
					if(element != null && engine.approximatelyEqual(element, passedFloat, delta)){
						iterator.remove();
						outcome = true;
						break;
					}
				}
			}
			catch(UnsupportedTypeException unte){
				throw new ClassCastException(unte.getMessage());
			}
		}
		return outcome;
	}

	
	/**
	 * Removes from this collection any element matching some element in the passed collection.
	 * The matching is always intended in the approximate way.
	 */
	@Override
	public boolean removeAll(@Nullable Collection<?> toRemove) {
		boolean outcome = false;
		if(toRemove == null){
			throw new NullPointerException();
		}
		else{
			for(Object element: toRemove){
				outcome = outcome || this.remove(element);
			}
		}
		return outcome;
	}

	
	/**
	 * Retains in this collection any element matching some element in the passed collection.
	 * The matching is intended by using the approximatelyEquals function, therefore the distance function too.
	 * 
	 */
	@Override
	public boolean retainAll(@Nullable Collection<?> arguments) {
		boolean outcome = false;
		
		if(arguments == null){
			throw new NullPointerException();
		}
		else{
			Set<Number> passedCollection = new HashSet<Number>();
			for(Object obj: arguments){
				passedCollection.add((Number)obj);
			}
			
			try{
				Iterator<Number> iter = numericSet.iterator();
				while(iter.hasNext()){
					Number element = iter.next();
					
					boolean elementToRetain = false;
					
					for(Number passed: passedCollection){
						if(element == null && passed == null){
							elementToRetain = true;
						}
						else if(element != null && passed != null && engine.approximatelyEqual(element, passed, delta))
							elementToRetain = true;	
					}
					
					if(!elementToRetain){
						iter.remove();
						outcome = true;
					}
				}
			}
			catch(UnsupportedTypeException unte){
				throw new ClassCastException(unte.getMessage());
			}
		}
		
		return outcome;
	}

	
	@Override
	public int size() {
		return numericSet.size();
	}

	
	@Override
	public Object[] toArray() {
		Object[] result = numericSet.toArray();
		if(result == null || numericSet.isEmpty()){
			result = new Object[0];
		}
		return result;
	}

	
	@SuppressWarnings("hiding")
	@Override
	public @Nullable <Number> Number[] toArray(Number[] array) {
		return numericSet.toArray(array);
	}
	
	
	/**
	 * 
	 * @param from
	 * @param strictFrom
	 * @param to
	 * @param strictTo
	 * @return the Number elements in the specified range
	 * @throws UnsupportedTypeException
	 */
	public final NumericSet getByRange(Number from, boolean strictFrom, Number to, boolean strictTo) throws UnsupportedTypeException{
		NumericSet result = new NumericSet(this.delta);
		
		boolean greaterThanFrom, lessThanTo;
		
		for(Number element: numericSet){
			if(element == null){
				throw new NullPointerException();
			}
			else{
				greaterThanFrom = NumericUtils.greaterThan(element, from, strictFrom);
				lessThanTo = NumericUtils.lessThan(element, to, strictTo);
				if(greaterThanFrom && lessThanTo)
					result.numericSet.add(element);
			}
		}
		
//		if(fromInclusive){
//			if(toInclusive){
//				for(Number element: numericSet){
//					greaterThanFrom = numericUtils.greaterThan(element, from, NumericUtils.NON_STRICT);
//					lessThanTo = numericUtils.lessThan(element, to, NumericUtils.NON_STRICT);
//					if(greaterThanFrom && lessThanTo)
//						result.numericSet.add(element);
//				}
//			}
//			else{
//				for(Number element: numericSet){
//					greaterThanFrom = numericUtils.greaterThan(element, from, NumericUtils.NON_STRICT);
//					lessThanTo = numericUtils.lessThan(element, to, NumericUtils.STRICT);
//					if(greaterThanFrom && lessThanTo)
//						result.numericSet.add(element);
//				}
//			}
//		}
//		else{
//			if(toInclusive){
//				for(Number element: numericSet){
//					greaterThanFrom = numericUtils.greaterThan(element, from, NumericUtils.STRICT);
//					lessThanTo = numericUtils.lessThan(element, to, NumericUtils.NON_STRICT);
//					if(greaterThanFrom && lessThanTo)
//						result.numericSet.add(element);
//				}
//			}
//			else{
//				for(Number element: numericSet){
//					greaterThanFrom = numericUtils.greaterThan(element, from, NumericUtils.STRICT);
//					lessThanTo = numericUtils.lessThan(element, to, NumericUtils.STRICT);
//					if(greaterThanFrom && lessThanTo)
//						result.numericSet.add(element);
//				}
//			}
//		}
		
		return result;
	}

	
	/**
	 * 
	 * @param number
	 * @return true if this set contains exactly the specified element 
	 */
	public boolean containsExactly(Number number){
		return this.numericSet.contains(number);
	}
	
	
	/**
	 * 
	 * @param numbers
	 * @return true if this set contains exactly all of the elements of the specified collection 
	 */
	public boolean containsAllExactly(Collection<Number> numbers){
		return this.numericSet.containsAll(numbers);
	}
	
	
	/**
	 * 
	 * @param number
	 * @return true if this set contained exactly the specified element 
	 */
	public boolean removeExactly(Number number){
		return this.numericSet.remove(number);
	}
}
