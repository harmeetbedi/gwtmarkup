// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class SimpleComboBoxFactory extends ComboBoxFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SimpleComboBox";
    
    public SimpleComboBoxFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SimpleComboBox newInstance(Element element) {
        return new SimpleComboBox();
    }
    
    public SimpleComboBox create(java.util.List<Object> ancestors,final Element element) {
        final SimpleComboBox item = (SimpleComboBox)createInstance(element);
        new WidgetDOMConverter<SimpleComboBox>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.ListView && "setView".equalsIgnoreCase(setFunc) )
                    item.setView((com.extjs.gxt.ui.client.widget.ListView)widget);
            }
        };
        return item;
    }
}
