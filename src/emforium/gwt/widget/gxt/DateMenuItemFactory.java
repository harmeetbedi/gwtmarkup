// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.DateMenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class DateMenuItemFactory extends ItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DateMenuItem";
    
    public DateMenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected DateMenuItem newInstance(Element element) {
        return new DateMenuItem();
    }
    
    public DateMenuItem create(java.util.List<Object> ancestors,final Element element) {
        final DateMenuItem item = (DateMenuItem)createInstance(element);
        new WidgetDOMConverter<DateMenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
