// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Element;


public  class IconButtonFactory extends BoxComponentFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "IconButton";
    
    public IconButtonFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected IconButton newInstance(Element element) {
        return new IconButton();
    }
    
    public IconButton create(java.util.List<Object> ancestors,final Element element) {
        final IconButton item = (IconButton)createInstance(element);
        new WidgetDOMConverter<IconButton>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
