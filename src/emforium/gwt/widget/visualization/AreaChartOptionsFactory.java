package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.AreaChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;

public class AreaChartOptionsFactory extends CommonChartOptionsFactory<AreaChart.Options, AreaChartOptions, AreaChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "AreaChartOptions";

    public AreaChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("lineSize", new IntegerAttributeSetter<AreaChartOptions>() {
			public void set(final AreaChartOptions widget, Element element,String name, int value) {
				widget.setLineSize(value);
			}
        });
    	register("pointSize", new IntegerAttributeSetter<AreaChartOptions>() {
			public void set(final AreaChartOptions widget, Element element,String name, int value) {
				widget.setPointSize(value);
			}
        });
    	register("stacked", new BooleanAttributeSetter<AreaChartOptions>() {
			public void set(final AreaChartOptions widget, Element element,String name, boolean value) {
				widget.setStacked(value);
			}
        });
    }

    protected AreaChartOptions newInstance(Element element) {
    	return new AreaChartOptions();
    }
    
    public AreaChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final AreaChartOptions item = (AreaChartOptions)createInstance(element);
        return item;
    }
}

class AreaChartOptions extends CommonChartOptions<AreaChart.Options, AreaChartOptions,AreaChart> {
	protected Integer lineSize;
	protected Integer pointSize;
	protected Boolean stacked;
    public void setLineSize(int size) {
    	this.lineSize = size;
    }

    public void setPointSize(int size) {
    	this.pointSize = size;
    }

    public void setStacked(boolean smooth) {
    	this.stacked = smooth;
    }

	protected boolean isInitializable() {
		//if ( lineSize == null ) return false;
		//if ( pointSize == null ) return false;
		if ( stacked == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(AreaChart.Options opt) {
		super.initialize(opt);
		if ( lineSize != null )
			opt.setLineSize(lineSize);
		if ( pointSize != null )
			opt.setPointSize(pointSize);
		if ( stacked != null )
			opt.setStacked(stacked);
	}

	@Override
	protected AreaChart.Options createChartOptions() {
		return AreaChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return AreaChart.PACKAGE;
	}

	@Override
	public AreaChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<AreaChart> loadCallback) {
		return new AreaChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
