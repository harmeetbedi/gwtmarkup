package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.visualizations.Visualization;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

public abstract class CommonChartOptionsFactory
	<X extends com.google.gwt.visualization.client.CommonChartOptions, T extends CommonChartOptions<X,T,V>,V extends Visualization<X>> 
	extends CommonOptionsFactory<X,T,V> 
{
    public CommonChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("axisBackgroundColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setAxisBackgroundColor(value);
			}
        });
    	register("axisColor", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setAxisColor(value);
			}
        });
    	register("titleX", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setTitleX(value);
			}
        });
    	register("titleY", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setTitleY(value);
			}
        });
    	register("reverseAxis", new BooleanAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, boolean value) {
				widget.setReverseAxis(value);
			}
        });
    }
}

abstract class CommonChartOptions
	<X extends com.google.gwt.visualization.client.CommonChartOptions,T extends CommonChartOptions<X,T,V>,V extends Visualization<X>> 
	extends CommonOptions<X,T,V> 
{
	protected String axisBackgroundColor;
	protected String axisColor;
	protected Integer titleX;
	protected Integer titleY;
	protected Boolean reverseAxis;

	public void setAxisBackgroundColor(String color) {
	   this.axisBackgroundColor = color;
	 }

	public void setAxisColor(String color) {
	   this.axisColor = color;
	 }

	public void setReverseAxis(boolean reverseAxis) {
	   this.reverseAxis = reverseAxis;
	 }

	public void setTitleX(int x) {
	   this.titleX = x;
	 }

	public void setTitleY(int y) {
	   this.titleY = y;
	 }

	protected boolean isInitializable() {
		if ( axisBackgroundColor == null ) return false;
		if ( axisColor == null ) return false;
		//if ( titleX == null ) return false;
		//if ( titleY == null ) return false;
		//if ( reverseAxis == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(X opt) {
		super.initialize(opt);
		if ( GwtHelper.isNotEmpty(axisBackgroundColor) ) 
			opt.setAxisBackgroundColor(axisBackgroundColor);
		if ( GwtHelper.isNotEmpty(axisBackgroundColor) ) 
			opt.setAxisColor(axisBackgroundColor);
		if ( reverseAxis != null ) 
			opt.setReverseAxis(reverseAxis);
		if ( titleX != null )
			opt.setTitleX(titleX);
		if ( titleY != null )
			opt.setTitleY(titleY);
	}
}
