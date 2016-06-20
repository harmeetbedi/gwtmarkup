// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.SplitBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class SplitBarFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SplitBar";
    
    public SplitBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("autoSize", new BooleanAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, boolean value) {
                widget.setAutoSize(value);
            }
        });
        register("barWidth", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setBarWidth(value);
            }
        });
        register("handleWidth", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setHandleWidth(value);
            }
        });
        register("maxSize", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setMaxSize(value);
            }
        });
        register("minSize", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setMinSize(value);
            }
        });
        register("xOffset", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setXOffset(value);
            }
        });
        register("yOffset", new IntegerAttributeSetter<SplitBar>() {
            public void set(SplitBar widget, Element element, String name, int value) {
                widget.setYOffset(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected SplitBar newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public SplitBar create(java.util.List<Object> ancestors,final Element element) {
        final SplitBar item = (SplitBar)createInstance(element);
        new WidgetDOMConverter<SplitBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
