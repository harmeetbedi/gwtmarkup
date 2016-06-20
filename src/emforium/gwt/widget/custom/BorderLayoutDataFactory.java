/**
 * 
 */
package emforium.gwt.widget.custom;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.LayoutDataFactory;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.*;

/**
 * Factory for the NumberField widget.
 *
 */
public class BorderLayoutDataFactory extends LayoutDataFactory<BorderLayoutData> {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "BorderLayoutData";

	public BorderLayoutDataFactory() {
	}
	
    @SuppressWarnings("unchecked")
    protected void registerAttributes() {
		register("minSize", new IntegerAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, int value) {
				widget.setMinSize(value);
			}
		});
		register("floatable", new BooleanAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, boolean value) {
				widget.setFloatable(value);
			}
		});
		register("maxSize", new IntegerAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, int value) {
				widget.setMinSize(value);
			}
		});
		register("size", new FloatAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, float value) {
				widget.setSize(value);
			}
		});
		register("collapsible", new BooleanAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, boolean value) {
				widget.setCollapsible(value);
			}
		});
		register("margins", new StringAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, String value) {
				String[] margin = value.split(",");
				if ( margin.length != 4 && margin.length != 1)
					throw new RuntimeException("margin should have 4 values or a single value. found : "+value);
				if ( margin.length == 1 )
					widget.setMargins(new Margins(Integer.parseInt(margin[0])));
				else
					widget.setMargins(new Margins(Integer.parseInt(margin[0]),Integer.parseInt(margin[1]),Integer.parseInt(margin[2]),Integer.parseInt(margin[3])));
			}
		});
		register("split", new BooleanAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, boolean value) {
				widget.setSplit(value);
			}
		});
		register("region", new StringAttributeSetter<BorderLayoutData>() {
			public void set(BorderLayoutData widget, Element element, String name, String value) {
				widget.setRegion(Enum.valueOf(LayoutRegion.class, value.toUpperCase()));
			}
		});
	}
	protected BorderLayoutData newInstance(Element element) {
		return new BorderLayoutData(LayoutRegion.CENTER);
	}

    public BorderLayoutData create(List<Object> ancestors, final Element element) {
        final BorderLayoutData item = (BorderLayoutData)createInstance(element);
        new WidgetDOMConverter<BorderLayoutData>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };	
        return item;
    }
}