// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.Composite;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class CompositeFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Composite";
    
    public CompositeFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected Composite newInstance(Element element) {
        return new Composite();
    }
    
    public Composite create(java.util.List<Object> ancestors,final Element element) {
        final Composite item = (Composite)createInstance(element);
        new WidgetDOMConverter<Composite>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
