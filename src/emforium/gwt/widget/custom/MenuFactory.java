package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.menu.Item;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.custom.MenuItemFactory.MenuItem;
import emforium.gwt.widget.gxt.SplitButtonFactory;

public class MenuFactory extends SplitButtonFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "Menu";
    
    public MenuFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        register("text", new StringAttributeSetter<SplitMenu>() {
            public void set(SplitMenu widget, Element element, String name, String value) {
                widget.setText(value);
            }
        });
    }

    @Override
    protected SplitMenu newInstance(Element element) {
    	return new SplitMenu();
    }
    
    public SplitMenu create(java.util.List<Object> ancestors,final Element element) {
        final SplitMenu item = (SplitMenu)createInstance(element);
        new WidgetDOMConverter<SplitMenu>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
                if ( widget instanceof MenuItem ) {
                	item.add((Item)widget);
                	final MenuItem menuItem = ((MenuItem)widget);
                	((MenuItem)widget).addSelectionListener( new SelectionListener<ComponentEvent>() {
                		@Override
                		public void componentSelected(ComponentEvent ce) {
                			 item.removeAllListeners();
                		     item.addSelectionListener(menuItem.getSelectionListener());
                		     item.setText( menuItem.getText() );
                		}
                		
                	});
                }
            }
        };
        return item;
    }
    
    private class SplitMenu extends SplitButton {
    	Menu menu = new Menu(); 
    	public SplitMenu() {
    		super();
    		setMenu( menu );
		}
		public boolean add(Item item) {
			return menu.add(item);
		}
    }
}
