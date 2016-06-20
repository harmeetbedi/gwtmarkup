// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.DualListField;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class DualListFieldFactory extends MultiFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "DualListField";
    
    public DualListFieldFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("dNDGroup", new StringAttributeSetter<DualListField>() {
            public void set(DualListField widget, Element element, String name, String value) {
                widget.setDNDGroup(value);
            }
        });
        register("enableDND", new BooleanAttributeSetter<DualListField>() {
            public void set(DualListField widget, Element element, String name, boolean value) {
                widget.setEnableDND(value);
            }
        });
    }

    @Override
    protected DualListField newInstance(Element element) {
        return new DualListField();
    }
    
    public DualListField create(java.util.List<Object> ancestors,final Element element) {
        final DualListField item = (DualListField)createInstance(element);
        new WidgetDOMConverter<DualListField>(ancestors,item,element) {
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
