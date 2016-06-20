package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

public class MenuItemFactory extends emforium.gwt.widget.gxt.MenuItemFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MenuItem";
    
    public MenuItemFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        register("link", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setIconStyle(value);
            }
        });
        register("title", new StringAttributeSetter<MenuItem>() {
            public void set(MenuItem widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected MenuItem newInstance(Element element) {
        String title = element.getAttribute("title");
        String link = element.getAttribute("link");
    	return new MenuItem(title, link);
    }
    
    public MenuItem create(java.util.List<Object> ancestors,final Element element) {
        final MenuItem item = (MenuItem)createInstance(element);
        new WidgetDOMConverter<MenuItem>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
    
    public class MenuItem extends com.extjs.gxt.ui.client.widget.menu.CheckMenuItem {
    	private SelectionListener<ComponentEvent> selectionListener;
    	private String link;
    	private String title;
    	
    	public MenuItem(final String title, final String link) {
    		super( title );
    		setGroup("radios");
    		this.link = link;
    		this.title = title;
    		this.selectionListener = new SelectionListener<ComponentEvent>() {
    			public void componentSelected(ComponentEvent ce) {
    				Window.open(link, "_self", "");
    			};
    		}; 
    	}
    	
    	public String getLink() {
			return link;
		}

    	public void setLink(String link) {
			this.link = link;
		}

		public SelectionListener<ComponentEvent> getSelectionListener() {
			return selectionListener;
		}

		public void setSelectionListener(SelectionListener<ComponentEvent> selectionListener) {
			super.addSelectionListener( selectionListener );
			this.selectionListener = selectionListener;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
    	
    }
}
