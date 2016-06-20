// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.DataView;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DataViewFactory extends ScrollContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DataView";
    
    public DataViewFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("containerTagName", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setContainerTagName(value);
            }
        });
        register("defaultTemplate", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setDefaultTemplate(value);
            }
        });
        register("itemSelector", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setItemSelector(value);
            }
        });
        register("overStyle", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setOverStyle(value);
            }
        });
        register("selectOnOver", new BooleanAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, boolean value) {
                widget.setSelectOnOver(value);
            }
        });
        register("selectStyle", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setSelectStyle(value);
            }
        });
        register("template", new StringAttributeSetter<DataView>() {
            public void set(DataView widget, Element element, String name, String value) {
                widget.setTemplate(value);
            }
        });
    }

    @Override
    protected DataView newInstance(Element element) {
        return new DataView();
    }
    
    public DataView create(java.util.List<Object> ancestors,final Element element) {
        final DataView item = (DataView)createInstance(element);
        new WidgetDOMConverter<DataView>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setContextMenu".equalsIgnoreCase(setFunc) )
                    item.setContextMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.DataViewItem && "setSelectedItem".equalsIgnoreCase(setFunc) )
                    item.setSelectedItem((com.extjs.gxt.ui.client.widget.DataViewItem)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.DataViewItem )
                    item.add((com.extjs.gxt.ui.client.widget.DataViewItem)widget);
            }
        };
        return item;
    }
}
