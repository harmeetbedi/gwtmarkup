package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.XDOM;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.ElementComponent;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.GwtObjectFactoryLookup;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gwt.PushButtonFactory;
import emforium.gwt.widget.gwt.WidgetFactory;
import emforium.gwt.widget.gxt.LayoutContainerFactory;

/**
 * Factory to add html elements to dom. See: 
 * <pre>
 * Basically it works in this way.
 * &le;div gwt-type="AddNode" containerid="containerid" gwt-children-type="all" image="./images/Add_btn.png"&gt;
 *	&le;...  some html and gwt snippet ...&gt;
 *	&le;/div&gt;
 *
 * and
 * &le;div id="conainerid" gwt-type="LayoutContainer"&gt;&le;/div&gt;
 * 
 * AddNode is really Button. On initial dom interpretation the snippet
 * inside DOM is removed and stored.  OnClick action html snippet
 * contained is cloned, assigned a uniqueid, interpreted (to insert gwt
 * widgets) and appended to container with containerid.
 * 
 * The other part of this is RemoveNode. This is again a button and
 * OnClick removes div tag with specific id from dom.
 * 
 * List management works in UI due to these 3 things:
 * - Add node inserts DOM inside container
 * - Remove node removes element with specific id.
 * - Add node inserts dom with new id.
 * 
 * AddNode should contain a DOM element withRemoveNode,
 * making newly inserted DOM on AddNode click removable on RemoveNode click
 * </pre>
 */
public class ListExistingItemsFactory extends LayoutContainerFactory {
	/** tag used in XML file to lookup factory */
	public static final String XML_TAG = "ListExistingItems";

	protected void registerAttributes() {
		register("containerid", new StringAttributeSetter<ListExistingItems>() {
			// this does not work because element represent 'add' does not have subelements in it.
			public void set(final ListExistingItems widget, final Element element, String name, final String value) {
				widget.setContainerId(value);
			}
		});
	}
	protected ListExistingItems newInstance(Element element) {
		return new ListExistingItems();
	}

	public ListExistingItems create(java.util.List<Object> ancestors,final Element element) {
		//System.out.println(element.getInnerHTML());
		final ListExistingItems item = (ListExistingItems)createInstance(element);
		new WidgetDOMConverter<ListExistingItems>(ancestors,item,element) {
			@Override
			protected void addUIObject(UIObject widget) {
				//System.out.println("ListExistingItems: "+widget.getClass().getName());
				ListManager.addToContainer(item.getContainerId(),widget);
			}
		};
		return item;
	}
}

/** Add node wraps an HTML done snippet that is dynamically added */
class ListExistingItems extends LayoutContainer {
	private String containerId;
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
}