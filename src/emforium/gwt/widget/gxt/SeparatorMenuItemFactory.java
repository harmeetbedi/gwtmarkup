// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class SeparatorMenuItemFactory extends ItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "SeparatorMenuItem";
    
    public SeparatorMenuItemFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected SeparatorMenuItem newInstance(Element element) {
        return new SeparatorMenuItem();
    }
    
    public SeparatorMenuItem create(java.util.List<Object> ancestors,final Element element) {
        final SeparatorMenuItem item = (SeparatorMenuItem)createInstance(element);
        new WidgetDOMConverter<SeparatorMenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
