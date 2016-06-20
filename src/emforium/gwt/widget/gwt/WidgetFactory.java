// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.UIObjectFactory;
import com.google.gwt.user.client.Element;


public  class WidgetFactory extends UIObjectFactory<Widget> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Widget";
    
    public WidgetFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected Widget newInstance(Element element) {
        return new Widget();
    }
    
    public Widget create(java.util.List<Object> ancestors,final Element element) {
        final Widget item = (Widget)createInstance(element);
        new WidgetDOMConverter<Widget>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
