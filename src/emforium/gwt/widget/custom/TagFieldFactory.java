/**
 * 
 */
package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusListenerAdapter;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupListener;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gwt.WidgetFactory;

/**
 * Factory for the Tag Field widget.
 *
 */
public class TagFieldFactory extends WidgetFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TagField";
    

	public TagFieldFactory() {
	}
	
    protected void registerAttributes() {
		register("name", new StringAttributeSetter<TagFieldContainer>() {
			public void set(TagFieldContainer widget, Element element, String name, String value) {
				widget.setInputName( value );
			}
		});
		register("tabIndex", new IntegerAttributeSetter<TagFieldContainer>() {
			@Override
			public
			void set(TagFieldContainer widget, Element element, String name, int value) {

			}
		});
	}
	protected TagFieldContainer newInstance(Element element) {
		return new TagFieldContainer();
	}

    public TagFieldContainer create(java.util.List<Object> ancestors,final Element element) {
        final TagFieldContainer item = (TagFieldContainer)createInstance(element);
        new WidgetDOMConverter<TagFieldContainer>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            	if( widget instanceof TagFieldOption ) {
            		TagFieldOption tagOption = (TagFieldOption)widget;
                	
            		String value = tagOption.getValue();
            		String name = tagOption.getName();
            		boolean enableDescription = tagOption.getEnableDescription().equals("true");
            		int displayDescriptionLength = Integer.valueOf(tagOption.getDisplayDescriptionLength());
            		String userDescription = tagOption.getUserDescription();
            		item.addOption(name, value, enableDescription, displayDescriptionLength, userDescription);

            		if( tagOption.getSelected().equals("true") ) {
            			// Create a tag for this
            			item.addTag(value, name);
            		}
            	}
            }
        };	
        return item;
    }
    
}

class TagFieldContainer extends FlowPanel {
	private FlowPanel tagContainer;
	
	private List<String[]> selectedItems = new ArrayList<String[]>();
	private Map<String, String> userDescriptions = new HashMap<String, String>();

	private String inputName;
	
	ListBox combo;

	boolean enableDescription;
	int displayDescriptionLength;
	
	public TagFieldContainer() {

		FlowPanel mainPanel = new FlowPanel();
		tagContainer = new FlowPanel();
		tagContainer.setStyleName("form-tag-container");
		mainPanel.add(tagContainer);

		combo = createCombo();
		combo.setSelectedIndex(-1);
		mainPanel.add(combo);

		add( mainPanel );
		
	}
	
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	private boolean addToList(String value, String text) {
		for( String[] selectedItem : selectedItems ) {
			if( selectedItem[0].equals( value ) ) 
				return false;
		}
		selectedItems.add(new String[] { value, text });
		return true;
	}

