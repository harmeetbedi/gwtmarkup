package emforium.gwt.widget;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventPreview;
import com.google.gwt.user.client.HTTPRequest;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ResponseTextHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

import emforium.gwt.util.GwtHelper;

/**
 * Replaces page content based on browse and form click events
 * Traps navigate and form submit events. Asynchronously fetches data and replaces initially empty body tag
 */
public class DynamicPage implements HistoryListener {

	private static boolean inPlaceNavEnabled = false;
	public static void initBodyReplace() {
		Element bodyElem = DOM.getElementById("bodyid");
		if ( bodyElem == null ) {
			return;
		}

		inPlaceNavEnabled = true;
		DynamicPage page = new DynamicPage();
		// there should be initial content link attribute to fill empty body placeholder
		String initialContent = bodyElem.getAttribute("content");
		page.trapNavigateEvents(initialContent);
	}
	
	/**
	 * traps navigate events to pages within site.
	 */
	private void trapNavigateEvents(String initialDynmicContent) {
	    DOM.addEventPreview(new EventPreview() {
	        public boolean onEventPreview(Event event) {
	        	//System.out.println(event.getType());
	        	// only intercept click events - form and hyperlink
	        	if ( DOM.eventGetType(event) != Event.ONCLICK )
	        		return true;
	        	
	        	com.google.gwt.dom.client.Element elem = event.getTarget();
	        	if ( elem == null )
	        		return true;
	        	
	        	String tagName = elem.getTagName();
	        	// sometimes text is wrapped by div. In that case try to use parent element to find type
	        	if ( "DIV".equalsIgnoreCase(tagName) ) {
	        		elem = elem.getParentElement();
	        		if ( elem == null )
	        			return true;
	        		tagName = elem.getTagName();
	        	}
	        	
	        	if ( "A".equalsIgnoreCase(tagName) ) {
	        		String link = elem.getAttribute("href");
	        		return navigate(link);
	        	}
	        	
	        	if ( "input".equalsIgnoreCase(tagName) 
        			&& "submit".equalsIgnoreCase(elem.getAttribute("type")) ) 
	        	{
	        		// find parent form element
	        		Element formElem = null;
		        	Element currElem = elem;
		        	while (formElem == null) {
		        		Element parent = currElem.getParentElement();
		        		if ( parent == null )
		        			break;
		        		if ( "form".equalsIgnoreCase(parent.getTagName()) )
		        			formElem = parent;
		        		currElem = parent;
		        	}

		        	// initiate form submission
		        	if ( formElem != null ) {
		        		doFormSubmit(formElem);
		        		return false;
		        	}
	        	}
	          return true;
	        }
        });
		History.addHistoryListener(this);
		onHistoryChanged(initialDynmicContent);
	}
	
	public static void replaceWindowLocation(String link) {
		if ( !inPlaceNavEnabled || navigate(link) )
				Window.Location.replace(link);
	}
	private static boolean navigate(String link) {
    	if ( link.toLowerCase().startsWith("http") ) {
    		// link points to external site. navigate away
    		return true;
    	}
    	else {
    		// link points to internal. Control navigation
    		String separator = link.contains("?") ? "&" : "?";
        	History.newItem(link+separator+"inplace=true");
        	return false;
    	}
	}
	
	@SuppressWarnings("deprecation")
	public void onHistoryChanged(final String historyToken) {
		//System.out.println("historytoken: "+historyToken);
		//System.out.println("fetching: "+historyToken);
		HTTPRequest.asyncGet(historyToken, new ResponseTextHandler() {
			public void onCompletion(String responseText) {
				//System.out.println("fetched: "+historyToken);
				replaceBody(responseText);
			}
		});
	}
	
	private void replaceBody(String body) {
		//System.out.println("replaceBody: ");
		HTML html = new HTML(body);
		//alterForms(html.getElement());
		RootPanel rootPanel = RootPanel.get("bodyid");
		//System.out.println("adding body to bodyid");
		for ( int idx = rootPanel.getWidgetCount() - 1 ; idx >= 0 ; idx-- ) {
			rootPanel.remove(idx);
		}
		rootPanel.add(html);
		PageDOMConverter.clearComponentRegistry();
		GwtWidgetMarkup.walkDom("");
	}
	private void doFormSubmit(Element formElem) {
		String action = formElem.getAttribute("action");
		Map<String,String> params = new HashMap<String,String>();
		//RequestBuilder req = new RequestBuilder(method,action);
		NodeList<Element> inputElements = formElem.getElementsByTagName("input");
		int inpElemCount = inputElements.getLength();
		for ( int inpIdx = 0 ; inpIdx < inpElemCount ; inpIdx++ ) {
			Element inpElem = inputElements.getItem(inpIdx);
			String value = inpElem.getAttribute("value");
			String name = inpElem.getAttribute("name");
			if ( GwtHelper.isNotEmpty(name))
				params.put(name,value);
		}
		navigate(getUrl(action,params));
	}
	private String getUrl(String action,Map<String,String> map) {
		if ( map == null || map.size() == 0 )
			return action;
		
		StringBuffer buf = new StringBuffer(action);
		boolean firstParam = !action.contains("?");
		for ( Map.Entry<String, String> entry : map.entrySet() ) {
			if ( firstParam )
				buf.append('?');
			else
				buf.append('&');
			firstParam = false;
			buf.append(entry.getKey());
			buf.append('=');
			buf.append(URL.encodeComponent(entry.getValue()));
		}
		return buf.toString();
	}
}
