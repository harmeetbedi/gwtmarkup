package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.BarChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;

public class BarChartOptionsFactory extends CommonChartOptionsFactory<BarChart.Options, BarChartOptions,BarChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "BarChartOptions";

    public BarChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("enable3D", new BooleanAttributeSetter<BarChartOptions>() {
			public void set(final BarChartOptions widget, Element element,String name, boolean value) {
				widget.setEnable3D(value);
			}
        });
    	register("stacked", new BooleanAttributeSetter<BarChartOptions>() {
			public void set(final BarChartOptions widget, Element element,String name, boolean value) {
				widget.setStacked(value);
			}
        });
    }

    protected BarChartOptions newInstance(Element element) {
    	return new BarChartOptions();
    }
    
    public BarChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final BarChartOptions item = (BarChartOptions)createInstance(element);
        return item;
    }
}

class BarChartOptions extends CommonChartOptions<BarChart.Options, BarChartOptions,BarChart> {
	protected Boolean enable3D;
	protected Boolean stacked;
	void setEnable3D(boolean enable3D) {
		this.enable3D = enable3D;
	}
	void setStacked(boolean stacked) {
		this.stacked = stacked;
	}

	protected boolean isInitializable() {
		if ( enable3D == null ) return false;
		if ( stacked == null ) return false;
		return super.isInitializable();
	}

	protected void initialize(BarChart.Options opt) {
		super.initialize(opt);
		opt.set3D(enable3D);
		opt.setStacked(stacked);
	}
	
	@Override
	protected BarChart.Options createChartOptions() {
		return BarChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return BarChart.PACKAGE;
	}

	@Override
	public BarChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<BarChart> loadCallback) {
		return new BarChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
