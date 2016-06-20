package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.XDOM;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.EditorEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridView;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.grid.RowExpander;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.tips.QuickTip;
import com.extjs.gxt.ui.client.widget.tips.ToolTip;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.InvokeJsArgs;
import emforium.gwt.widget.MarkupConstants;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.BooleanAttributeSetter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;
import emforium.gwt.widget.gxt.ContentPanelFactory;
import emforium.gwt.widget.gxt.ToolTipFactory;


public  abstract class AbstractGridFactory<T extends AbstractGrid> extends ContentPanelFactory {
    public AbstractGridFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        register("grid-width", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setGridWidth(value);
			}
        });
        register("grid-height", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setGridHeight(value);
			}
        });
        register("qtip-width", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setQtipWidth(value);
			}
        });
        register("scrollbar-width", new IntegerAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, int value) {
				widget.setScrollbarWidth(value);
			}
        });
        register("scroll-mode", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setScrollMode(value);
			}
        });
        register("show-group-columns", new BooleanAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, boolean value) {
				widget.setShowGroupColumns(value);
			}
        });
        register("row-expander-template", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setRowExpanderTemplate(value);
			}
        });
        register("on-row-click", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setOnRowClick(value);
			}
        });
        register("on-row-double-click", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setOnRowDoubleClick(value);
			}
        });
        register("selection-model", new StringAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, String value) {
				widget.setSelectionModel(value);
			}
        });
        register("row-numbers-enabled", new BooleanAttributeSetter<T>() {
			public void set(final T widget, Element element,String name, boolean value) {
				widget.setRowNumbersEnabled(value);
			}
        });
    }

    @Override
    protected final T newInstance(Element element) {
    	T grid = createGrid(element);
    	createPostProcess(grid,element);
    	return grid;
    }

    // create concrete grid type
    protected abstract T createGrid(Element element);

    // called after create is done to allow custom post processing. Can be used to read and fill data from innerHtml.
    protected void createPostProcess(T grid,Element element) {
    }
    
    @SuppressWarnings("unchecked")
	public final T create(java.util.List<Object> ancestors,final Element element) {
        final T item = (T)createInstance(element);
        new WidgetDOMConverter<T>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}

abstract class AbstractGrid extends ContentPanel implements MarkupConstants {
	protected List<GridColumnSpec> columnSpecs;
	protected List<ColumnConfig> columns;
	protected RowExpander rowExpander;
	protected RowNumberer rowNumberer;
	protected CheckBoxSelectionModel<ModelData> checkBoxSelModel; 
	protected int gridWidth = -1;
	protected int gridHeight = -1;
	protected String qtipWidth = null;
	protected Boolean showGroupColumns;
	protected String scrollMode = null;
	protected int scrollbarWidth = 0;
	protected boolean gridInitialized = false;
	private boolean editableGrid;
	private GridView gridView;
	private boolean groupedGrid = false;
	private String rowExpanderTemplateText = null;
	private String onRowClick = null;
	private String onRowDoubleClick = null;
	private GridColumnSpec groupedColSpec = null;
	private List<ComponentPlugin> gridPlugins = new ArrayList<ComponentPlugin>();
	private Element toolTipElem;
	
	AbstractGrid() {
		//setIconStyle("icon-form");
		//panel.setHeaderVisible(true);
	    setLayout(new FitLayout());
		setBorders(false);
	    setHeaderVisible(false);
	    //setHeight(350);
	}
	
	protected boolean isEditableGrid() {
		return editableGrid;
	}
	
	protected boolean isGroupedGrid() {
		return groupedGrid;
	}

