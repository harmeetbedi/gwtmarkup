// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ComplexPanelFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.util.GwtXMLHelper;


public  class AbsolutePanelFactory extends ComplexPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AbsolutePanel";
    
    public AbsolutePanelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected AbsolutePanel newInstance(Element element) {
        return new AbsolutePanel();
    }
    
    public AbsolutePanel create(java.util.List<Object> ancestors,final Element element) {
        final AbsolutePanel item = (AbsolutePanel)createInstance(element);
        new WidgetDOMConverter<AbsolutePanel>(ancestors,item,element) {
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
