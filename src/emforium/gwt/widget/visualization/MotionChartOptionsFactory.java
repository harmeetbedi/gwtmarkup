package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.MotionChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;

public class MotionChartOptionsFactory extends GwtObjectFactory<MotionChartOptions> { 

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "MotionChartOptions";

    public MotionChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("height", new IntegerAttributeSetter<MotionChartOptions>() {
			public void set(final MotionChartOptions widget, Element element,String name, int value) {
				widget.setHeight(value);
			}
        });
    	register("width", new IntegerAttributeSetter<MotionChartOptions>() {
			public void set(final MotionChartOptions widget, Element element,String name, int value) {
				widget.setWidth(value);
			}
        });
    }

    protected MotionChartOptions newInstance(Element element) {
    	return new MotionChartOptions();
    }
    
    public MotionChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final MotionChartOptions item = (MotionChartOptions)createInstance(element);
        return item;
    }
}

class MotionChartOptions extends AbstractDrawOptions<MotionChart.Options,MotionChart> {
	protected Integer height;
	protected Integer width;
    public void setHeight(int height) {
    	this.height = height;
    }

    public void setWidth(int width) {
    	this.width = width;
    }

	protected boolean isInitializable() {
		if ( height == null ) return false;
		if ( width == null ) return false;
		return true;
	}

	protected void initialize(MotionChart.Options opt) {
		if ( height != null )
			opt.setHeight(height);
		if ( width != null )
			opt.setWidth(width);
	}

	protected MotionChart.Options createChartOptions() {
		return MotionChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return MotionChart.PACKAGE;
	}

	@Override
	public MotionChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<MotionChart> loadCallback) {
		return new MotionChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
