// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;
import emforium.gwt.util.GwtXMLHelper;


public  class RadioGroupFactory extends MultiFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RadioGroup";
    
    public RadioGroupFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("selectionRequired", new BooleanAttributeSetter<RadioGroup>() {
            public void set(RadioGroup widget, Element element, String name, boolean value) {
                widget.setSelectionRequired(value);
            }
        });
    }

    @Override
    protected RadioGroup newInstance(Element element) {
        return new RadioGroup();
    }
    
    public RadioGroup create(java.util.List<Object> ancestors,final Element element) {
        final RadioGroup item = (RadioGroup)createInstance(element);
        new WidgetDOMConverter<RadioGroup>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.form.Radio && "setValue".equalsIgnoreCase(setFunc) )
                    item.setValue((com.extjs.gxt.ui.client.widget.form.Radio)widget);
                else 
                if ( widget instanceof com.extjs.gxt.ui.client.widget.form.Radio )
                    item.add((com.extjs.gxt.ui.client.widget.form.Radio)widget);
            }
        };
        return item;
    }
}
