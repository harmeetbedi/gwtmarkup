package emforium.gwt.widget.visualization;

import java.util.Date;

import com.google.gwt.user.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.AnnotatedLegendPosition;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.ScaleType;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.WindowMode;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.GwtObjectFactory;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.DateAttributeSetter;

public class AnnotatedTimeLineOptionsFactory extends
		GwtObjectFactory<AnnotatedTimeLineOptions> {

	/** tag used in XML file to lookup factory */
	public static final String XML_TAG = "AnnotatedTimeLineOptions";

	public AnnotatedTimeLineOptionsFactory() {
	}

	protected void registerAttributes() {
		super.registerAttributes();
		register("allowHtml",new BooleanAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, boolean value) {
				widget.setAllowHtml(value);
			}
		});
		register("allValuesSuffix",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, String value) {
				widget.setAllValuesSuffix(value);
			}
		});
		register("annotationsWidth",new IntegerAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, int value) {
				widget.setAnnotationsWidth(value);
			}
		});
		register("displayAnnotations",new BooleanAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, boolean value) {
				widget.setDisplayAnnotations(value);
			}
		});
		register("displayAnnotationsFilter",new BooleanAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,
					Element element, String name, boolean value) {
				widget.setDisplayAnnotationsFilter(value);
			}
		});
		register("displayExactValues",new BooleanAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, boolean value) {
				widget.setDisplayExactValues(value);
			}
		});
		register("displayZoomButtons",new BooleanAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, boolean value) {
				widget.setDisplayZoomButtons(value);
			}
		});
		register("legendPosition",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,
					Element element, String name, String value) {
				widget.setLegendPosition(value);
			}
		});
		register("scaleType",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,
					Element element, String name, String value) {
				widget.setScaleType(value);
			}
		});
		register("windowMode",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,
					Element element, String name, String value) {
				widget.setWindowMode(value);
			}
		});
		register("min", new IntegerAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, int value) {
				widget.setMin(value);
			}
		});
		register("zoomEndTime",new DateAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, Date value) {
				widget.setZoomEndTime(value);
			}
		});
		register("zoomStartTime",new DateAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, Date value) {
				widget.setZoomStartTime(value);
			}
		});
		register("colors",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, String value) {
				widget.setColors(value);
			}
		});
		register("scaleColumns",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, String value) {
				widget.setScaleColumns(value);
			}
		});
		register("width",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, String value) {
				widget.setWidth(value);
			}
		});
		register("height",new StringAttributeSetter<AnnotatedTimeLineOptions>() {
			public void set(final AnnotatedTimeLineOptions widget,Element element, String name, String value) {
				widget.setHeight(value);
			}
		});
	}

	protected AnnotatedTimeLineOptions newInstance(Element element) {
		return new AnnotatedTimeLineOptions();
	}

	public AnnotatedTimeLineOptions create(java.util.List<Object> ancestors,
			final Element element) {
		final AnnotatedTimeLineOptions item = (AnnotatedTimeLineOptions) createInstance(element);
		return item;
	}
}

class AnnotatedTimeLineOptions extends AbstractDrawOptions<AnnotatedTimeLine.Options,AnnotatedTimeLine> {
	protected Boolean allowHtml;
	protected String allValuesSuffix;
	protected Integer annotationsWidth;
	protected String colors;
	protected Boolean displayAnnotations;
	protected Boolean displayAnnotationsFilter;
	protected Boolean displayExactValues;
	protected Boolean displayZoomButtons;
	protected String legendPosition;
	protected Integer min;
	protected String scaleColumns;
	protected String scaleType;
	protected String windowMode;
	protected Date zoomEndTime;
	protected Date zoomStartTime;
	protected String width;
	protected String height;

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setAllowHtml(boolean allowHtml) {
		this.allowHtml = allowHtml;
	}

	public void setAllValuesSuffix(String suffix) {
		this.allValuesSuffix = suffix;
	}

	public void setAnnotationsWidth(int width) {
		this.annotationsWidth = width;
	}

	public final void setColors(String colors) {
		this.colors = colors;
	}

	public void setDisplayAnnotations(boolean display) {
		this.displayAnnotations = display;
	}

	public void setDisplayAnnotationsFilter(boolean display) {
		this.displayAnnotationsFilter = display;
	}

	public void setDisplayExactValues(boolean display) {
		this.displayExactValues = display;
	}

