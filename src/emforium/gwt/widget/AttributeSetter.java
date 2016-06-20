package emforium.gwt.widget;

import java.util.Date;

import com.google.gwt.user.client.Element;

import emforium.gwt.util.GwtHelper;

/**
 * Interface for calling a setter for the widget.
 * 
 * @param <W>
 */
public interface AttributeSetter<W extends Object> {
	
	void set(W widget, Element element, String name, String value);
	
	/**
	 * Setter that expects a String as an argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class StringAttributeSetter<W extends Object> implements AttributeSetter<W> {
	}

	/**
	 * Setters that expect a boolean argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class BooleanAttributeSetter<W extends Object> implements AttributeSetter<W> {

		public final void set(W widget, Element element, String name, String value) {
			set(widget, element, name, Boolean.parseBoolean(value));
		}

		public abstract void set(W widget, Element element, String name, boolean value);
	}

	/**
	 * Setters that expect an int argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class IntegerAttributeSetter<W extends Object> implements AttributeSetter<W> {
		public final void set(W widget, Element element, String name, String value) {
			try {
				set(widget, element, name, Integer.parseInt(value));
			}
			catch (NumberFormatException e) {
				// not a valid number, so skip it
			}
		}

		public abstract void set(W widget, Element element, String name, int value);

	}

	/**
	 * Setters that expect a date argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class DateAttributeSetter<W extends Object> implements AttributeSetter<W> {
		public final void set(W widget, Element element, String name, String value) {
			// try a couple of variations to get date value
			Date dtVal = GwtHelper.parseDate(value);
			if ( dtVal != null ) {
				set(widget, element, name, dtVal);
			}
		}

		public abstract void set(W widget, Element element, String name, Date value);

	}

	/**
	 * Setters that expect a double argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class DoubleAttributeSetter<W extends Object> implements AttributeSetter<W> {
		public final void set(W widget, Element element, String name, String value) {
			try {
				set(widget, element, name, Double.parseDouble(value));
			}
			catch (NumberFormatException e) {
				// not a valid number, so skip it
			}
		}

		public abstract void set(W widget, Element element, String name, double value);

	}

	/**
	 * Setters that expect a float argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class FloatAttributeSetter<W extends Object> implements AttributeSetter<W> {
		public final void set(W widget, Element element, String name, String value) {
			try {
				set(widget, element, name, Float.parseFloat(value));
			}
			catch (NumberFormatException e) {
				// not a valid number, so skip it
			}
		}

		public abstract void set(W widget, Element element, String name, float value);

	}

	/**
	 * Setters that expect a character argument should extend this class.
	 * 
	 * @param <W>
	 */
	public static abstract class CharacterAttributeSetter<W extends Object> implements AttributeSetter<W> {
		public final void set(W widget, Element element, String name, String value) {
			try {
				set(widget, element, name, value.charAt(0));
			}
			catch (NumberFormatException e) {
				// not a valid number, so skip it
			}
		}

		public abstract void set(W widget, Element element, String name, char value);

	}
}

