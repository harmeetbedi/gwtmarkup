// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class PortalFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Portal";
    
    public PortalFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("ajustForScroll", new BooleanAttributeSetter<Portal>() {
            public void set(Portal widget, Element element, String name, boolean value) {
                widget.setAjustForScroll(value);
            }
        });
        register("spacing", new IntegerAttributeSetter<Portal>() {
            public void set(Portal widget, Element element, String name, int value) {
                widget.setSpacing(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected Portal newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public Portal create(java.util.List<Object> ancestors,final Element element) {
        final Portal item = (Portal)createInstance(element);
        new WidgetDOMConverter<Portal>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
