// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.SimplePanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ScrollPanelFactory extends SimplePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ScrollPanel";
    
    public ScrollPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("alwaysShowScrollBars", new BooleanAttributeSetter<ScrollPanel>() {
            public void set(ScrollPanel widget, Element element, String name, boolean value) {
                widget.setAlwaysShowScrollBars(value);
            }
        });
        register("height", new StringAttributeSetter<ScrollPanel>() {
            public void set(ScrollPanel widget, Element element, String name, String value) {
                widget.setHeight(value);
            }
        });
        register("horizontalScrollPosition", new IntegerAttributeSetter<ScrollPanel>() {
            public void set(ScrollPanel widget, Element element, String name, int value) {
                widget.setHorizontalScrollPosition(value);
            }
        });
        register("scrollPosition", new IntegerAttributeSetter<ScrollPanel>() {
            public void set(ScrollPanel widget, Element element, String name, int value) {
                widget.setScrollPosition(value);
            }
        });
        register("width", new StringAttributeSetter<ScrollPanel>() {
            public void set(ScrollPanel widget, Element element, String name, String value) {
                widget.setWidth(value);
            }
        });
    }

    @Override
    protected ScrollPanel newInstance(Element element) {
        return new ScrollPanel();
    }
    
    public ScrollPanel create(java.util.List<Object> ancestors,final Element element) {
        final ScrollPanel item = (ScrollPanel)createInstance(element);
        new WidgetDOMConverter<ScrollPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
                else 
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.setWidget((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
