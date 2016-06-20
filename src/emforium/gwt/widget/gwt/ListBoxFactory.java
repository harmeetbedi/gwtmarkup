// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.FocusWidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ListBoxFactory extends FocusWidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ListBox";
    
    public ListBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("multipleSelect", new BooleanAttributeSetter<ListBox>() {
            public void set(ListBox widget, Element element, String name, boolean value) {
                widget.setMultipleSelect(value);
            }
        });
        register("name", new StringAttributeSetter<ListBox>() {
            public void set(ListBox widget, Element element, String name, String value) {
                widget.setName(value);
            }
        });
        register("selectedIndex", new IntegerAttributeSetter<ListBox>() {
            public void set(ListBox widget, Element element, String name, int value) {
                widget.setSelectedIndex(value);
            }
        });
        register("visibleItemCount", new IntegerAttributeSetter<ListBox>() {
            public void set(ListBox widget, Element element, String name, int value) {
                widget.setVisibleItemCount(value);
            }
        });
    }

    @Override
    protected ListBox newInstance(Element element) {
        return new ListBox();
    }
    
    public ListBox create(java.util.List<Object> ancestors,final Element element) {
        final ListBox item = (ListBox)createInstance(element);
        new WidgetDOMConverter<ListBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
