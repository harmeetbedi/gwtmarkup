// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class SplitButtonFactory extends ButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SplitButton";
    
    public SplitButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SplitButton newInstance(Element element) {
        return new SplitButton();
    }
    
    public SplitButton create(java.util.List<Object> ancestors,final Element element) {
        final SplitButton item = (SplitButton)createInstance(element);
        new WidgetDOMConverter<SplitButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                String function = GwtXMLHelper.getAttribute(element,emforium.gwt.widget.MarkupConstants.CHILDTYPE_XML_ATTRIBUTE_NAME);
                String setFunc = "set"+function;
                String addFunc = "add"+function;
                if ( widget instanceof com.extjs.gxt.ui.client.widget.menu.Menu )
                    item.setMenu((com.extjs.gxt.ui.client.widget.menu.Menu)widget);
            }
        };
        return item;
    }
}
