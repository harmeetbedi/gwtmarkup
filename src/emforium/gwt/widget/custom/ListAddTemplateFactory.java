package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.Element;

import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
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
public class ListAddTemplateFactory extends LayoutContainerFactory {
	/** tag used in XML file to lookup factory */
	public static final String XML_TAG = "ListAddTemplate";

	protected void registerAttributes() {
		register("containerid", new StringAttributeSetter<ListAddTemplate>() {
			// this does not work because element represent 'add' does not have subelements in it.
			public void set(final ListAddTemplate widget, final Element element, String name, final String value) {
				widget.setListContainerId(value);
			}
		});
	}
	protected ListAddTemplate newInstance(Element element) {
		return new ListAddTemplate();
	}

	public ListAddTemplate create(java.util.List<Object> ancestors,final Element element) {
		String id = element.getId();
		final ListAddTemplate item = (ListAddTemplate)createInstance(element);
		item.setTemplateId(id);
		ListManager.registerTemplate(item);
		// keep reference to sub elements. no need to recurse and interpret child nodes
		item.setMarkupToAdd(element.getInnerHTML());
		element.setInnerHTML("");
		return item;
	}

	/** Add node wraps an HTML done snippet that is dynamically added */
	public class ListAddTemplate extends LayoutContainer {
		private String markupToAdd;
		private String listContainerId;
		private String templateId;
		public String getTemplateId() {
			return templateId;
		}
		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}
		public String getListContainerId() {
			return listContainerId;
		}
		public void setListContainerId(String listContainerId) {
			this.listContainerId = listContainerId;
		}
		public String getMarkupToAdd() {
			return markupToAdd;
		}
		public void setMarkupToAdd(String markupToAdd) {
			this.markupToAdd = markupToAdd;
		}
	}
}

