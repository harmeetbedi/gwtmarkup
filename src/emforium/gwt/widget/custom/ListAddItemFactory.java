/**
 * 
 */
package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gwt.PushButtonFactory;

/**
 * Factory to remove xml element from dom. RemoveNode is expected to have 'targetid' attribute. 
 * OnClick action dom element id == 'targetid' is removed. 
 */
public class ListAddItemFactory extends PushButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ListAddItem";

    protected void registerAttributes() {
		register("templateid", new StringAttributeSetter<ListAddItem>() {
			public void set(final ListAddItem widget, Element element, String name, final String value) {
				widget.setListTemplateId(value);
				widget.addClickListener(new ClickListener() {
					public void onClick(Widget sender) {
						ListAddTemplateFactory.ListAddTemplate template = ListManager.getTemplate(value);
						ListManager.addItem(template);
					}
				});
			}
		});
	}
	protected ListAddItem newInstance(Element element) {
		return new ListAddItem();
	}

    public ListAddItem create(java.util.List<Object> ancestors,final Element element) {
        final ListAddItem item = (ListAddItem)createInstance(element);
        new WidgetDOMConverter<ListAddItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            	// remove node is not expected to have child elements.
            }
        };	
        return item;
    }
}

class ListAddItem extends PushButton {
	private String listTemplateId;
	public String getListTemplateId() {
		return listTemplateId;
	}
	public void setListTemplateId(String listTemplateId) {
		this.listTemplateId = listTemplateId;
	}
	public void addNode() {
	}
}