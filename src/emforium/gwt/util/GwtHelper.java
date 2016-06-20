package emforium.gwt.util;

import java.util.Date;

import emforium.gwt.widget.MarkupConstants;


/**
 * collection of helper methods
 */
public class GwtHelper {
	/**
	 * checks if string is null or empty
	 */
	public static boolean isEmpty(String str) {
		return ( str == null || str.length() == 0);
	}

	/**
	 * reverse of isEmpty
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * attempt to parse date in a few ways.
	 * @param value
	 * @return null if date cannot be parsed
	 */
	@SuppressWarnings("deprecation")
	public static Date parseDate(String value) {
		Date dtValue = null;
		if ( dtValue == null ) {
			try {
				dtValue = MarkupConstants.OFBIZ_DATE_TIME_FORMAT.parse(value);
			} catch(Exception ex) { }
		}
		if ( dtValue == null ) {
			try {
				dtValue = MarkupConstants.DATE_FORMAT.parse(value);
			} catch(Exception ex) { }
		}
		if ( dtValue == null ) {
			try {
				dtValue = MarkupConstants.DATE_FORMAT_ALT.parse(value);
			} catch(Exception ex) { }
		}
		if ( dtValue == null ) {
			try {
				dtValue = new Date(value);
			} catch(Exception ex) { }
		}
		return dtValue;
	}
}
