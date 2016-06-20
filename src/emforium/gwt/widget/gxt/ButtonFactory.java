// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ButtonFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Button";
    
    public ButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("iconStyle", new StringAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("menuAlign", new StringAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, String value) {
                widget.setMenuAlign(value);
            }
        });
        register("minWidth", new IntegerAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, int value) {
                widget.setMinWidth(value);
            }
        });
        register("mouseEvents", new BooleanAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, boolean value) {
                widget.setMouseEvents(value);
            }
        });
        register("tabIndex", new IntegerAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, int value) {
                widget.setTabIndex(value);
            }
        });
        register("text", new StringAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("type", new StringAttributeSetter<Button>() {
            public void set(Button widget, Element element, String name, String value) {
                widget.setType(value);
            }
        });
    }

    @Override
    protected Button newInstance(Element element) {
        return new Button();
    }
    
    public Button create(java.util.List<Object> ancestors,final Element element) {
        final Button item = (Button)createInstance(element);
        new WidgetDOMConverter<Button>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu )
                    item.setMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
            }
        };
        return item;
    }
}
