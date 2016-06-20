/**
 * 
 */
package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.gwt.GridFactory;

/**
 * Factory for the NumberField widget.
 *
 */
public class RichTextContainerFactory extends GridFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RichTextContainer";

	public RichTextContainerFactory() {
	}
	
    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
        super.registerAttributes();
    }

    protected RichTextContainer newInstance(Element element) {
		return new RichTextContainer();
	}

    public RichTextContainer create(java.util.List<Object> ancestors,final Element element) {
        final RichTextContainer item = (RichTextContainer)createInstance(element);
        new WidgetDOMConverter<RichTextContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            	if ( widget instanceof RichTextArea ) {
            		item.init((RichTextArea)widget);
            	}
            }
        };	
        return item;
    }
}

class RichTextContainer extends Grid {
	RichTextContainer() {
		super(2,1);
	}
	void init(RichTextArea area) {
		RichTextToolbar toolbar = new RichTextToolbar(area);
        //area.setWidth("100%");
        //toolbar.setWidth("20%");
        setWidget(0, 0, toolbar);
        setWidget(1, 0, area);
	}
}