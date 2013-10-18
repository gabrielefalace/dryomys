package tuples;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.eclipse.jdt.annotation.Nullable;


/*
 * TODO under construction ... 
 * 
 */
public class Tuple implements List<Number> {
	
	
	private int dimension;
	
	
	private List<Number> values;
	
	
	public Tuple(Number ... values){
		this.dimension = values.length;
		List<Number> tmpValues = Arrays.asList(values); 
		if(tmpValues != null){
			this.values = tmpValues;
		}
		else{
			throw new RuntimeException();
		}
	}
	
	
	public int getDimension(){
		return dimension;
	}
	
	
	public List<Number> getValues(){
		return this.values;
	}
	
	
	public void setValues(List<Number> values){
		this.values = values;
	}
	

	@Override
	public @Nullable ListIterator<Number> listIterator() {
		return values.listIterator();
	}

	
	@Override
	public @Nullable ListIterator<Number> listIterator(int i) {
		return values.listIterator(i);
	}

	
	@Override
	public @Nullable Object[] toArray() {
		return values.toArray(); 
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable Object[] toArray(Object[] arg0) {
		return values.toArray(arg0);
	}
	
	
	@Override
	public @Nullable Number set(int arg0, Number arg1) {
		return values.set(arg0, arg1);
	}

	
	@Override
	public int size() {
		return values.size();
	}

	
	@Override
	public Number get(int i) {
		return values.get(i);
	}
	
	
	@Override
	@SuppressWarnings("null")
	public Iterator<Number> iterator() {
		return values.iterator();
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
			if(this.size() == other.size()){
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
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	
	
	
	/* **************************************************
	 * 
	 *      (TEMPORARILY?)  UNSUPPORTED OPERATIONS 
	 * 
	 ****************************************************/
	
	@Override
	public boolean remove(@Nullable Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Number remove(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean removeAll(@Nullable Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean retainAll(@Nullable Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Number> subList(int arg0, int arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(Number arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int arg0, Number arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean addAll(@Nullable Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean addAll(int arg0, @Nullable Collection arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(@Nullable Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean containsAll(@Nullable Collection arg0) {
		throw new UnsupportedOperationException();
	}

	
	@Override
	public int indexOf(@Nullable Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(@Nullable Object arg0) {
		throw new UnsupportedOperationException();
	}
}
