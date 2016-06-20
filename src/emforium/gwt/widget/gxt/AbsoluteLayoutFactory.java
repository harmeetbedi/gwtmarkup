// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class AbsoluteLayoutFactory extends AnchorLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AbsoluteLayout";
    
    public AbsoluteLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected AbsoluteLayout newInstance(Element element) {
        return new AbsoluteLayout();
    }
    
    public AbsoluteLayout create(java.util.List<Object> ancestors,final Element element) {
        final AbsoluteLayout item = (AbsoluteLayout)createInstance(element);
        new WidgetDOMConverter<AbsoluteLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
