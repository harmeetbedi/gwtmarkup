// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class LabelFieldFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "LabelField";
    
    public LabelFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("text", new StringAttributeSetter<LabelField>() {
            public void set(LabelField widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected LabelField newInstance(Element element) {
        return new LabelField();
    }
    
    public LabelField create(java.util.List<Object> ancestors,final Element element) {
        final LabelField item = (LabelField)createInstance(element);
        new WidgetDOMConverter<LabelField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
