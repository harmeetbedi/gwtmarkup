package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.visualizations.Visualization;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;


public abstract class CommonOptionsFactory
	<X extends com.google.gwt.visualization.client.CommonOptions, T extends CommonOptions<X,T,V>,V extends Visualization<X>> 
	extends GwtObjectFactory<T> 
{

	public CommonOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("backgroundColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setBackgroundColor(value);
			}
        });
    	register("borderColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setBorderColor(value);
			}
        });
    	register("focusBorderColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setFocusBorderColor(value);
			}
        });
    	register("legendBackgroundColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setLegendBackgroundColor(value);
			}
        });
    	register("legendTextColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setLegendTextColor(value);
			}
        });
    	register("title", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setTitle(value);
			}
        });
    	register("titleColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setTitleColor(value);
			}
        });
    	register("colors", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setColors(value);
			}
        });
    	register("width", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setWidth(value);
			}
        });
    	register("height", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setHeight(value);
			}
        });
    	register("legendPosition", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setLegendPosition(value);
			}
        });
    }
}

/**
 * collects common options for all the visualization widgets
 * maps to com.google.gwt.visualization.client.CommonOptions
 */
abstract class CommonOptions
	<X extends com.google.gwt.visualization.client.CommonOptions, T extends CommonOptions<X,T,V>,V extends Visualization<X>>
	extends AbstractDrawOptions<X,V>
{
	protected String backgroundColor;
	protected String borderColor;
	protected String focusBorderColor;
	protected String legendBackgroundColor;
	protected String legendTextColor;
	protected String title;
	protected String titleColor;

	protected String colors; // comma separated list
	protected Integer width;
	protected Integer height;
	protected String legendPosition;
	
	/**
	 * override to check if all options have been set. It is necessary for xml markup to specify all options
	 * @return true if component can be initialized
	 */
	protected boolean isInitializable() {
		if ( backgroundColor == null ) return false;
		if ( borderColor == null ) return false;
		if ( colors == null ) return false;
		if ( width == null ) return false;
		if ( height == null ) return false;
		if ( legendPosition == null ) return false;
		if ( legendBackgroundColor == null ) return false;
		if ( legendTextColor == null ) return false;
		if ( title == null ) return false;
		if ( titleColor == null ) return false;
		return true;
	}

	/**
	 * override to add initialization for derived chart attributes
	 * @param opt
	 */
	protected void initialize(X opt) {
		if ( GwtHelper.isNotEmpty(backgroundColor) ) 
			opt.setBackgroundColor(backgroundColor);
		if ( GwtHelper.isNotEmpty(borderColor) ) 
			opt.setBorderColor(borderColor);
		if ( GwtHelper.isNotEmpty(focusBorderColor) ) 
			opt.setFocusBorderColor(focusBorderColor);
		if ( GwtHelper.isNotEmpty(legendBackgroundColor) ) 
			opt.setLegendBackgroundColor(legendBackgroundColor);
		if ( GwtHelper.isNotEmpty(legendTextColor) ) 
			opt.setLegendTextColor(legendTextColor);
		if ( GwtHelper.isNotEmpty(title) ) 
			opt.setTitle(title);
		if ( GwtHelper.isNotEmpty(titleColor) ) 
			opt.setTitleColor(titleColor);

		opt.setWidth(width);
		opt.setHeight(height);
		if ( GwtHelper.isNotEmpty(legendPosition) ) { 
			if ( legendPosition.equalsIgnoreCase(LegendPosition.BOTTOM.toString()) )
				opt.setLegend(LegendPosition.BOTTOM);
			else if ( legendPosition.equalsIgnoreCase(LegendPosition.LEFT.toString()) )
				opt.setLegend(LegendPosition.LEFT);
			else if ( legendPosition.equalsIgnoreCase(LegendPosition.NONE.toString()) )
				opt.setLegend(LegendPosition.NONE);
			else if ( legendPosition.equalsIgnoreCase(LegendPosition.RIGHT.toString()) )
				opt.setLegend(LegendPosition.RIGHT);
			else if ( legendPosition.equalsIgnoreCase(LegendPosition.TOP.toString()) )
				opt.setLegend(LegendPosition.TOP);
		}
		if ( GwtHelper.isNotEmpty(colors) ) {
			opt.setColors(colors.split(","));
		}
	}
	
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public void setFocusBorderColor(String focusBorderColor) {
		this.focusBorderColor = focusBorderColor;
	}

	public void setLegendBackgroundColor(String legendBackgroundColor) {
		this.legendBackgroundColor = legendBackgroundColor;
	}

	public void setLegendTextColor(String legendTextColor) {
		this.legendTextColor = legendTextColor;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setLegendPosition(String legendPosition) {
		this.legendPosition = legendPosition;
	}
}
