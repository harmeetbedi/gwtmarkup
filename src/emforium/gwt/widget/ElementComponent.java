package emforium.gwt.widget;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * A simple GXT widget that will wrap an existing DOM element and do nothing but
 * allow it to be part of the GXT framework.
 * 
 */
public class ElementComponent extends LayoutContainer {

	/**
	 * The wrapped widget.
	 */
	private final Element element;

	/**
	 * Creates a new component wrapper.
	 * @param element
	 *            the widget to be wrapped
	 */
	public ElementComponent(Element element) {
		setEl(new El(element));
		assert element != null : "element must not be null";
		this.element = element;
	}

	/**
	 * Returns the underlying widget.
	 * 
	 * @return the widget
	 */
	public Element getElement() {
		return element;
	}

	@Override
	protected void onRender(Element target, int index) {
		super.onRender(target, index);
		setElement(element, target, index);
	}

	private static boolean debug = false;
	public static boolean isDebug() {
		return debug;
	}
	public static void setDebug(boolean value) {
		debug = value;
	}

	public boolean add(Object widget) {
		boolean retval = false;
		if (widget instanceof Widget) {
			retval = super.add((Widget) widget);
		}
		if ( debug )
			System.out.println("ElementComponent : "+ widget.getClass().getName()+", added="+retval);
		return retval;
	}

}