// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class CheckBoxGroupFactory extends MultiFieldFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CheckBoxGroup";
    
    public CheckBoxGroupFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected CheckBoxGroup newInstance(Element element) {
        return new CheckBoxGroup();
    }
    
    public CheckBoxGroup create(java.util.List<Object> ancestors,final Element element) {
        final CheckBoxGroup item = (CheckBoxGroup)createInstance(element);
        new WidgetDOMConverter<CheckBoxGroup>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.form.CheckBox )
                    item.add((com.extjs.gxt.ui.client.widget.form.CheckBox)widget);
            }
        };
        return item;
    }
}
