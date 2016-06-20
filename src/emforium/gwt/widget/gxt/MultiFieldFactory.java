// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.MultiField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class MultiFieldFactory extends FieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MultiField";
    
    public MultiFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("readOnly", new BooleanAttributeSetter<MultiField>() {
            public void set(MultiField widget, Element element, String name, boolean value) {
                widget.setReadOnly(value);
            }
        });
        register("resizeFields", new BooleanAttributeSetter<MultiField>() {
            public void set(MultiField widget, Element element, String name, boolean value) {
                widget.setResizeFields(value);
            }
        });
        register("spacing", new IntegerAttributeSetter<MultiField>() {
            public void set(MultiField widget, Element element, String name, int value) {
                widget.setSpacing(value);
            }
        });
    }

    @Override
    protected MultiField newInstance(Element element) {
        return new MultiField();
    }
    
    public MultiField create(java.util.List<Object> ancestors,final Element element) {
        final MultiField item = (MultiField)createInstance(element);
        new WidgetDOMConverter<MultiField>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.form.Field )
                    item.add((com.extjs.gxt.ui.client.widget.form.Field)widget);
            }
        };
        return item;
    }
}
