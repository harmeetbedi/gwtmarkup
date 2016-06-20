package emforium.gwt.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.XDOM;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.PagingToolBar;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.XMLParser;

import emforium.gwt.util.GwtProfiler;
import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.custom.ListManager;

/**
 * Manages the navigation of dom objects and will wrap any child components into
 * their own RootPanel.
 * 
 */
public class PageDOMConverter {
	public static void scanForWidgets2(String scanSuffix) {
		try {
		addGridContainer();
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
	// hbtodo: stub callback, replace with real callback to js
	public static native void callAlert(String value) /*-{
	  $wnd.alert(value);
	}-*/;

	static ListStore<ModelData> getStore(String data) {
    	ListStore<ModelData> store = new ListStore<ModelData>();
    	com.google.gwt.xml.client.Document doc = XMLParser.parse((String) data);
    	com.google.gwt.xml.client.Element docElem = doc.getDocumentElement();
    	com.google.gwt.xml.client.NodeList docNL = docElem.getChildNodes();
    	int rowCount = docNL.getLength();
    	for ( int ri = 0 ; ri < rowCount ; ri++ ) {
    		com.google.gwt.xml.client.Node rowNode = docNL.item(ri);
			if ( !( rowNode instanceof com.google.gwt.xml.client.Element ) )
				continue;

			com.google.gwt.xml.client.Element rowElem = (com.google.gwt.xml.client.Element)rowNode;
			Map<String,Object> prop = new HashMap<String,Object>();
			com.google.gwt.xml.client.NodeList cellNL = rowElem.getChildNodes();
			int cellLen = cellNL.getLength();
			//System.out.println("Cellcount : "+cellLen);
			for ( int ci = 0 ; ci < cellLen ; ci++ ) {
				com.google.gwt.xml.client.Node cellNode = cellNL.item(ci);
				if ( !( cellNode instanceof com.google.gwt.xml.client.Element ) )
					continue;
				com.google.gwt.xml.client.Element cellElem = (com.google.gwt.xml.client.Element)cellNode;
				String name = cellElem.getAttribute("name");
				String value = cellElem.getAttribute("value");
				prop.put(name, value);
			}
			//System.out.println("r"+ri+": "+prop);
			BasePagingLoadConfig modelData = new BasePagingLoadConfig(0,2);
			modelData.setProperties(prop);
			store.add(modelData);
    	}
    	return store;
    }
	@SuppressWarnings("unchecked")
	private static void addGridContainer() {
		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();  
	    columns.add(new ColumnConfig("sender", "Sender", 100));  
	    columns.add(new ColumnConfig("email", "Email", 165));  
	    columns.add(new ColumnConfig("phone", "Phone", 100));  
	    columns.add(new ColumnConfig("state", "State", 50));  
	    columns.add(new ColumnConfig("zip", "Zip Code", 65));
	    ColumnConfig thumbConfig = new ColumnConfig("image", "Image", 65);
	    GridCellRenderer<ModelData> thumbNailRenderer = new GridCellRenderer<ModelData>() {
			public String render(ModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<ModelData> store) 
			{
				String value = (String) model.get(property);
				String[] parts = value.split("::");
				String img = parts[0];
				String width = parts[1];
				String height = parts[2];
				String alt = parts[3];
				String js = ( parts.length > 4 ) ? parts[4] : null;
				if ( js != null )
					return "<img src=\"" + img + "\" alt=\""+alt+"\" width=\""+width+"\" height=\""+height+"\" onclick=\""+js+"\"></img>";
				else
					return "<img src=\"" + img + "\" alt=\""+alt+"\" width=\""+width+"\" height=\""+height+"\"></img>";
			}
	    };
	    thumbConfig.setRenderer(thumbNailRenderer);
	    columns.add(thumbConfig);

	    // create the column model  
	    ColumnModel cm = new ColumnModel(columns);  
	  
	    // defines the xml structure  
	    ModelType type = new ModelType();  
	    type.root = "records";  
	    type.recordName = "record";
	    type.totalName = "total";
	    type.addField("sender");  
	    type.addField("email");  
	    type.addField("phone");  
	    type.addField("state");  
	    type.addField("zip");  
	    type.addField("image");  
	  
	    // use a http proxy to get the data  
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "data.xml");  
	    HttpProxy<BasePagingLoadConfig,ModelData> proxy = new HttpProxy<BasePagingLoadConfig,ModelData>(builder);  
	  
	    // need a loader, proxy, and reader  
	    XmlReader<BasePagingLoadConfig> reader = new XmlReader<BasePagingLoadConfig>(type) {
		    protected ListLoadResult newLoadResult(BasePagingLoadConfig loadConfig, List<ModelData> models) {
		    	BasePagingLoadResult res = new BasePagingLoadResult(models);
		    	res.setOffset(loadConfig.getOffset());
		    	return res;
		      }
	    };

	    // loader  
	    BasePagingLoader loader = new BasePagingLoader(proxy,reader);  
	    loader.setRemoteSort(true);
	    loader.load(0, 3);
	    
	    ListStore<ModelData> store = new ListStore<ModelData>(loader);

	    //toolBar.addListener(eventType, listener)
	    Grid grid = new Grid<ModelData>(store, cm);  
	  
	    final PagingToolBar toolBar = new PagingToolBar(3);  
	    toolBar.bind(loader); 
	    
	    ContentPanel panel = new ContentPanel();
		panel.setIconStyle("icon-form");
		//panel.setHeaderVisible(true);
		//panel.setHeading(spec.getTitle());
		//panel.setCollapsible(true);
		//panel.setFrame(true);
		//panel.setAnimCollapse(false);
		//panel.setButtonAlign(HorizontalAlignment.CENTER);
		//panel.setIconStyle("icon-table");
		//panel.setHeading("Paging Table");
        panel.setHeaderVisible(false);
        panel.setLayout(new FitLayout());
		panel.add(grid);
		panel.setHeight(400);
		panel.setBottomComponent(toolBar);
		//panel.setSize(maxWidth, 450);
		//panel.setSize(575, 350);
		//panel.setBottomComponent(toolBar);

		//add(panel);

		// add buttons
	    /*
	    Button load = new Button("Load XML");  
	    load.addSelectionListener(new SelectionListener<ComponentEvent>() {  
	      public void componentSelected(ComponentEvent ce) {  
	        loader.load();  
	      }  
	    });  
	    panel.addButton(load);  
		*/
	    
		LayoutContainer container = new LayoutContainer();
		container.setLayout(new FlowLayout(10));
		//container.setSize(600, 400);
		//container.setHeight(150);
		//container.setWidth(600);
		container.add(panel);  
		container.layout();
		RootPanel.get("test").add(container);

	    //container.setLayout(new AccordionLayout());
		// container.setScrollMode(Scroll.NONE);
		//ContentPanel cp2 = new ContentPanel();
		// cp2.setScrollMode(Scroll.AUTO);
		//cp2.setHeading("tab 6");
		//cp2.add(new Html("<h3>heading 6</h3><br/>test message"));
		// cp2.layout();
		//container.add(cp2);
//		container.setHeight(150);
//		container.setWidth(600);
		// RootPanel.get().clear();
	}
	public static void scanForWidgets(String scanSuffix) {
		//callAlert("parser: "+com.google.gwt.xml.client.impl.XMLParserImpl.getInstance().getClass().getName());
		
		//Calendar cal = new Calendar();
		//addTestContainer();
		//addPortalContainer();
		//addCalendar();
		GwtProfiler nodeScanProfiler = new GwtProfiler("nodescan");
		try {
			scanForContainerWidgets(scanSuffix);
		} finally {
			nodeScanProfiler.done();
		}

		GwtProfiler leafScanProfiler = new GwtProfiler("leafscan");
		try {
			scanForLeafWidgets(scanSuffix);
		} finally {
			leafScanProfiler.done();
		}
		
		GwtProfiler eventScanProfiler = new GwtProfiler("eventscan");
		try {
			scanForEventWidgets(scanSuffix);
		} finally {
			leafScanProfiler.done();
		}
		
		GwtProfiler.dump();
		//HTMLDocument html = (HTMLDocument)XDOM.getDocument();
		//System.out.println("entire html : \r\n"+XDOM.getDocument().getClass().getName());
	}

	private static String[] getIds(String listElemId) {
		GwtProfiler prof = new GwtProfiler(listElemId+".ids");
		try {
			String attr = null;
			
			// Support multiple elements with the same name (multiple list triggers)
			Element elem = XDOM.getElementById(listElemId);
			while (elem != null) {
				String newAttr = GwtXMLHelper.getAttribute(elem, "list");
				if (attr == null) {
					attr = newAttr;
				} else {
					attr = attr + "," + newAttr;
				}

				// Remove the current element and find the next one
				elem.getParentNode().removeChild(elem);
				elem = XDOM.getElementById(listElemId);
			}

			// If there are no attributes to process, return an empty list
			if (attr == null) {
				return new String[0];
			}

			// Return a string array of each id to process
			return attr.split(",");
			
		} finally {
			prof.done();
		}
	}
	private static void scanForEventWidgets(String scanSuffix) {
		for ( String id : getIds("gwteventids" + scanSuffix) ) {
			convertLeafWidget(id);
		}
	}
	private static void scanForLeafWidgets(String scanSuffix) {
		for ( String id : getIds("gwtfieldids" + scanSuffix) ) {
			convertLeafWidget(id);
		}
	}
	private static void scanForContainerWidgets(String scanSuffix) {
		for ( String id : getIds("gwtnodeids" + scanSuffix) ) {
			convertContainerWidget(id);
		}
	}
	private static void convertLeafWidget(String id) { 
		Element element = XDOM.getElementById(id);
		if ( element == null )
			return;
		boolean processed = Boolean.valueOf(GwtXMLHelper.getAttribute(element, "processed"));
		if ( processed )
			return;
		GwtObjectFactory<Object> objFactory = GwtObjectFactoryLookup.getFactory(element);
		if ( objFactory == null ) 
			return;

		List<Object> ancestors = new ArrayList<Object>();
		Object widget = objFactory.create(ancestors,element);
		registerMarkupComponent(id,widget);
		element.setAttribute("processed", "true");
		//System.out.println("leafwidget: "+widget.getClass().getName());
		//element.setInnerHTML(widget.getElement().getInnerHTML()))
		if ( widget instanceof Widget ) {
			RootPanel.get(id).add((Widget)widget);
		}
	}
	private static void convertContainerWidget(String id) { 
		GwtProfiler prof = new GwtProfiler("elem-lookup");
		Element element = null;
		try {
			element = XDOM.getElementById(id);
			if ( element == null )
				return;
		} finally {
			prof.done();
		}

		List<Object> ancestors = new ArrayList<Object>();

		prof = new GwtProfiler("check-processed");
		try {
			boolean processed = Boolean.valueOf(GwtXMLHelper.getAttribute(element, "processed"));
			if ( processed )
				return;
		} finally {
			prof.done();
		}
		
		//String widgetType = element.getAttribute("widget-type");
		prof = new GwtProfiler("factory-lookup");
		GwtObjectFactory<Object> objFactory =  null;
		try {
			objFactory = GwtObjectFactoryLookup.getFactory(element);
			if ( objFactory == null ) 
				return;
		} finally {
			prof.done();
		}

		Widget widget = null;
		prof = new GwtProfiler("widget-create");
		try {
			widget = (Widget)objFactory.create(ancestors,element);
			registerMarkupComponent(id,widget);
		} finally {
			prof.done();
		}

		//System.out.println("containerwidget: "+widget.getClass().getName());
		prof = new GwtProfiler("widget-create");
		try {
			element.setAttribute("processed", "true");
		} finally {
			prof.done();
		}

		prof = new GwtProfiler("container-related-special");
		try {
			if ( widget instanceof LayoutContainer ) {
				ListManager.registerListContainer(id,(LayoutContainer)widget);
				((LayoutContainer)widget).layout();
			}
		} finally {
			prof.done();
		}

		//element.setInnerHTML(widget.getElement().getInnerHTML()))
		prof = new GwtProfiler("add widget");
		try {
			RootPanel.get(id).add(widget);
			//new PanelContainer(element,widget);
		} finally {
			prof.done();
		}
	}
	
	private static Map<String,Object> componentRegistry = new HashMap<String,Object>();
	
	/**
	 * all components that are resolved by dom walker should register themselves  using this method. Having this registry allows event hookups
	 * @param id
	 * @param obj
	 */
	static void registerMarkupComponent(String id,Object obj) {
		componentRegistry.put(id,obj);
	}
	
	public static Object getRegisteredComponent(String id) {
		return componentRegistry.get(id);
	}
	
	public static void clearComponentRegistry() {
		componentRegistry.clear();
	}
	
//	private static class PanelContainer extends SimplePanel {
//		PanelContainer(Element elem, Widget widget) {
//			super(elem);
//			add(widget);
//		}
//	}

	// ----- the following is test code. uncomment and test each part. 
	// Commented out to reduce class dependency and therefore generate a smaller library
//
//	private static void addAccordianContainer() {
//		LayoutContainer container = new LayoutContainer();
//		container.setLayout(new AccordionLayout());
//		//container.setScrollMode(Scroll.NONE);
//		ContentPanel cp1 = new ContentPanel();
//		//cp1.setScrollMode(Scroll.AUTO);
//		cp1.setHeading("tab 5");
//		cp1.add(new Html("<h3>heading 5</h3><br/>test message<br/>test message<br/>test message<br/>test message<br/>test message"));
//		//cp1.layout();
//		container.add(cp1);
//		ContentPanel cp2 = new ContentPanel();
//		//cp2.setScrollMode(Scroll.AUTO);
//		cp2.setHeading("tab 6");
//		cp2.add(new Html("<h3>heading 6</h3><br/>test message"));
//		//cp2.layout();
//		container.add(cp2);
//		container.setHeight(150);
//		container.setWidth(600);
//		container.layout();
//		//RootPanel.get().clear();
//		RootPanel.get("test").add(container);
//	}
//	private static void addPortalContainer1() {
//		//LayoutContainer container = new LayoutContainer();
//		Portal container = new Portal(1);
//		//container.setBorders(true);
//		container.setColumnWidth(0, 0.99999999999);
//		//portal.setColumnWidth(0, 0.99999999999);  
//		//resultPnl.add(container);
//		//container.setLayout(new FitLayout());
//		//container.setColumns(1);
//
//		Portlet p1 = new Portlet();
//		p1.setExpanded(true);
//		p1.setCollapsible(true);
//		p1.add(new Html("<h3>heading 6</h3><br/>test message 1"));
//		//p1.layout();
//		container.add(p1,0);
//		Portlet p2 = new Portlet();
//		p2.setExpanded(true);
//		p2.setCollapsible(true);
//		p2.add(new Html("<h3>heading 7</h3><br/>test message"));
//		//p2.layout();
//		container.add(p2,0);
//
//		//container
//		//resultPnl.add(container);
//		RootPanel.get("test").add(container);
//	}
//	private static void addPortalContainer() {
//
//		//LayoutContainer container = new LayoutContainer();
//		PortalContainer container = new PortalContainer();
//		container.setColumnWidths(".5,.5");
//
//		Portlet p1 = new Portlet();
//		p1.setExpanded(true);
//		p1.setCollapsible(true);
//		p1.add(new Html("<h3>heading 1</h3><br/>test message 1"));
//		container.addPortlet(p1);
//		Portlet p2 = new Portlet();
//		p2.setExpanded(true);
//		p2.setCollapsible(true);
//		p2.add(new Html("<h3>heading 2</h3><br/>test message 1"));
//		container.addPortlet(p2);
//
//		//container.layout();
//		//resultPnl.add(container);
//		RootPanel.get("test").add(container);
//	}
}
