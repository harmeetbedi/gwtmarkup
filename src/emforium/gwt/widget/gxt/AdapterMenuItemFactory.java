// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.AdapterMenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class AdapterMenuItemFactory extends ItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AdapterMenuItem";
    
    public AdapterMenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** override to create instance with arguments */
    @Override
    protected AdapterMenuItem newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public AdapterMenuItem create(java.util.List<Object> ancestors,final Element element) {
        final AdapterMenuItem item = (AdapterMenuItem)createInstance(element);
        new WidgetDOMConverter<AdapterMenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