	private ListBox createCombo() {
		combo = new ListBox();
		
		combo.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				if(! (sender instanceof ListBox )) return;
				
				ListBox box = ((ListBox)sender);
				
				if( box.getSelectedIndex() == -1 ) return;
				
				String selected = box.getValue( box.getSelectedIndex() );
				String selectedText = box.getItemText(box.getSelectedIndex() );
				
				// Ignore if the selection has been changed to null.
				if (selected == null)
					return;

				box.setSelectedIndex( -1 );

				addTag( selected, selectedText );
			}
		});
		return combo;
	}

	void addOption(String name, String value, boolean enableDescription, int displayDescriptionLength, String userDescription) {
		combo.addItem(name, value);
		combo.setSelectedIndex(-1);
		userDescriptions.put(value, userDescription);
		this.enableDescription = enableDescription;
		this.displayDescriptionLength = displayDescriptionLength;
	}
	
	void addTag(String value, String text) {
		// If added to list then add the tag
		if (addToList(value,text)) {
			tagContainer.clear();
			for (String[] item : selectedItems) {
				tagContainer.add(createTagField(item[0], item[1]));
			}
		}
	}
	
	
	private TagField createTagField(String value, String text) {
		return new TagField(inputName, value, text);
	}
	
	/**
	 * This class is responsible for rendering the "Tag" which 
	 * is the items that have been selected in the combo box.
	 */
	class TagField extends FlowPanel
	{
		private final Label labelText = new Label();
		private final PopupPanel popupEditor = new PopupPanel(true, true);
		private final TextBox tagValue = new TextBox();
		private final TextBox tagUserDescription = new TextBox();
		private final TextArea editDescription = new TextArea();
		private final Image commentIcon = new Image();
		
		private boolean editingDescription = false;

		public TagField(final String inputName, final String value, final String text) {
			addStyleName("form-tag");

			PushButton removeButton = new PushButton( new Image("/emf-images/buttons/icon_delete.png") );
			removeButton.addClickListener(new ClickListener() {
				public void onClick(com.google.gwt.user.client.ui.Widget sender) {
					removeFromParent();
					
					for (String[] item : selectedItems) {
						if( item[0].equals( value))
							selectedItems.remove( item );
					}
				}
			});

			tagValue.setName(inputName);
			tagValue.setText(value);
			tagValue.setVisible(false);

			labelText.setText(text);

			if (enableDescription) {
				tagUserDescription.setName(inputName + "_" + value);
				tagUserDescription.setVisible(false);

				editDescription.setVisible(false);
				editDescription.addStyleName("edit-description");
				editDescription.setMaxLength(255);	// TODO: Parametrize this.  Add modal shadowing?
	
				String userDescription = userDescriptions.get(value);
				putDescription(userDescription);
			
				labelText.addClickListener(new ClickListener() {
					public void onClick(Widget sender) {
						editDescription();
					}
				});
				commentIcon.addClickListener(new ClickListener() {
					public void onClick(Widget sender) {
						editDescription();
					}
				});
	
				editDescription.addFocusListener(new FocusListenerAdapter(){
					public void onLostFocus(Widget sender) {
						if (editingDescription)
							acceptDescription();
						viewDescription();
					}
				});
				editDescription.addKeyboardListener(new KeyboardListenerAdapter(){
					public void onKeyDown(Widget sender, char keyCode, int modifiers) {
						if (keyCode == KEY_ESCAPE) {
							revertDescription();
							viewDescription();
						}
						if (keyCode == KEY_ENTER) {
							acceptDescription();
							viewDescription();
						}
					}
				});
			}
			
			add(labelText);
			if (enableDescription)
				add(commentIcon);
			add(removeButton);
			add(tagValue);
			if (enableDescription)
				add(tagUserDescription);

			ContentPanel editorPanel = new ContentPanel();
			editorPanel.setFrame(true);
			editorPanel.setHeading(text);
			editorPanel.add(editDescription);
			popupEditor.add(editorPanel);

			popupEditor.addPopupListener(new PopupListener() {
				public void onPopupClosed(PopupPanel sender, boolean autoClosed) {
					acceptDescription();
					viewDescription();
				}
			});
		
		}

		void editDescription() {
			if (editingDescription)
				return;
			editingDescription = true;
			editDescription.setText(userDescriptions.get(tagValue.getText()));
			editDescription.setVisible(true);
			popupEditor.setPopupPosition(getAbsoluteLeft() - 10, getAbsoluteTop() - 10);
			popupEditor.show();
			editDescription.setFocus(true);
			editDescription.setCursorPos(0);
		}

		void viewDescription() {
			if (!editingDescription)
				return;
			editingDescription = false;
			popupEditor.hide();
		}

		void acceptDescription() {
			final String userDescription = editDescription.getText();
			putDescription(userDescription);
		}

		void revertDescription() {
			editDescription.setText(userDescriptions.get(tagValue.getText()));
		}

		void putDescription(String userDescription) {
			String value = tagValue.getText();
			userDescriptions.put(value, userDescription);
			commentIcon.setUrl((userDescription != null && userDescription.length() > 0) ? "/emf-images/buttons/comment_filled.jpg" : "/emf-images/buttons/comment_empty.jpg");
			commentIcon.setTitle(userDescription);
			tagUserDescription.setText(userDescription);
		}
	}

}
