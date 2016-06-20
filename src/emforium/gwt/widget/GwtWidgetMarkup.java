package emforium.gwt.widget;

import com.google.gwt.core.client.EntryPoint;

/**
 * This the primary entry point for a GWT application. It will scan the DOM
 * looking for elements that have been marked with special attribute values.
 * These special markings will result in the creation of GWT and GXT widgets at
 * the specified locations.
 * 
 * This allows for simple applications to be created and wired up without
 * writing any javascript of gwt code.
 * 
 * 
 */
public class GwtWidgetMarkup implements EntryPoint {

	public void onModuleLoad() {
		setupJavascriptCallback();
		walkDom("");
		DynamicPage.initBodyReplace();
	}

	public static native void setupJavascriptCallback() /*-{
		$wnd.invokeDomWalk = @emforium.gwt.widget.GwtWidgetMarkup::invokeDomWalk();
		$wnd.gwtSetTextAreaValue = function (gwtId, value) {
       				var component = @emforium.gwt.widget.PageDOMConverter::getRegisteredComponent(Ljava/lang/String;)(gwtId);
       				component.@com.google.gwt.user.client.ui.TextArea::setText(Ljava/lang/String;)(value);
   			};
		$wnd.gwtCoverFlowSetSelectedImage = function (gwtId,selectionIndex) {
       				//alert(gwtId+', '+selectionIndex);
       				var component = @emforium.gwt.widget.PageDOMConverter::getRegisteredComponent(Ljava/lang/String;)(gwtId);
       				component.@emforium.gwt.widget.custom.CoverFlow::setSelectedIndex(I)(selectionIndex);
   			};
		$wnd.gwtCoverFlowGetSelectedImage = function (gwtId) {
       				//alert(gwtId+', '+selectionIndex);
       				var component = @emforium.gwt.widget.PageDOMConverter::getRegisteredComponent(Ljava/lang/String;)(gwtId);
       				var idx = component.@emforium.gwt.widget.custom.CoverFlow::getSelectedIndex()();
       				//alert('selidx.gwt:'+idx);
       				return idx;
   			};
		$wnd.gwtReplaceWindowLocation = function (link) {
   				@emforium.gwt.widget.DynamicPage::replaceWindowLocation(Ljava/lang/String;)(link);
   			};
	}-*/;
	
	public static void invokeDomWalk() {
		walkDom("-modal");
	}
	
	public static void walkDom(String scanSuffix) {
		// do the work of scanning and creating widgets
		long startTime = System.currentTimeMillis();
		PageDOMConverter.scanForWidgets(scanSuffix);
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("dom converter took "+timeTaken+" ms");
	}
}