	public void setDisplayZoomButtons(boolean display) {
		this.displayZoomButtons = display;
	}

	public final void setLegendPosition(String position) {
		this.legendPosition = position;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public final void setScaleColumns(String scaleColumns) {
		this.scaleColumns = scaleColumns;
	}

	public final void setScaleType(String type) {
		this.scaleType = type;
	}

	public final void setWindowMode(String wmode) {
		this.windowMode = wmode;
	}

	public final void setZoomEndTime(Date endTime) {
		this.zoomEndTime = endTime;
	}

	public final void setZoomStartTime(Date startTime) {
		this.zoomStartTime = startTime;
	}

	protected boolean isInitializable() {
		// if ( allowHtml == null ) return false;
		// if ( allValuesSuffix == null ) return false;
		// if ( annotationsWidth == null ) return false;
		// if ( colors == null ) return false;
		// if ( displayAnnotations == null ) return false;
		// if ( displayAnnotationsFilter == null ) return false;
		// if ( displayExactValues == null ) return false;
		// if ( displayZoomButtons == null ) return false;
		// if ( legendPosition == null ) return false;
		// if ( min == null ) return false;
		// if ( scaleColumns == null ) return false;
		// if ( scaleType == null ) return false;
		// if ( windowMode == null ) return false;
		// if ( zoomEndTime == null ) return false;
		// if ( zoomStartTime == null ) return false;
		if ( GwtHelper.isEmpty(width))  return false;
		if ( GwtHelper.isEmpty(height))  return false;
		return true;
	}

	protected void initialize(AnnotatedTimeLine.Options opt) {
		if (allowHtml != null)
			opt.setAllowHtml(allowHtml);
		if (GwtHelper.isNotEmpty(allValuesSuffix))
			opt.setAllValuesSuffix(allValuesSuffix);
		if (annotationsWidth != null)
			opt.setAnnotationsWidth(annotationsWidth);
		if (displayAnnotations != null)
			opt.setDisplayAnnotations(displayAnnotations);
		if (displayAnnotationsFilter != null)
			opt.setDisplayAnnotationsFilter(displayAnnotationsFilter);
		if (displayExactValues != null)
			opt.setDisplayExactValues(displayExactValues);
		if (displayZoomButtons != null)
			opt.setDisplayZoomButtons(displayZoomButtons);
		if (GwtHelper.isNotEmpty(legendPosition)) {
			AnnotatedLegendPosition posn = AnnotatedLegendPosition.valueOf(legendPosition.toUpperCase());
			if (posn != null)
				opt.setLegendPosition(posn);
		}
		if (min != null) {
			opt.setMin(min);
		}
		if (GwtHelper.isNotEmpty(scaleType)) {
			ScaleType stype = ScaleType.valueOf(scaleType.toUpperCase());
			if (stype != null)
				opt.setScaleType(stype);
		}
		if (GwtHelper.isNotEmpty(windowMode)) {
			WindowMode wmode = WindowMode.valueOf(windowMode.toUpperCase());
			if (wmode != null)
				opt.setWindowMode(wmode);
		}
		if (zoomStartTime != null)
			opt.setZoomStartTime(zoomStartTime);
		if (zoomEndTime != null)
			opt.setZoomEndTime(zoomEndTime);
		if (GwtHelper.isNotEmpty(colors)) {
			opt.setColors(colors.split(","));
		}
		if (GwtHelper.isNotEmpty(scaleColumns)) {
			String[] parts = scaleColumns.split(",");
			int[] cols = new int[parts.length];
			for (int i = 0; i < parts.length; i++)
				cols[i] = Integer.parseInt(parts[i]);
			opt.setScaleColumns(cols);
		}
	}

	protected AnnotatedTimeLine.Options createChartOptions() {
		return AnnotatedTimeLine.Options.create();
	}

	@Override
	public String getVisualizationPackage() {
		return AnnotatedTimeLine.PACKAGE;
	}

	@Override
	public AnnotatedTimeLine createVisualization(AbstractDataTable tbl,final VisualizationLoadCallback<AnnotatedTimeLine> loadCallback) {
		return new AnnotatedTimeLine(tbl,getChartOptions(),getWidth(),getHeight()) { 
			  protected void onLoad() {
				  super.onLoad();
				  if ( loadCallback != null )
					  loadCallback.loadDone(this);
			  }
		}; 
	}
}
