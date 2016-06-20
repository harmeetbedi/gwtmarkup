// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class TabPanelFactory extends ContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TabPanel";
    
    public TabPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animScroll", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setAnimScroll(value);
            }
        });
        register("autoHeight", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setAutoHeight(value);
            }
        });
        register("autoSelect", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setAutoSelect(value);
            }
        });
        register("bodyBorder", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setBodyBorder(value);
            }
        });
        register("borderStyle", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setBorderStyle(value);
            }
        });
        register("deferredRender", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setDeferredRender(value);
            }
        });
        register("minTabWidth", new IntegerAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, int value) {
                widget.setMinTabWidth(value);
            }
        });
        register("plain", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setPlain(value);
            }
        });
        register("resizeTabs", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setResizeTabs(value);
            }
        });
        register("scrollDuration", new IntegerAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, int value) {
                widget.setScrollDuration(value);
            }
        });
        register("scrollIncrement", new IntegerAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, int value) {
                widget.setScrollIncrement(value);
            }
        });
        register("tabMargin", new IntegerAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, int value) {
                widget.setTabMargin(value);
            }
        });
        register("tabScroll", new BooleanAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, boolean value) {
                widget.setTabScroll(value);
            }
        });
        register("tabWidth", new IntegerAttributeSetter<TabPanel>() {
            public void set(TabPanel widget, Element element, String name, int value) {
                widget.setTabWidth(value);
            }
        });
    }

    @Override
    protected TabPanel newInstance(Element element) {
        return new TabPanel();
    }
    
    public TabPanel create(java.util.List<Object> ancestors,final Element element) {
        final TabPanel item = (TabPanel)createInstance(element);
        new WidgetDOMConverter<TabPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.TabItem && "setSelection".equalsIgnoreCase(setFunc) )
                    item.setSelection((com.extjs.gxt.ui.client.widget.TabItem)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.TabItem )
                    item.add((com.extjs.gxt.ui.client.widget.TabItem)widget);
            }
        };
        return item;
    }
}
