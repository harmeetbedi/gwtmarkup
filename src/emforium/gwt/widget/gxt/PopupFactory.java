// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Popup;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class PopupFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Popup";
    
    public PopupFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animate", new BooleanAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, boolean value) {
                widget.setAnimate(value);
            }
        });
        register("autoFocus", new BooleanAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, boolean value) {
                widget.setAutoFocus(value);
            }
        });
        register("autoHide", new BooleanAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, boolean value) {
                widget.setAutoHide(value);
            }
        });
        register("constrainViewport", new BooleanAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, boolean value) {
                widget.setConstrainViewport(value);
            }
        });
        register("defaultAlign", new StringAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, String value) {
                widget.setDefaultAlign(value);
            }
        });
        register("eventPreview", new BooleanAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, boolean value) {
                widget.setEventPreview(value);
            }
        });
        register("xOffset", new IntegerAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, int value) {
                widget.setXOffset(value);
            }
        });
        register("yOffset", new IntegerAttributeSetter<Popup>() {
            public void set(Popup widget, Element element, String name, int value) {
                widget.setYOffset(value);
            }
        });
    }

    @Override
    protected Popup newInstance(Element element) {
        return new Popup();
    }
    
    public Popup create(java.util.List<Object> ancestors,final Element element) {
        final Popup item = (Popup)createInstance(element);
        new WidgetDOMConverter<Popup>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.Component && "setItem".equalsIgnoreCase(setFunc) )
                    item.setItem((com.extjs.gxt.ui.client.widget.Component)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
