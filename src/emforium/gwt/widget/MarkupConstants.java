package emforium.gwt.widget;

import com.google.gwt.i18n.client.DateTimeFormat;


/**
 * constants used in markup. e.g. Attribute names. 
 */
public interface MarkupConstants {

	String TYPE_XML_ATTRIBUTE_NAME = "widget-type";
	String GWTFIELD_NODENAME = "gwtfield";
	String GWTNODE_NODENAME = "gwtnode";
	String ASSOCIATION_XML_ATTRIBUTE_NAME = "gwt-child-association";
	String CHILDTYPE_XML_ATTRIBUTE_NAME = "gwt-children-type";

	public static final DateTimeFormat DATE_FORMAT = DateTimeFormat.getFormat("MMM dd yyyy");
    public static final DateTimeFormat OFBIZ_DATE_TIME_FORMAT = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final DateTimeFormat DATE_FORMAT_ALT = DateTimeFormat.getFormat("yyyy-mm-dd");
	public static final DateTimeFormat DATETIME_FORMAT = DateTimeFormat.getFormat("MMM dd yyyy, hh:mm a");
}
