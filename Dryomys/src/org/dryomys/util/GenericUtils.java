package org.dryomys.util;

import java.util.Collection;

public class GenericUtils {

	/**
	 * 
	 * @param objects
	 * @return
	 */
	public static final boolean noNull(Object ... objects){
		boolean result = true;
		for(Object o: objects){
			if(o==null){
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param objects
	 * @return
	 */
	public static final boolean noNull(Collection<?> objects){
		boolean result = true;
		for(Object o: objects){
			if(o==null){
				result = false;
				break;
			}
		}
		return result;
	}
	
}
