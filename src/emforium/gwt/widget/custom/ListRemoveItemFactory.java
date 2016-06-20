/**
 * 
 */
package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
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
public class ListRemoveItemFactory extends PushButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ListRemoveItem";

    protected void registerAttributes() {
		register("listcontainerid", new StringAttributeSetter<ListRemoveItem>() {
			public void set(final ListRemoveItem widget, Element element, String name, final String value) {
				widget.setListContainerId(value);
			}
		});
		register("listitemid", new StringAttributeSetter<ListRemoveItem>() {
			public void set(final ListRemoveItem widget, Element element, String name, final String value) {
				widget.setListItemId(value);
				widget.addClickListener(new ClickListener() {
					  public void onClick(Widget sender) {
							DeferredCommand.addCommand(new Command() {
								public void execute() {
									  widget.removeNode();
								}
							});
					  }
					});
			}
		});
	}
	protected ListRemoveItem newInstance(Element element) {
		return new ListRemoveItem();
	}

    public ListRemoveItem create(java.util.List<Object> ancestors,final Element element) {
        final ListRemoveItem item = (ListRemoveItem)createInstance(element);
        new WidgetDOMConverter<ListRemoveItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            	// remove node is not expected to have child elements.
            }
        };	
        return item;
    }
}

class ListRemoveItem extends PushButton {
	private String listContainerId;
	private String listItemId;
	public String getListContainerId() {
		return listContainerId;
	}
	public void setListContainerId(String listContainerId) {
		this.listContainerId = listContainerId;
	}
	public String getListItemId() {
		return listItemId;
	}
	public void setListItemId(String listItemId) {
		this.listItemId = listItemId;
	}
	public void removeNode() {
		ListManager.removeItem(listContainerId, listItemId);
	}
}