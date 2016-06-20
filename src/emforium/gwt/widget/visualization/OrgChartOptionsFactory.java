package emforium.gwt.widget.visualization;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.MotionChart;
import com.google.gwt.visualization.client.visualizations.OrgChart;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.OrgChart.Size;

import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

public class OrgChartOptionsFactory extends GwtObjectFactory<OrgChartOptions> { 

    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "OrgChartOptions";

    public OrgChartOptionsFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    	register("size", new StringAttributeSetter<OrgChartOptions>() {
			public void set(final OrgChartOptions widget, Element element,String name, String value) {
				widget.setSize(value);
			}
        });
    	register("allowHtml", new BooleanAttributeSetter<OrgChartOptions>() {
			public void set(final OrgChartOptions widget, Element element,String name, boolean value) {
				widget.setAllowHtml(value);
			}
        });
    }

    protected OrgChartOptions newInstance(Element element) {
    	return new OrgChartOptions();
    }
    
    public OrgChartOptions create(java.util.List<Object> ancestors,final Element element) {
        final OrgChartOptions item = (OrgChartOptions)createInstance(element);
        return item;
    }
}

class OrgChartOptions extends AbstractDrawOptions<OrgChart.Options,OrgChart> {
	protected Boolean allowHtml;
	protected Size size;
    public void setAllowHtml(boolean allowHtml) {
    	this.allowHtml = allowHtml;
    }

    public void setSize(String size) {
    	this.size = Size.valueOf(size.toUpperCase());
    }

	protected boolean isInitializable() {
		if ( allowHtml == null ) return false;
		if ( size == null ) return false;
		return true;
	}

	protected void initialize(OrgChart.Options opt) {
		if ( allowHtml != null )
			opt.setAllowHtml(allowHtml);
		if ( size != null )
			opt.setSize(size);
	}

	protected OrgChart.Options createChartOptions() {
		return OrgChart.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return OrgChart.PACKAGE;
	}

	@Override
	public OrgChart createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<OrgChart> loadCallback) {
		return new OrgChart(tbl,getChartOptions()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
