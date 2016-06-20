package emforium.gwt.util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.user.client.Element;

/**
 * collection of Javascript Helper functions to be used by GWT
 */
public class GwtJSHelper {

	/**
	 * Invoke arbitrary javascript function
	 * 
	 * @param function name of javascript function
	 * @param value parameter
	 */
	public static native void invokeJS(String sourceId, Object source, Element element,String jsCallback, String value) /*-{
	 		$wnd.gwtCallback(jsCallback,[sourceId,source, element, value]);
	}-*/;

	public static native void invokeJS(String sourceId, Object source, Element element,String jsCallback) /*-{
	 		$wnd.gwtCallback(jsCallback,[sourceId,source, element]);
	}-*/;
	
	/**
	 * callback to js has 'true' after sourceid, source(widget), element(containing widget) to array with indicate multiple selection in last parameter
	 */
	public static native void invokeOnChartSelections(String sourceId, Object source, Element element,String jsCallback, JsArray<Selection> value) /*-{
		$wnd.gwtCallback(jsCallback,[sourceId,source, element, true, value]);
	}-*/;
	
	/**
	 * callback to js has 'false' after sourceid, source(widget), element(containing widget) to array with indicate single selected cell in last parameter
	 */
	public static native void invokeOnChartSelection(String sourceId, Object source, Element element,String jsCallback, Selection value) /*-{
		$wnd.gwtCallback(jsCallback,[sourceId,source, element, false, value]);
	}-*/;
}
