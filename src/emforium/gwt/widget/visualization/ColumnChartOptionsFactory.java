package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.Table;

import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;

public class ColumnChartOptionsFactory extends CommonChartOptionsFactory<ColumnChart.Options, ColumnChartOptions,ColumnChart> {

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "ColumnChartOptions";

    public ColumnChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("enable3D", new BooleanAttributeSetter<ColumnChartOptions>() {
			public void set(final ColumnChartOptions widget, Element element,String name, boolean value) {
				widget.setEnable3D(value);
			}
        });
    	register("stacked", new BooleanAttributeSetter<ColumnChartOptions>() {
			public void set(final ColumnChartOptions widget, Element element,String name, boolean value) {
				widget.setStacked(value);
			}
        });
    }

    protected ColumnChartOptions newInstance(Element element) {
    	return new ColumnChartOptions();
    }
    
    public ColumnChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final ColumnChartOptions item = (ColumnChartOptions)createInstance(element);
        return item;
    }
}

class ColumnChartOptions extends CommonChartOptions<ColumnChart.Options, ColumnChartOptions,ColumnChart> {
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

	protected void initialize(ColumnChart.Options opt) {
		super.initialize(opt);
		opt.set3D(enable3D);
		opt.setStacked(stacked);
	}

	@Override
	protected ColumnChart.Options createChartOptions() {
		return ColumnChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return ColumnChart.PACKAGE;
	}

	@Override
	public ColumnChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<ColumnChart> loadCallback) {
		return new ColumnChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
