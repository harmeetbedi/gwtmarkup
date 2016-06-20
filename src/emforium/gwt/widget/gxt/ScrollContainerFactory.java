// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ScrollContainer;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ScrollContainerFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ScrollContainer";
    
    public ScrollContainerFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("hScrollPosition", new IntegerAttributeSetter<ScrollContainer>() {
            public void set(ScrollContainer widget, Element element, String name, int value) {
                widget.setHScrollPosition(value);
            }
        });
        register("vScrollPosition", new IntegerAttributeSetter<ScrollContainer>() {
            public void set(ScrollContainer widget, Element element, String name, int value) {
                widget.setVScrollPosition(value);
            }
        });
    }

    @Override
    protected ScrollContainer newInstance(Element element) {
        return new ScrollContainer();
    }
    
    public ScrollContainer create(java.util.List<Object> ancestors,final Element element) {
        final ScrollContainer item = (ScrollContainer)createInstance(element);
        new WidgetDOMConverter<ScrollContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
