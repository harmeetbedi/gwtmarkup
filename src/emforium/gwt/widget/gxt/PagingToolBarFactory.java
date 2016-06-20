// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class PagingToolBarFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PagingToolBar";
    
    public PagingToolBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("activePage", new IntegerAttributeSetter<PagingToolBar>() {
            public void set(PagingToolBar widget, Element element, String name, int value) {
                widget.setActivePage(value);
            }
        });
        register("pageSize", new IntegerAttributeSetter<PagingToolBar>() {
            public void set(PagingToolBar widget, Element element, String name, int value) {
                widget.setPageSize(value);
            }
        });
        register("reuseConfig", new BooleanAttributeSetter<PagingToolBar>() {
            public void set(PagingToolBar widget, Element element, String name, boolean value) {
                widget.setReuseConfig(value);
            }
        });
        register("showToolTips", new BooleanAttributeSetter<PagingToolBar>() {
            public void set(PagingToolBar widget, Element element, String name, boolean value) {
                widget.setShowToolTips(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected PagingToolBar newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public PagingToolBar create(java.util.List<Object> ancestors,final Element element) {
        final PagingToolBar item = (PagingToolBar)createInstance(element);
        new WidgetDOMConverter<PagingToolBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.toolbar.ToolItem )
                    item.add((com.extjs.gxt.ui.client.widget.toolbar.ToolItem)widget);
            }
        };
        return item;
    }
}
