// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;


public  class CenterLayoutFactory extends LayoutFactory<CenterLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CenterLayout";
    
    public CenterLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected CenterLayout newInstance(Element element) {
        return new CenterLayout();
    }
    
    public CenterLayout create(java.util.List<Object> ancestors,final Element element) {
        final CenterLayout item = (CenterLayout)createInstance(element);
        new WidgetDOMConverter<CenterLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
