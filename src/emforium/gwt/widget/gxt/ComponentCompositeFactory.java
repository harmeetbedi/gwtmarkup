// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.ComponentComposite;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.CompositeFactory;
import com.google.gwt.user.client.Element;


public  class ComponentCompositeFactory extends CompositeFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ComponentComposite";
    
    public ComponentCompositeFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected ComponentComposite newInstance(Element element) {
        return new ComponentComposite();
    }
    
    public ComponentComposite create(java.util.List<Object> ancestors,final Element element) {
        final ComponentComposite item = (ComponentComposite)createInstance(element);
        new WidgetDOMConverter<ComponentComposite>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
