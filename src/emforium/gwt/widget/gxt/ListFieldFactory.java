// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.ListField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ListFieldFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ListField";
    
    public ListFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("displayField", new StringAttributeSetter<ListField>() {
            public void set(ListField widget, Element element, String name, String value) {
                widget.setDisplayField(value);
            }
        });
        register("itemSelector", new StringAttributeSetter<ListField>() {
            public void set(ListField widget, Element element, String name, String value) {
                widget.setItemSelector(value);
            }
        });
        register("template", new StringAttributeSetter<ListField>() {
            public void set(ListField widget, Element element, String name, String value) {
                widget.setTemplate(value);
            }
        });
        register("valueField", new StringAttributeSetter<ListField>() {
            public void set(ListField widget, Element element, String name, String value) {
                widget.setValueField(value);
            }
        });
    }

    @Override
    protected ListField newInstance(Element element) {
        return new ListField();
    }
    
    public ListField create(java.util.List<Object> ancestors,final Element element) {
        final ListField item = (ListField)createInstance(element);
        new WidgetDOMConverter<ListField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
