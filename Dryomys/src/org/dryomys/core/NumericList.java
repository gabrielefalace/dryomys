package org.dryomys.core;

import static org.dryomys.util.NumericUtils.*;
import static org.dryomys.util.GenericUtils.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.dryomys.exceptions.InvalidElementException;
import org.dryomys.exceptions.NullArgumentException;
import org.dryomys.exceptions.NullComputedException;
import org.dryomys.exceptions.NullUnsupportedException;
import org.dryomys.exceptions.UnsupportedTypeException;
import org.eclipse.jdt.annotation.Nullable;

/**
 * 
 * FIX ASAP!!! type checking in many places using "isProper" method!
 * 
 * @author gabriele
 * 
 */
public class NumericList extends NumericStructure implements List<Number> {

    private List<Number> numericList = new ArrayList<Number>();

    /**
     * 
     * @param delta
     */
    public NumericList(Number delta) {
        super.delta = delta;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        boolean result = false;
        if (o instanceof Number) {
            Number toCheck = (Number) o;
            try {
                for (Number number : numericList) {
                    if (number != null && engine.approximatelyEqual(number, toCheck, delta)) {
                        result = true;
                        break;
                    }
                }
            } catch (UnsupportedTypeException unte) {
                throw new InvalidElementException(unte);
            }
        }
        return result;
    }

    @Override
    public boolean add(Number e) {
        return numericList.add(e);
    }

    @Override
    public void add(int index, Number element) {
        numericList.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends Number> c) {
        return numericList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Number> c) {
        return numericList.addAll(c);
    }

    @Override
    public void clear() {
        numericList.clear();
    }

    @Override
    public boolean containsAll(@Nullable Collection<?> collection) {
        if (collection == null) {
            throw new NullArgumentException();
        } else {
            boolean result = true;
            for (Object obj : collection) {
                Number number = (Number) obj;
                if (!this.contains(number)) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }

    @Override
    @Nullable
    public Number get(int index) {
        return numericList.get(index);
    }

    @Override
    public int indexOf(@Nullable Object o) {
        if (o == null) {
            throw new NullArgumentException();
        } else {
            Number number = (Number) o;
            int result = -1;
            int position = 0;
            Iterator<Number> iterator = numericList.iterator();
            try {
                while (iterator.hasNext()) {
                    Number current = iterator.next();
                    if (current != null && engine.approximatelyEqual(current, number, delta)) {
                        result = position;
                        break;
                    } else {
                        position++;
                    }
                }
            } catch (UnsupportedTypeException unte) {
                throw new InvalidElementException(unte);
            }
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        return numericList.isEmpty();
    }

    @Override
    @Nullable
    public Iterator<Number> iterator() {
        return numericList.iterator();
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        if (o == null) {
            throw new NullArgumentException();
        } else {
            int position = 0;
            int result = -1;
            Number number = (Number) o;
            Iterator<Number> iterator = numericList.iterator();
            try {
                while (iterator.hasNext()) {
                    Number current = iterator.next();
                    if (current != null && engine.approximatelyEqual(current, number, delta)) {
                        result = position;
                    }
                    position++;
                }
                // does not break on first occurrence, but goes through all the
                // iterations.
            } catch (UnsupportedTypeException unte) {
                throw new InvalidElementException(unte);
            }
            return result;
        }
    }

    @Override
    @Nullable
    public ListIterator<Number> listIterator() {
        return numericList.listIterator();
    }

    @Override
    @Nullable
    public ListIterator<Number> listIterator(int index) {
        return numericList.listIterator(index);
    }

    @Override
    public boolean remove(@Nullable Object o) {
        boolean result = false;
        if (o == null) {
            throw new NullArgumentException();
        } else if (!(o instanceof Number)) {
            throw new InvalidElementException();
        } else {
            Number number = (Number) o;
            try {
                Number found = engine.getClosest(number, this.asArray());
                if (found == null) {
                    throw new NullComputedException();
                }
                if (engine.approximatelyEqual(found, number, delta)) {
                    result = numericList.remove(found);
                }
            } catch (UnsupportedTypeException unte) {
                throw new InvalidElementException(unte);
            }
        }
        return result;
    }

    @Override
    @Nullable
    public Number remove(int index) {
        return numericList.remove(index);
    }

    @Override
    public boolean removeAll(@Nullable Collection<?> collection) {
        if (collection == null) {
            throw new NullArgumentException();
        } else {
            boolean result = false;
            for (Object current : collection) {
                result = result || this.remove(current);
            }
            return result;
        }
    }

    @Override
    public boolean retainAll(@Nullable Collection<?> collection) {
        boolean outcome = false;
        if (collection == null) {
            throw new NullArgumentException();
        }

        if (hasSomeNull(collection)){
            throw new NullUnsupportedException();
        }
        
        Collection<Number> passedList = (Collection<Number>) collection;
        try {
            Iterator<Number> iter = numericList.iterator();
            while (iter.hasNext()) {
                Number element = iter.next();
                if (!isToRetain(element, passedList, delta)) {
                    iter.remove();
                    outcome = true;
                }
            }
        } catch (UnsupportedTypeException unte) {
            throw new InvalidElementException(unte);
        }
        return outcome;
    }

    @Override
    @Nullable
    public Number set(int index, Number element) {
        return numericList.set(index, element);
    }

    @Override
    public int size() {
        return numericList.size();
    }

    @Override
    @Nullable
    public List<Number> subList(int fromIndex, int toIndex) {
        return numericList.subList(fromIndex, toIndex);
    }

    @Override
    @Nullable
    public Object[] toArray() {
        return numericList.toArray();
    }

    @Override
    @Nullable
    public <T> T[] toArray(T[] a) {
        return numericList.toArray(a);
    }

    /**
     * 
     * @return this List as an Array
     */
    public Number[] asArray() {
        Number[] result = new Number[numericList.size()];
        result = numericList.toArray(result);
        if (result == null) {
            result = new Number[0];
        }
        return result;
    }

    /**
     * 
     * @param from
     * @param strictFrom
     * @param to
     * @param strictTo
     * @return a NumericList with the matching elements
     * @throws UnsupportedTypeException
     */
    public final NumericList getByRange(Number from, boolean strictFrom,
            Number to, boolean strictTo) throws UnsupportedTypeException {
        NumericList result = new NumericList(this.delta);

        boolean greaterThanFrom, lessThanTo;

        for (Number element : numericList) {
            if (element == null) {
                throw new NullArgumentException();
            } else {
                greaterThanFrom = greaterThan(element, from, strictFrom);
                lessThanTo = lessThan(element, to, strictTo);
                if (greaterThanFrom && lessThanTo) {
                    result.numericList.add(element);
                }
            }
        }
        return result;
    }
}
