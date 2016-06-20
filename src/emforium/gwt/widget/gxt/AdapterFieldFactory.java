// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.AdapterField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class AdapterFieldFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AdapterField";
    
    public AdapterFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("resizeWidget", new BooleanAttributeSetter<AdapterField>() {
            public void set(AdapterField widget, Element element, String name, boolean value) {
                widget.setResizeWidget(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected AdapterField newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public AdapterField create(java.util.List<Object> ancestors,final Element element) {
        final AdapterField item = (AdapterField)createInstance(element);
        new WidgetDOMConverter<AdapterField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
