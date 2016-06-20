// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.DataList;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DataListFactory extends ScrollContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DataList";
    
    public DataListFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checkable", new BooleanAttributeSetter<DataList>() {
            public void set(DataList widget, Element element, String name, boolean value) {
                widget.setCheckable(value);
            }
        });
        register("flatStyle", new BooleanAttributeSetter<DataList>() {
            public void set(DataList widget, Element element, String name, boolean value) {
                widget.setFlatStyle(value);
            }
        });
        register("trackMouseOver", new BooleanAttributeSetter<DataList>() {
            public void set(DataList widget, Element element, String name, boolean value) {
                widget.setTrackMouseOver(value);
            }
        });
    }

    @Override
    protected DataList newInstance(Element element) {
        return new DataList();
    }
    
    public DataList create(java.util.List<Object> ancestors,final Element element) {
        final DataList item = (DataList)createInstance(element);
        new WidgetDOMConverter<DataList>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu && "setContextMenu".equalsIgnoreCase(setFunc) )
                    item.setContextMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.DataListItem && "setSelectedItem".equalsIgnoreCase(setFunc) )
                    item.setSelectedItem((com.extjs.gxt.ui.client.widget.DataListItem)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.DataListItem )
                    item.add((com.extjs.gxt.ui.client.widget.DataListItem)widget);
            }
        };
        return item;
    }
}
