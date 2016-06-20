// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class WindowFactory extends ContentPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Window";
    
    public WindowFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("active", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setActive(value);
            }
        });
        register("autoHide", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setAutoHide(value);
            }
        });
        register("blinkModal", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setBlinkModal(value);
            }
        });
        register("closable", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setClosable(value);
            }
        });
        register("constrain", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setConstrain(value);
            }
        });
        register("draggable", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setDraggable(value);
            }
        });
        register("initialWidth", new IntegerAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, int value) {
                widget.setInitialWidth(value);
            }
        });
        register("maximizable", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setMaximizable(value);
            }
        });
        register("minHeight", new IntegerAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, int value) {
                widget.setMinHeight(value);
            }
        });
        register("minimizable", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setMinimizable(value);
            }
        });
        register("minWidth", new IntegerAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, int value) {
                widget.setMinWidth(value);
            }
        });
        register("modal", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setModal(value);
            }
        });
        register("onEsc", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setOnEsc(value);
            }
        });
        register("plain", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setPlain(value);
            }
        });
        register("resizable", new BooleanAttributeSetter<Window>() {
            public void set(Window widget, Element element, String name, boolean value) {
                widget.setResizable(value);
            }
        });
    }

    @Override
    protected Window newInstance(Element element) {
        return new Window();
    }
    
    public Window create(java.util.List<Object> ancestors,final Element element) {
        final Window item = (Window)createInstance(element);
        new WidgetDOMConverter<Window>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget && "setFocusWidget".equalsIgnoreCase(setFunc) )
                    item.setFocusWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setBottomComponent".equalsIgnoreCase(setFunc) )
                    item.setBottomComponent((com.extjs.gxt.ui.client.widget.Component)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setTopComponent".equalsIgnoreCase(setFunc) )
                    item.setTopComponent((com.extjs.gxt.ui.client.widget.Component)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.Button )
                    item.addButton((com.extjs.gxt.ui.client.widget.button.Button)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.ButtonBar )
                    item.setButtonBar((com.extjs.gxt.ui.client.widget.button.ButtonBar)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
