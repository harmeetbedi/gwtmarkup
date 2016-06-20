/**
 * 
 */
package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gwt.WidgetFactory;

/**
 * Factory for the Tag Field widget.
 *
 */
public class TagFieldOptionFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TagFieldOption";
    

	public TagFieldOptionFactory() {
	}
	
    protected void registerAttributes() {
		register("name", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setName( value );
			}
		});
		register("value", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setValue( value );
			}
		});
		register("selected", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setSelected( value );
			}
		});
		register("enable-description", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setEnableDescription( value );
			}
		});
		register("user-description", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setUserDescription( value );
			}
		});
		register("display-description-length", new StringAttributeSetter<TagFieldOption>() {
			public void set(TagFieldOption widget, Element element, String name, String value) {
				widget.setDisplayDescriptionLength( value );
			}
		});
	}
	protected TagFieldOption newInstance(Element element) {
		return new TagFieldOption();
	}

    public TagFieldOption create(java.util.List<Object> ancestors,final Element element) {
        final TagFieldOption item = (TagFieldOption)createInstance(element);
        return item;
    }
    
}

class TagFieldOption extends Widget {
	private String name;
	private String value;
	private String selected;
	private String enableDescription = "false"; 
	private String displayDescriptionLength = "25";
	private String userDescription;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getSelected() {
		return selected;
	}
	public void setEnableDescription(String enableDescription) {
		this.enableDescription = enableDescription;
	}
	public String getEnableDescription() {
		return enableDescription;
	}
	public void setDisplayDescriptionLength(String displayDescriptionLength) {
		this.displayDescriptionLength = displayDescriptionLength;
	}
	public String getDisplayDescriptionLength() {
		return displayDescriptionLength;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public String getUserDescription() {
		return userDescription;
	}
}
