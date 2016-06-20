// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CustomButtonFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ToggleButtonFactory extends CustomButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ToggleButton";
    
    public ToggleButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("down", new BooleanAttributeSetter<ToggleButton>() {
            public void set(ToggleButton widget, Element element, String name, boolean value) {
                widget.setDown(value);
            }
        });
    }

    @Override
    protected ToggleButton newInstance(Element element) {
        return new ToggleButton();
    }
    
    public ToggleButton create(java.util.List<Object> ancestors,final Element element) {
        final ToggleButton item = (ToggleButton)createInstance(element);
        new WidgetDOMConverter<ToggleButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
