// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.DataListItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class DataListItemFactory extends ComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DataListItem";
    
    public DataListItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checked", new BooleanAttributeSetter<DataListItem>() {
            public void set(DataListItem widget, Element element, String name, boolean value) {
                widget.setChecked(value);
            }
        });
        register("iconStyle", new StringAttributeSetter<DataListItem>() {
            public void set(DataListItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("text", new StringAttributeSetter<DataListItem>() {
            public void set(DataListItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
        register("textStyle", new StringAttributeSetter<DataListItem>() {
            public void set(DataListItem widget, Element element, String name, String value) {
                widget.setTextStyle(value);
            }
        });
    }

    @Override
    protected DataListItem newInstance(Element element) {
        return new DataListItem();
    }
    
    public DataListItem create(java.util.List<Object> ancestors,final Element element) {
        final DataListItem item = (DataListItem)createInstance(element);
        new WidgetDOMConverter<DataListItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
