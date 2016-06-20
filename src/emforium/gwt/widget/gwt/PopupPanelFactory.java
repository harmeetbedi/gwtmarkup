// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimplePanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class PopupPanelFactory extends SimplePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PopupPanel";
    
    public PopupPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animationEnabled", new BooleanAttributeSetter<PopupPanel>() {
            public void set(PopupPanel widget, Element element, String name, boolean value) {
                widget.setAnimationEnabled(value);
            }
        });
        register("height", new StringAttributeSetter<PopupPanel>() {
            public void set(PopupPanel widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("title", new StringAttributeSetter<PopupPanel>() {
            public void set(PopupPanel widget, Element element, String name, String value) {
                widget.setTitle(value);
            }
        });
        register("visible", new BooleanAttributeSetter<PopupPanel>() {
            public void set(PopupPanel widget, Element element, String name, boolean value) {
                widget.setVisible(value);
            }
        });
        register("width", new StringAttributeSetter<PopupPanel>() {
            public void set(PopupPanel widget, Element element, String name, String value) {
                widget.setWidth(value);
            }
        });
    }

    @Override
    protected PopupPanel newInstance(Element element) {
        return new PopupPanel();
    }
    
    public PopupPanel create(java.util.List<Object> ancestors,final Element element) {
        final PopupPanel item = (PopupPanel)createInstance(element);
        new WidgetDOMConverter<PopupPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
