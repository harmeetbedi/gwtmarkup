// generated file. template : widgetfactory.vm

package emforium.gwt.widget.gwt;

import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.UIObject;
import emforium.gwt.widget.WidgetDOMConverter;
import com.google.gwt.user.client.ui.Widget;
import emforium.gwt.widget.gwt.LabelFactory;
import com.google.gwt.user.client.Element;


public  class InlineLabelFactory extends LabelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "InlineLabel";
    
    public InlineLabelFactory() {
    }

    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    protected InlineLabel newInstance(Element element) {
        return new InlineLabel();
    }
    
    public InlineLabel create(java.util.List<Object> ancestors,final Element element) {
        final InlineLabel item = (InlineLabel)createInstance(element);
        new WidgetDOMConverter<InlineLabel>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}
