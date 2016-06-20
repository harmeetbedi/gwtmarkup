package emforium.gwt.widget;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.ScrollContainer;
import com.extjs.gxt.ui.client.widget.toolbar.TextToolItem;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gwt.CustomButtonFactory;
import emforium.gwt.widget.gxt.ScrollContainerFactory;
import emforium.gwt.widget.gxt.TextToolItemFactory;

/**
 * Facility to add custom attributes. Invoked when register attributes is called on a factory. 
 */
@SuppressWarnings("unchecked")
class CustomAttributes<F extends GwtObjectFactory> {
	protected F factory;
	
	CustomAttributes() {} 

	protected CustomAttributes<F> setFactory(GwtObjectFactory<?> factory) {
		this.factory = (F)factory;
		return this;
	}
	
	static<F extends GwtObjectFactory> CustomAttributes<F> getInstance(F factory) {
		CustomAttributes value = new CustomAttributes<F>();
		if ( factory instanceof CustomButtonFactory )
			value = new CustomButtonAttributes();
		else if ( factory instanceof TextToolItemFactory )
			value = new CustomTextToolAttributes();
		else if ( factory instanceof ScrollContainerFactory )
			value = new CustomScrollContainerAttributes();

		value.setFactory(factory);
		return (CustomAttributes<F>)value;
	}
	
	public void registerAttributes() {
	}	

	/**
	 * use this to set custom attributes for all factories that derive from CustomButtonFactory
	 */
	private static class CustomButtonAttributes extends CustomAttributes<CustomButtonFactory> {
		@Override
		public void registerAttributes() {
	        factory.register("image", new StringAttributeSetter<CustomButton>() {
	            public void set(CustomButton widget, Element element, String name, String value) {
	                widget.getUpFace().setImage(new Image(value));
	            }
	        });
		}	
	}
	
	private static class CustomTextToolAttributes extends CustomAttributes<TextToolItemFactory> {
		@Override
		public void registerAttributes() {
			factory.register("url", new AttributeSetter<TextToolItem>() {
				public void set(TextToolItem widget, Element element, String name, final String value) {
					widget.addListener(Events.Select, new Listener<ToolBarEvent>() {
						public void handleEvent(ToolBarEvent tbe) {
							Window.open(value, "_self", ""); 
						}
					});
				}
			});
		}
	}

	/**
	 * use this to set custom attributes for all factories that derive from ScrollContainer
	 */
	private static class CustomScrollContainerAttributes extends CustomAttributes<ScrollContainerFactory> {
		@Override
		public void registerAttributes() {
	        factory.register("scrollMode", new StringAttributeSetter<ScrollContainer>() {
	            public void set(ScrollContainer widget, Element element, String name, String value) {
	                widget.setScrollMode(Enum.valueOf(Scroll.class, value.toUpperCase()));
	            }
	        });
		}	
	}
}

