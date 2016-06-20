// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class FillLayoutFactory extends RowLayoutFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FillLayout";
    
    public FillLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected FillLayout newInstance(Element element) {
        return new FillLayout();
    }
    
    public FillLayout create(java.util.List<Object> ancestors,final Element element) {
        final FillLayout item = (FillLayout)createInstance(element);
        new WidgetDOMConverter<FillLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