    protected Grid<ModelData> newGridInstance(final ListStore<ModelData> store) {
    	loadColumnConfig(); 

	    final Grid<ModelData> grid = isEditableGrid() 
					? new EditorGrid<ModelData>(store, getColumnModel())
					: new Grid<ModelData>(store, getColumnModel());
	    initAutoExpandColumn(grid);
	    grid.setAutoHeight(true);
	    grid.setAutoWidth(true);
	    grid.setView(getGridView());
	    //grid.setBorders(true);
	    // this sets up the tooltip hooks
	    ToolTip tip = null;
	    if ( toolTipElem != null ) {
		    ToolTipFactory ttFactory = new ToolTipFactory() {
		        protected ToolTip newInstance(Element element) {
		            return new QuickTip(grid);
		        }
		    };
		    tip = ttFactory.create(new ArrayList<Object>(), toolTipElem);
	    } else {
	        tip = new QuickTip(grid);
		    if ( GwtHelper.isNotEmpty(qtipWidth)) {
		    	tip.setWidth(qtipWidth);
		    } else {
		    	tip.setAutoWidth(true);
		    }
	        tip.setAutoHeight(true);
		    //tip.addStyleName("customqtip");
	    }
	    
	    // add the plugins
	    if ( rowNumberer != null ) {
	    	grid.addPlugin(rowNumberer);
	    }
	    if ( checkBoxSelModel != null ) {
	    	grid.addPlugin(checkBoxSelModel);
	    	grid.setSelectionModel(checkBoxSelModel);
	    }
	    if ( rowExpander != null ) {
	    	grid.addPlugin(rowExpander);
	    }
	    for ( ComponentPlugin plugin : gridPlugins ) {
	    	grid.addPlugin(plugin);
	    }
	    
	    attachClickEvent(Events.RowClick,onRowClick,grid,store);
	    attachClickEvent(Events.RowDoubleClick,onRowDoubleClick,grid,store);

	    return grid;
    }
    
    private void attachClickEvent(int eventType, final String callbackTemplate,Grid<ModelData> grid,final ListStore<ModelData> store) {
		if (GwtHelper.isEmpty(callbackTemplate))
			return;

		final String id = this.getId();
		Listener<GridEvent> rowClickListener = new Listener<GridEvent>() {
			public void handleEvent(GridEvent e) {
				if (e.colIndex < 0 || e.colIndex >= columnSpecs.size()) {
					return;
				}
				GridColumnSpec spec = columnSpecs.get(e.colIndex);
				if (!spec.isRowClickEnabled()) {
					return;
				}

				ModelData model = store.getAt(e.rowIndex);
				if (model == null) {
					// outside the rows
					return;
				}
				XTemplate template = XTemplate.create(callbackTemplate);
				String callback = template.applyTemplate(Util
						.getJsObject(model));
				// System.out.println("row-click-callback:"+callback);
				new InvokeJsArgs(id, callback, true).invoke();
			}
		};
		grid.addListener(eventType, rowClickListener);
	}
    
    protected GridView getGridView() {
    	if ( gridView == null ) {
    		if ( groupedGrid ) {
    			GroupingView view = new GroupingView();
    			view.setForceFit(true);  
    			view.setGroupRenderer(new GridGroupRenderer() {  
    				public String render(GroupColumnData data) {  
    					String f = groupedColSpec.getDisplay();  
    					String l = data.models.size() == 1 ? "Item" : "Items";  
    					return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";  
    				}  
    			});
    			if ( showGroupColumns != null ) { 
    				view.setShowGroupedColumn(showGroupColumns);
    			}
    			this.gridView = view;
    		} else {
    			gridView = new GridView();
    			gridView.setForceFit(true);
    		}
    	}
    	//gridView.setShowDirtyCells(false);
    	return gridView;
    }

