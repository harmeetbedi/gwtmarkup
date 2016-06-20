// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.DateMenu;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class DateMenuFactory extends MenuFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DateMenu";
    
    public DateMenuFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DateMenu newInstance(Element element) {
        return new DateMenu();
    }
    
    public DateMenu create(java.util.List<Object> ancestors,final Element element) {
        final DateMenu item = (DateMenu)createInstance(element);
        new WidgetDOMConverter<DateMenu>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Item )
                    item.add((com.extjs.gxt.ui.client.widget.menu.Item)widget);
            }
        };
        return item;
    }
}
