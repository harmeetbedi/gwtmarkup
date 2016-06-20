// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.StatusButtonBar;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class StatusButtonBarFactory extends ButtonBarFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "StatusButtonBar";
    
    public StatusButtonBarFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected StatusButtonBar newInstance(Element element) {
        return new StatusButtonBar();
    }
    
    public StatusButtonBar create(java.util.List<Object> ancestors,final Element element) {
        final StatusButtonBar item = (StatusButtonBar)createInstance(element);
        new WidgetDOMConverter<StatusButtonBar>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.button.Button )
                    item.add((com.extjs.gxt.ui.client.widget.button.Button)widget);
            }
        };
        return item;
    }
}
