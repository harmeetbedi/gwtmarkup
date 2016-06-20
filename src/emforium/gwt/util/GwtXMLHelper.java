package emforium.gwt.util;

import com.extjs.gxt.ui.client.XDOM;

/**
 * collection of XML Helper functions to be used by GWT
 */
public class GwtXMLHelper {

	public static com.google.gwt.user.client.Element getElementById(String id) {
		return XDOM.getElementById(id);
	}
	
	public static void removeElementWithId(String id) {
		com.google.gwt.dom.client.Element elem = getElementById(id);
		if ( elem == null )
			return;
		//elem.setInnerHTML("");
		com.google.gwt.dom.client.Element parent = elem.getParentElement();
		if ( parent == null )
			return;
		parent.removeChild(elem);
	}

	/**
	 * Obtains attribute of XML Element. If no element is present, returns empty string 
	 * @param element XML Node
	 * @param name attribute name
	 * @return attribute value
	 */
    public static String getAttribute(com.google.gwt.xml.client.Element element,String name) {
    	String value = null;
    	try {
    		value = element.getAttribute(name);
    	} catch(Exception ex) {
    	}
    	if ( value == null )
    		value = "";
    	return value;
    }
    
    public static String getAttribute(com.google.gwt.dom.client.Element element,String name) {
    	String value = null;
    	try {
    		value = element.getAttribute(name);
    	} catch(Exception ex) {
    	}
    	if ( value == null )
    		value = "";
    	return value;
    }
    
    /**
     * set attribute of an element
     * @param elementId : if of element
     * @param name : attribute name
     * @param value : attribute value
     */
    public static void setAttribute(String elementId,String name,String value) {
    	com.google.gwt.dom.client.Element elem = getElementById(elementId);
    	if ( elem == null )
    		return;
    	elem.setAttribute(name, value);
    }
    
	/**
	 * Obtains attribute of XML Element. If no element is present, returns default value 
	 */
    public static boolean getBooleanAttribute(com.google.gwt.xml.client.Element element,String name,boolean defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		return defaultValue;
    	else
    		return Boolean.parseBoolean(value);
    }

    public static boolean getBooleanAttribute(com.google.gwt.dom.client.Element element,String name,boolean defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		return defaultValue;
    	else
    		return Boolean.parseBoolean(value);
    }

	/**
	 * Obtains attribute of XML Element. If no element is present, returns default value 
	 */
    public static int getIntAttribute(com.google.gwt.xml.client.Element element,String name,int defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		return defaultValue;
    	else
    		return Integer.parseInt(value);
    }

    public static int getIntAttribute(com.google.gwt.dom.client.Element element,String name,int defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		return defaultValue;
    	else
    		return Integer.parseInt(value);
    }

	/**
	 * Obtains attribute of XML Element. If no element is present, returns default value 
	 */
    public static String getAttribute(com.google.gwt.xml.client.Element element,String name,String defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		value = defaultValue;
		return value;
    }

    public static String getAttribute(com.google.gwt.dom.client.Element element,String name,String defaultValue) {
    	String value = getAttribute(element,name);
    	if ( value.length() == 0 )
    		value = defaultValue;
		return value;
    }

	public static void removeChildren(com.google.gwt.dom.client.Node parent) {
		com.google.gwt.dom.client.NodeList<com.google.gwt.dom.client.Node> nl = parent.getChildNodes();
		int len = nl.getLength();
		for (int i = len ; i > 0 ; i-- ) {
			parent.removeChild(nl.getItem(i-1));
		}
	}
}