    // this is set at widget create instance time.
	void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
		initGrid();
	}

	void setQtipWidth(String qtipWidth) {
		this.qtipWidth = qtipWidth;
		initGrid();
	}

	// this is set at widget create instance time.
	void setScrollMode(String scrollMode) {
		if ( "auto".equalsIgnoreCase(scrollMode) )
			setScrollMode(Scroll.AUTO);
		else if ( "autox".equalsIgnoreCase(scrollMode) )
			setScrollMode(Scroll.AUTOX);
		else if ( "autoy".equalsIgnoreCase(scrollMode) )
			setScrollMode(Scroll.AUTOY);
		else if ( "always".equalsIgnoreCase(scrollMode) )
			setScrollMode(Scroll.ALWAYS);
		else if ( "none".equalsIgnoreCase(scrollMode) )
			setScrollMode(Scroll.NONE);
		this.scrollMode = scrollMode;
		initGrid();
	}
	
	public boolean doLayout() {
		if ( gridWidth <= 0 ) {
			gridWidth = this.getWidth() - scrollbarWidth;
			//setAutoWidth(true);
			//setAutoWidth(true);
			initGrid();
		}
		return super.doLayout();
	}
	
	void setRowExpanderTemplate(String rowExpanderTemplateText) {
		this.rowExpanderTemplateText = rowExpanderTemplateText;
		if ( GwtHelper.isNotEmpty(rowExpanderTemplateText) ) {
			// this is to get around IE issues
			rowExpanderTemplateText = rowExpanderTemplateText.replace("lt-x-lt", "<");
			rowExpanderTemplateText = rowExpanderTemplateText.replace("gt-x-gt", ">");
    		XTemplate tpl = XTemplate.create(rowExpanderTemplateText);
    		rowExpander = new RowExpander();  
    		rowExpander.setTemplate(tpl);
		}
		initGrid();
	}
	
	void setRowNumbersEnabled(boolean enable) {
		if ( enable ) {
			rowNumberer = new RowNumberer();
		}
		initGrid();
	}
	
	void setOnRowClick(String onRowClick) {
		this.onRowClick = onRowClick;
		initGrid();
	}
	
	void setOnRowDoubleClick(String onRowDoubleClick) {
		this.onRowDoubleClick = onRowDoubleClick;
		initGrid();
	}
	
	void setSelectionModel(String selectionModel) {
		if ( "checkbox-multi".equalsIgnoreCase(selectionModel) ) {
			checkBoxSelModel = new CheckBoxSelectionModel<ModelData>();
			checkBoxSelModel.setSelectionMode(SelectionMode.MULTI);
		}
		else if ( "checkbox-single".equalsIgnoreCase(selectionModel) ) {
			checkBoxSelModel = new CheckBoxSelectionModel<ModelData>() {
				  // do nothing on header click
				  protected void onHeaderClick(GridEvent e) {
				  }
			};
			checkBoxSelModel.getColumn().setHeader("");
			checkBoxSelModel.setSelectionMode(SelectionMode.SINGLE);
		}
		else if ( "checkbox-simple".equalsIgnoreCase(selectionModel) ) {
			checkBoxSelModel = new CheckBoxSelectionModel<ModelData>();
			checkBoxSelModel.setSelectionMode(SelectionMode.SIMPLE);
		}
 		initGrid();
	}
	
	// called from grid initialization to setup the column that will auto expand as needed
	@SuppressWarnings("unchecked")
	protected final void initAutoExpandColumn(Grid grid) {
	    // check if there is a specific auto expand column
	    for ( GridColumnSpec spec : columnSpecs ) {
	    	if ( !spec.isHidden() ) {
		    	if ( spec.isAutoExpand() ) {
				    String expandColId = spec.getField();
				    grid.setAutoExpandColumn(expandColId);
				    return;
		    	}
	    	}
	    }

	    // make first column auto expand
	    for ( GridColumnSpec spec : columnSpecs ) {
	    	if ( !spec.isFixed() && spec.getDisplay().trim().length() > 0 ) {
			    String expandColId = spec.getField();
			    grid.setAutoExpandColumn(expandColId);
	    	}
	    }
	}
	
	// override to add additional checks
	protected boolean isGridInitializable() {
		return ( 
				gridWidth > 0 
				&& gridHeight >= 0 
				&& scrollMode != null 
				&& showGroupColumns != null 
				&& rowExpanderTemplateText != null
				&& onRowClick != null
				&& onRowDoubleClick != null
				&& qtipWidth != null
				);
	}

	void setShowGroupColumns(boolean showGroupColumns) {
		this.showGroupColumns = showGroupColumns;
		initGrid();
	}

	void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
		initGrid();
	}

	// this is set at widget create instance time.
	void setScrollbarWidth(int scrollbarWidth) {
		this.scrollbarWidth = scrollbarWidth;
	}

	protected void loadColumnConfig() {
	    // check if loaded
		if ( columns != null )
			return;
		// check if can load
		if ( columnSpecs == null )
			return;

		// load
		columns = new ArrayList<ColumnConfig>();
		if ( rowNumberer != null ) {
			columns.add(rowNumberer);
		}
		if ( checkBoxSelModel != null ) {
			columns.add(checkBoxSelModel.getColumn());
		}
		if ( rowExpander != null ) {
			columns.add(rowExpander);
		}

		// figure out total size for columns
		int weightedWidth = 0;
		int totalWidthAvailable = gridWidth;
		for ( GridColumnSpec spec : columnSpecs ) {
			if ( !spec.isHidden() ) {
				if ( spec.getAbsoluteWidth() <= 0 ) {
					weightedWidth += spec.getRelativeWidth();
				} else {
					totalWidthAvailable -= spec.getAbsoluteWidth();
				}
			}
		}
		if ( weightedWidth == 0 )
			weightedWidth = 1;
		if ( totalWidthAvailable < 0 )
			totalWidthAvailable = 0;
		
		for ( GridColumnSpec spec : columnSpecs ) {
			int width = 0;
			if ( spec.isHidden() )
				width = 0;
			else if ( spec.getAbsoluteWidth() <= 0 )
				width = spec.getRelativeWidth()*totalWidthAvailable/weightedWidth;
			else
				width = spec.getAbsoluteWidth();
			
			//System.out.println("display: "+spec.getField()+", "+spec.getDisplay()+", "+width+", "+totalWidthAvailable+", "+gridWidth+", "+getWidth()+", abs:"+spec.getAbsoluteWidth());

			final ColumnConfig cc;
			if ( "boolean".equalsIgnoreCase(spec.getType()) ) { 
				CheckColumnConfig checkConf = new CheckColumnConfig(spec.getField(), spec.getDisplay(), width);
				gridPlugins.add(checkConf);
				cc = checkConf;
			} else {
				cc = new ColumnConfig(spec.getField(), spec.getDisplay(), width);
			}

			cc.setHidden(spec.isHidden());
			cc.setSortable(spec.isSortable());
			cc.setFixed(spec.isFixed());
			cc.setGroupable(spec.isGroupable());
			cc.setMenuDisabled(spec.isMenuDisabled());

			// render tooltip
			if ( spec.isShowToolTip() ) {
				final String tooltipTemplate = spec.getToolTipTemplate();
				final String tooltipTemplateRefId = spec.getToolTipTemplateRefId();
				if ( GwtHelper.isNotEmpty(tooltipTemplateRefId)) {
					// tooltip has a template
				    GridCellRenderer<ModelData> templateToolTipRefRenderer = new GridCellRenderer<ModelData>() {
						@SuppressWarnings("deprecation")
						public String render(ModelData model, String property,ColumnData config, int rowIndex, int colIndex,ListStore<ModelData> store) 
						{
							XTemplate template = XTemplate.create(tooltipTemplateRefId);
							String tooltipRefId = template.applyTemplate(Util.getJsObject(model));
							Object myColumnData = model.get( property );
							String value = String.valueOf(myColumnData);

							Element elem = XDOM.getElementById(tooltipRefId);
							if ( elem == null )
								return value;
							String tooltip = GwtXMLHelper.getAttribute(elem, "value");
							if ( GwtHelper.isEmpty(tooltip) )
								return value;
							// this is to get around IE issues
							tooltip = tooltip.replace("lt-x-lt", "<");
							tooltip = tooltip.replace("gt-x-gt", ">");
							tooltip = tooltip.replace("'","&apos;");
							String html = "<span qtip='" + tooltip + "'>"+ value + "</span>";
							//cc.getToolTip()
							return html;
						}
				    };
					cc.setRenderer(templateToolTipRefRenderer);
				} else if ( GwtHelper.isNotEmpty(tooltipTemplate)) {
					// tooltip has a template
				    GridCellRenderer<ModelData> templateToolTipRenderer = new GridCellRenderer<ModelData>() {
						@SuppressWarnings("deprecation")
						public String render(ModelData model, String property,ColumnData config, int rowIndex, int colIndex,ListStore<ModelData> store) 
						{
							XTemplate template = XTemplate.create(tooltipTemplate);
							String tooltip = template.applyTemplate(Util.getJsObject(model));
							Object myColumnData = model.get( property );
							String value = String.valueOf(myColumnData);
							tooltip = tooltip.replace("lt-x-lt", "<");
							tooltip = tooltip.replace("gt-x-gt", ">");
							tooltip = tooltip.replace("'","&apos;");
							String html = "<span qtip='" + tooltip + "'>"+ value + "</span>";
							//cc.getToolTip()
							return html;
						}
				    };
					cc.setRenderer(templateToolTipRenderer);
				} else {
					// template is empty show default render
				    GridCellRenderer<ModelData> defaultToolTipRenderer = new GridCellRenderer<ModelData>() {
						public String render(ModelData model, String property,ColumnData config, int rowIndex, int colIndex,ListStore<ModelData> store) 
						{
							Object myColumnData = model.get( property );
							if ( myColumnData == null ) {
								return "";
							} else {
								String value = String.valueOf(myColumnData);
								String tooltip = value.replace("'","&apos;");
								//tooltip = tooltip + "<br/><img src=\"http://www.devguru.com/images/ads/countersoft_leaderboard.gif\"/>";
								return "<span qtip='" + tooltip + "'>"+ value + "</span>";
							}
						}
				    };
					cc.setRenderer(defaultToolTipRenderer);
				}
			}
			
			if ( spec.getStyle() != null )
				cc.setStyle(spec.getStyle());
			if ( initColumnEditor(cc,spec) ) 
				editableGrid = true;
			columns.add(cc);
		}

	}
	
	private void associateJSCallback(CellEditor editor, final String editorChangeJsCallback) {
		if ( editorChangeJsCallback == null || editorChangeJsCallback.length() == 0 )
			return;
		 editor.addListener(Events.Complete, new Listener<EditorEvent>() {
			  public void handleEvent(EditorEvent be) {
				new InvokeJsArgs(null,editorChangeJsCallback,true).invoke(be.value);
			  }
		 });
	}

	/**
	 * set editor type associated with column 
	 */
	private boolean initColumnEditor(ColumnConfig cc, GridColumnSpec spec) {
		String type = spec.getType();
		String editorChangeJsCallback = spec.getEditChangeJsCallback();
		Field<? extends Object> dataFld = null;
		HorizontalAlignment alignment = null;
		if ("date".equalsIgnoreCase(type)) {
			DateField fld = new DateField();
			fld.getPropertyEditor().setFormat(DATE_FORMAT);
			cc.setDateTimeFormat(DATE_FORMAT);
			alignment = HorizontalAlignment.LEFT;
			dataFld = fld;
		}
		if ("datetime".equalsIgnoreCase(type)) {
			DateField fld = new DateField();
			fld.getPropertyEditor().setFormat(DATETIME_FORMAT);
			cc.setDateTimeFormat(DATETIME_FORMAT);
			alignment = HorizontalAlignment.LEFT;
			dataFld = fld;
		}
		if ("string".equalsIgnoreCase(type)) {
			TextField<String> fld = new TextField<String>();
			alignment = HorizontalAlignment.LEFT;
			dataFld = fld;
		}
		if ("numeric".equalsIgnoreCase(type)) {
			NumberField fld = new NumberField();
			alignment = HorizontalAlignment.RIGHT;
			dataFld = fld;
		}
		if ("currency".equalsIgnoreCase(type)) {
			NumberField fld = new NumberField();
			cc.setNumberFormat(NumberFormat.getFormat("#,###,###.00"));
			alignment = HorizontalAlignment.RIGHT;
			dataFld = fld;
		}
		if ("percent".equalsIgnoreCase(type)) {
			NumberField fld = new NumberField();
			cc.setNumberFormat(NumberFormat.getPercentFormat());
			alignment = HorizontalAlignment.RIGHT;
			dataFld = fld;
		}
		if ("decimal".equalsIgnoreCase(type)) {
			NumberField fld = new NumberField();
			cc.setNumberFormat(NumberFormat.getDecimalFormat());
			alignment = HorizontalAlignment.RIGHT;
			dataFld = fld;
		}
		if ("boolean".equalsIgnoreCase(type)) {
			CheckBox fld = new CheckBox();
			alignment = HorizontalAlignment.LEFT;
			dataFld = fld;
		}
		if ( alignment != null ) {
			cc.setAlignment(alignment);
		}
		if (dataFld != null) {
			if (spec.isEditable()) {
				CellEditor editor = new CellEditor(dataFld);
				// editor.setAlignment(cc.getAlignment().name());
				editor.setCompleteOnEnter(true);
				associateJSCallback(editor, editorChangeJsCallback);
				cc.setEditor(editor);
				return true;
			}
		}
		return false;
	}
	
	protected ColumnModel getColumnModel() {
		loadColumnConfig();
	    ColumnModel cm = new ColumnModel(columns);
	    return cm;
	}
	protected abstract void initGrid();

	// called after grid is initialized
	protected void fireGridInitializedEvent() {
		gridInitialized = true;
		// for gc. Once grid is initialized, there is no need to keep raw data
		columns = null;
		//columnSpecs = null;

		if ( gridHeight == 0 )
			setAutoHeight(true);
		else
			setHeight(gridHeight);

		//setAutoWidth(true);
		if ( gridWidth == 0 )
			setAutoWidth(true);
		else
			setWidth(gridWidth+scrollbarWidth);
		//setHeight(gridHeight);
		//setWidth(gridWidth+scrollbarWidth);
	}

	/** loads column configuration */
    protected GridColumnSpec loadColumnConfigElement(List<GridColumnSpec> columnSpecs,Element elem) {
    	if ( !elem.getNodeName().equalsIgnoreCase("column") )
    		return null;
    	GridColumnSpec spec = new GridColumnSpec();
    	spec.setField(GwtXMLHelper.getAttribute(elem, "field"));
    	spec.setDisplay(GwtXMLHelper.getAttribute(elem, "display",spec.getField()));
    	spec.setType(GwtXMLHelper.getAttribute(elem, "type","String"));
    	spec.setHidden(GwtXMLHelper.getBooleanAttribute(elem, "hidden",spec.isHidden()));
    	spec.setSortable(GwtXMLHelper.getBooleanAttribute(elem, "sortable",spec.isSortable()));
    	spec.setFixed(GwtXMLHelper.getBooleanAttribute(elem, "fixed",spec.isFixed()));
    	spec.setGroupable(GwtXMLHelper.getBooleanAttribute(elem, "groupable",spec.isGroupable()));
    	spec.setAbsoluteWidth(GwtXMLHelper.getIntAttribute(elem, "absolute-width",spec.getAbsoluteWidth()));
    	spec.setRelativeWidth(GwtXMLHelper.getIntAttribute(elem, "relative-width",spec.getRelativeWidth()));
    	spec.setAutoExpand(GwtXMLHelper.getBooleanAttribute(elem, "auto-expand",spec.isAutoExpand()));
    	spec.setMenuDisabled(GwtXMLHelper.getBooleanAttribute(elem, "grid-menu-disabled",spec.isMenuDisabled()));
    	spec.setShowToolTip(GwtXMLHelper.getBooleanAttribute(elem, "tooltip",spec.isShowToolTip()));
    	spec.setRowClickEnabled(GwtXMLHelper.getBooleanAttribute(elem, "row-click",spec.isRowClickEnabled()));
    	spec.setToolTipTemplate(GwtXMLHelper.getAttribute(elem, "tooltip-template"));
    	spec.setToolTipTemplateRefId(GwtXMLHelper.getAttribute(elem, "tooltip-template-refid"));
    	spec.setStyle(GwtXMLHelper.getAttribute(elem, "style",null));
    	spec.setEditable(GwtXMLHelper.getBooleanAttribute(elem, "editable",spec.isEditable()));
    	spec.setEditChangeJsCallback(GwtXMLHelper.getAttribute(elem, "edit-callback",null));
    	columnSpecs.add(spec);
    	return spec;
    }

	@SuppressWarnings("unchecked")
	protected ListStore<ModelData> getClientGridStore(Element xmlData) {
		ListStore<ModelData> store = null;
		List<GridColumnSpec> columnSpecs = new ArrayList<GridColumnSpec>();
		//System.out.println("xmldata = "+xmlData.getNodeName());
		NodeList<com.google.gwt.dom.client.Element> docElemList = xmlData.getElementsByTagName("griddata");
		if ( docElemList.getLength() < 1 )
			return null;
		
		com.google.gwt.dom.client.Element docElem = docElemList.getItem(0);
		//System.out.println("docElem = "+docElem.getNodeName());
//		com.google.gwt.xml.client.Document doc = XMLParser.parse(xmlData);
//		com.google.gwt.xml.client.Element docElem = doc.getDocumentElement();
		NodeList<Node> docNL = docElem.getChildNodes();
		int count = docNL.getLength();
		Map<String,GridColumnSpec> colMap = new HashMap<String,GridColumnSpec>();
		
		for ( int ri = 0 ; ri < count ; ri++ ) {
			Node node = docNL.getItem(ri);
			if ( !( node instanceof Element ) )
				continue;
			Element elem = (Element)node;
			String nodeName = elem.getNodeName().toLowerCase();
			if ( nodeName.equals("column") ) {
				GridColumnSpec spec = loadColumnConfigElement(columnSpecs,elem);
				if ( spec != null ) {
					colMap.put(spec.getField(), spec);
					if ( spec.isGroupable() ) {
						groupedColSpec = spec;
						if ( store == null ) {
							store = new GroupingStore<ModelData>();
						}
						if ( store instanceof GroupingStore ) {
							((GroupingStore)store).groupBy(spec.getField());
						}
					}
				}
			} else if ( nodeName.equals("row") ) {
				// rows come after columns
	    		if ( store == null ) {
	    			store = new ListStore<ModelData>();
	    		}
	    		loadClientRow(store,colMap,elem);
			} else if ( nodeName.equals("tooltip") ) {
				toolTipElem = elem;
			}
		}
    	this.columnSpecs = columnSpecs;

	    // make first column auto expand if there is no auto expand set
    	boolean autoExpandIdentified = false;
    	GridColumnSpec defaultAutoExpandSpec = null;
	    for ( GridColumnSpec spec : columnSpecs ) {
	    	if ( spec.isAutoExpand() ) {
	    		autoExpandIdentified = true;
	    		break;
	    	}
	    	if ( defaultAutoExpandSpec == null && !spec.isFixed() && spec.getDisplay().trim().length() > 0 ) {
	    		defaultAutoExpandSpec = spec;
	    	}
	    }
	    if ( !autoExpandIdentified && defaultAutoExpandSpec != null ) {
	    	defaultAutoExpandSpec.setAutoExpand(true);
	    }

	    groupedGrid = (store instanceof GroupingStore);
    	//store.addStoreListener(listener)
		return store;
    }

	//    private static boolean firstTime = true;
    /** loads single row */
    private void loadClientRow(ListStore<ModelData> store, Map<String,GridColumnSpec> colMap, Element elem) {
    	if ( !elem.getNodeName().equalsIgnoreCase("row") )
    		return;
		Map<String,Object> prop = new HashMap<String,Object>();
		NodeList<Node> cellNL = elem.getChildNodes();
		int cellLen = cellNL.getLength();
		//System.out.println("Cellcount : "+cellLen+", "+elem.getNodeName());
		for ( int ci = 0 ; ci < cellLen ; ci++ ) {
			Node cellNode = cellNL.getItem(ci);
			String cellNodeName = cellNode.getNodeName();
			if ( !"cell".equalsIgnoreCase(cellNodeName) )
				continue;
			if ( !( cellNode instanceof com.google.gwt.dom.client.Element ) )
				continue;
			com.google.gwt.dom.client.Element cellElem = (com.google.gwt.dom.client.Element)cellNode;
			String name = cellElem.getAttribute("name");
			GridColumnSpec spec = colMap.get(name);
			String origValue = cellElem.getAttribute("value");
			// this is to get around IE issues
			String value = origValue.replace("lt-x-lt", "<");
			value = value.replace("gt-x-gt", ">");
			String dataType = spec.getType();
			if ( dataType.equalsIgnoreCase("date") ) 
			{
				Date dtValue = GwtHelper.parseDate(value);
				prop.put(name, dtValue);
			} 
			else if ( dataType.equalsIgnoreCase("boolean") ) 
			{
				Boolean boolValue = false; 
				try {
					String str = value.trim();
					boolValue = "Y".equalsIgnoreCase(str) || Boolean.parseBoolean(str);
				} catch(Exception ex) {
					//boolValue = false;
				}
				prop.put(name, boolValue);
			} 
			else if ( dataType.equalsIgnoreCase("currency") 
					|| dataType.equalsIgnoreCase("numeric")  
					|| dataType.equalsIgnoreCase("percent") 
					|| dataType.equalsIgnoreCase("decimal") 
					) 
			{
				Double dblValue = 0.0; 
				if ( GwtHelper.isNotEmpty(value)) {
					if ( value.indexOf(',') >= 0 ) {
						StringBuffer buf = new StringBuffer();
						for ( char c : value.toCharArray() ) {
							if ( c != ',' )
								buf.append(c);
						}
						value = buf.toString();
					}
					try {
						dblValue = Double.parseDouble(value.trim());
					} catch(Exception ex) {
						//dblValue = 0.0;
					}
				}
				prop.put(name, dblValue);
			} else { 
				prop.put(name, value);
			}

//			if ( firstTime ) {
//				PageDOMConverter.callAlert("orig-value:"+origValue);
//				PageDOMConverter.callAlert("new-value:"+value);
//				firstTime = false;
//			}
		}
		//System.out.println("r"+ri+": "+prop);
		BaseListLoadConfig modelData = new BaseListLoadConfig();
		modelData.setProperties(prop);
		store.add(modelData);
    }
}
