// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class FieldSetFactory extends LayoutContainerFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FieldSet";
    
    public FieldSetFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("checkboxName", new StringAttributeSetter<FieldSet>() {
            public void set(FieldSet widget, Element element, String name, String value) {
                widget.setCheckboxName(value);
            }
        });
        register("checkboxToggle", new BooleanAttributeSetter<FieldSet>() {
            public void set(FieldSet widget, Element element, String name, boolean value) {
                widget.setCheckboxToggle(value);
            }
        });
        register("collapsible", new BooleanAttributeSetter<FieldSet>() {
            public void set(FieldSet widget, Element element, String name, boolean value) {
                widget.setCollapsible(value);
            }
        });
        register("expanded", new BooleanAttributeSetter<FieldSet>() {
            public void set(FieldSet widget, Element element, String name, boolean value) {
                widget.setExpanded(value);
            }
        });
        register("heading", new StringAttributeSetter<FieldSet>() {
            public void set(FieldSet widget, Element element, String name, String value) {
                widget.setHeading(value);
            }
        });
    }

    @Override
    protected FieldSet newInstance(Element element) {
        return new FieldSet();
    }
    
    public FieldSet create(java.util.List<Object> ancestors,final Element element) {
        final FieldSet item = (FieldSet)createInstance(element);
        new WidgetDOMConverter<FieldSet>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.google.gwt.user.client.ui.Widget )
                    item.add((com.google.gwt.user.client.ui.Widget)widget);
            }
        };
        return item;
    }
}
