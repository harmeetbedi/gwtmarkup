// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class ContentPanelFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ContentPanel";
    
    public ContentPanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("animCollapse", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setAnimCollapse(value);
            }
        });
        register("bodyBorder", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setBodyBorder(value);
            }
        });
        register("bodyStyle", new StringAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, String value) {
                widget.setBodyStyle(value);
            }
        });
        register("bodyStyleName", new StringAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, String value) {
                widget.setBodyStyleName(value);
            }
        });
        register("collapsible", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setCollapsible(value);
            }
        });
        register("expanded", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setExpanded(value);
            }
        });
        register("footer", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setFooter(value);
            }
        });
        register("frame", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setFrame(value);
            }
        });
        register("headerVisible", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setHeaderVisible(value);
            }
        });
        register("heading", new StringAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, String value) {
                widget.setHeading(value);
            }
        });
        register("hideCollapseTool", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setHideCollapseTool(value);
            }
        });
        register("iconStyle", new StringAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("insetBorder", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setInsetBorder(value);
            }
        });
        register("titleCollapse", new BooleanAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, boolean value) {
                widget.setTitleCollapse(value);
            }
        });
        register("url", new StringAttributeSetter<ContentPanel>() {
            public void set(ContentPanel widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    @Override
    protected ContentPanel newInstance(Element element) {
        return new ContentPanel();
    }
    
    public ContentPanel create(java.util.List<Object> ancestors,final Element element) {
        final ContentPanel item = (ContentPanel)createInstance(element);
        new WidgetDOMConverter<ContentPanel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
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
