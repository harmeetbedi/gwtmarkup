// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;


public  class AnchorLayoutFactory extends LayoutFactory<AnchorLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AnchorLayout";
    
    public AnchorLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected AnchorLayout newInstance(Element element) {
        return new AnchorLayout();
    }
    
    public AnchorLayout create(java.util.List<Object> ancestors,final Element element) {
        final AnchorLayout item = (AnchorLayout)createInstance(element);
        new WidgetDOMConverter<AnchorLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
