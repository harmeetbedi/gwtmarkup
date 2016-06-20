// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gxt;

import com.extjs.gxt.ui.client.widget.PngImage;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.ImageFactory;
import com.google.gwt.user.client.Element;
import emforium.gwt.widget.AttributeSetter.*;


public  class PngImageFactory extends ImageFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "PngImage";
    
    public PngImageFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
        register("url", new StringAttributeSetter<PngImage>() {
            public void set(PngImage widget, Element element, String name, String value) {
                widget.setUrl(value);
            }
        });
    }

    /** override to create instance with arguments */
    @Override
    protected PngImage newInstance(Element element) {
        throw new RuntimeException("override to create instance with arguments");
    }
    
    public PngImage create(java.util.List<Object> ancestors,final Element element) {
        final PngImage item = (PngImage)createInstance(element);
        new WidgetDOMConverter<PngImage>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
