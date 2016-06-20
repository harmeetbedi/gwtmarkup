package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.XMLParser;

import emforium.gwt.util.GwtHelper;
import emforium.gwt.widget.PageDOMConverter;
import emforium.gwt.widget.gwt.DecoratedTabPanelFactory;


public  class TabPanelFactory extends DecoratedTabPanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "TabPanel";
    
    public TabPanelFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
    }

    @Override
    public DecoratedTabPanel create(java.util.List<Object> ancestors,final Element element) {
        final DecoratedTabPanel pnl = (DecoratedTabPanel)createInstance(element);
        pnl.getDeckPanel().setAnimationEnabled(true);
    	String xmlData = element.getInnerHTML();
		com.google.gwt.xml.client.Document doc = XMLParser.parse(xmlData);
		com.google.gwt.xml.client.Element docElem = doc.getDocumentElement();
		com.google.gwt.xml.client.NodeList docNL = docElem.getChildNodes();
		int count = docNL.getLength();
		int tabIdx = 0;
		for ( int ri = 0 ; ri < count ; ri++ ) {
			com.google.gwt.xml.client.Node node = docNL.item(ri);
			if ( !( node instanceof com.google.gwt.xml.client.Element ) )
				continue;
			if ( !node.getNodeName().equals("tab") )
				continue;
			com.google.gwt.xml.client.Element elem = (com.google.gwt.xml.client.Element)node;
			String title = elem.getAttribute("title");
			if ( elem.hasAttribute("tab-widget-ref")) {
				String tabWidgetId = elem.getAttribute("tab-widget-ref");
				if ( GwtHelper.isEmpty(title) ) {
					System.out.println("Title not specified for tab. Ignoring. title="+title+", tabWidgetId="+tabWidgetId+", idx="+tabIdx);
					continue;
				}
				if ( GwtHelper.isEmpty(tabWidgetId) ) {
					System.out.println("Widget not specified for tab. Ignoring. title="+title+", tabWidgetId="+tabWidgetId+", idx="+tabIdx);
					continue;
				}
				Object obj = PageDOMConverter.getRegisteredComponent(tabWidgetId);
				if ( obj == null ) {
					System.out.println("Widget not resolvable for tab. Ignoring. title="+title+", tabWidgetId="+tabWidgetId+", idx="+tabIdx);
					continue;
				}
				if ( !( obj instanceof Widget ) ) {
					System.out.println("Resolved widget is not a UI element. Ignoring. title="+title+", tabWidgetId="+tabWidgetId+", idx="+tabIdx);
					continue;
				}
				pnl.add((Widget)obj,title);
			} else if ( elem.hasChildNodes() ) {
				String html = elem.getFirstChild().getNodeValue();
				pnl.add(new HTML(html),title);
			}
			tabIdx++;
		}
		if ( tabIdx > 0 )
			pnl.selectTab(0);
		element.setInnerHTML("");
    	return pnl;

    }
}
