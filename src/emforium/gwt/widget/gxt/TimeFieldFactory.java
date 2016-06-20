// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TimeFieldFactory extends ComboBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TimeField";
    
    public TimeFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("increment", new IntegerAttributeSetter<TimeField>() {
            public void set(TimeField widget, Element element, String name, int value) {
                widget.setIncrement(value);
            }
        });
    }

    @Override
    protected TimeField newInstance(Element element) {
        return new TimeField();
    }
    
    public TimeField create(java.util.List<Object> ancestors,final Element element) {
        final TimeField item = (TimeField)createInstance(element);
        new WidgetDOMConverter<TimeField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.ListView && "setView".equalsIgnoreCase(setFunc) )
                    item.setView((com.extjs.gxt.ui.client.widget.ListView)widget);
            }
        };
        return item;
    }
}
