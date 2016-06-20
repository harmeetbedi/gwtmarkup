// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.LayoutFactory;
import com.google.gwt.user.client.Element;


public  class FitLayoutFactory extends LayoutFactory<FitLayout> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "FitLayout";
    
    public FitLayoutFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected FitLayout newInstance(Element element) {
        return new FitLayout();
    }
    
    public FitLayout create(java.util.List<Object> ancestors,final Element element) {
        final FitLayout item = (FitLayout)createInstance(element);
        new WidgetDOMConverter<FitLayout>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
