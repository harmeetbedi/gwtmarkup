// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.WidgetFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class ImageFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Image";
    
    public ImageFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("url", new StringAttributeSetter<Image>() {
            public void set(Image widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    @Override
    protected Image newInstance(Element element) {
        return new Image();
    }
    
    public Image create(java.util.List<Object> ancestors,final Element element) {
        final Image item = (Image)createInstance(element);
        new WidgetDOMConverter<Image>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
