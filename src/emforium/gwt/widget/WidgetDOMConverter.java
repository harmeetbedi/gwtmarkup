package emforium.gwt.widget;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.custom.ListManager;

/**
 * A helper class that is used to navigate the DOM elements and forceably convert all the items into
 * widget components.  This is required, since if an ancestor is a widget, all descendant nodes must also
 * be widgets or you end up with trouble in the widget wiring.
 *
 */
public abstract class WidgetDOMConverter<W extends Object> {
	/**
	 * Widget xml specification may have gwt-children-type attribute. This can have 4 values : all, none, gwt, and html. 
	 * Default is 'all'
	 * all: element may containe both html and widgets. Need to walk dom to find all the html and widgets
	 * none: no elements expected. all children are ingnored and dom recursive walk stops
	 * gwt: only child elements that represent gwt widgets (UIObjects) are picked up. Html text is ignored
	 * html: it is assumed that the children of element represent html only. no need to discover any new gwt widgets in subelements
	 */
	public static enum ChildrenType {
		ALL, NONE, GWT, HTML;
	}

	// keep previous gwt widget. 
	// Container may need widget with some other associated objects e.g layout data.
	// Keeping previous object objects allows container to be given widget with associated data with single function call.  
	private Object previousGwtObject = null;
	
	// parent widget we are trying to build under
	private W parentWidget;
	private List<Object> ancestors;
	
	private boolean debug = true;
	
	// aggressive html identification. Causes less of dom walk by finding HTML sections earlier
	private static int htmlIdentified = 0;
	private static boolean optimizedHTMLIdentification = false;

	/**
	 * @param parentWidget  container widget
	 * @param parent   xml element of container widget
	 */
	public WidgetDOMConverter(List<Object> ancestors, W parentWidget, Node parent) {
		this.parentWidget = parentWidget;
		this.ancestors = new ArrayList<Object>();
		ancestors = new ArrayList<Object>();
		
		if ( parent instanceof Element ) {
			Element parentElem = (Element)parent;
			boolean processed = Boolean.valueOf(GwtXMLHelper.getAttribute(parentElem, "processed"));
			if ( processed )
				return;
			parentElem.setAttribute("processed", "true");
		}

		// if element contains only html, do not remove subelements and stop proccessing subnodes. Leave it alone
//		if (parent.getNodeType() == Node.ELEMENT_NODE ) {
//			String innerHtml = ((Element)parent).getInnerHTML();
//			if ( !innerHtml.contains(MarkupConstants.GWTCONTAINER_NODENAME) ) {
//				System.out.println("skipping html");
//				return;
//			}
//		}
//		System.out.println("processing gwt + html");


		// process all the nodes at this level in the tree
		NodeList<Node> nl = parent.getChildNodes();
		int len = nl.getLength();
		for (int i = 0 ; i < len ; i++ ) {
			Node child = nl.getItem(i);
//			if ( debug )
//				System.out.println("parent : "+parent.getNodeName()+", child : "+child.getNodeName());

			if ( child == null )
				break;

			int childType = child.getNodeType();
			//parent.removeChild(child);
			switch (childType) {
			case Node.ELEMENT_NODE:
				Element element = (Element) com.google.gwt.dom.client.Element.as(child);
				//if ( GwtXMLHelper.getAttribute(element, "gwt-type").toLowerCase().equals("html") )
				GwtObjectFactory<?> factory = GwtObjectFactoryLookup.getFactory(element);
				if (factory != null) {
					Object obj = factory.create(ancestors,element);
					//System.out.println("adding child : "+obj.getClass().getName());
					String id = GwtXMLHelper.getAttribute(element, "id");
					add(id,obj);
					PageDOMConverter.registerMarkupComponent(id,obj);
				} else {
					addElement(element);
				}
				break;
			case Node.TEXT_NODE:
				addText(child.getNodeValue());
				break;
			}
		}
		GwtXMLHelper.removeChildren(parent);
	}

	private void add(String id, Object obj) { 
		if ( id != null && id.length() > 0 && (obj instanceof LayoutContainer) ) {
			ListManager.registerListContainer(id,(LayoutContainer)obj);
		}
		
		try {
//			if ( debug )
//				System.out.println("parent:"+parentWidget.getClass().getName()
//						+", obj="+obj.getClass().getName()
//						+", previous:"+((previousGwtObject==null)?"null":previousGwtObject.getClass().getName()));
			if ( parentWidget instanceof LayoutContainer ) {
				LayoutContainer container = (LayoutContainer)parentWidget;
				if ( obj instanceof Layout ) {
					if ( debug )
						System.out.println("setting layout : "+obj.getClass().getName()+", for parent:"+parentWidget.getClass().getName());
					container.setLayout((Layout)obj);
					return;
				} else if ( obj instanceof Widget && previousGwtObject != null && previousGwtObject instanceof LayoutData ) {
					container.add((Widget)obj,(LayoutData)previousGwtObject);
					return;
				}
			}
			if ( obj instanceof UIObject)
				addUIObject((UIObject)obj);
		} finally {
			previousGwtObject = obj;
			// content panel requires explicit call to layout
			if ( obj instanceof LayoutContainer )
				((LayoutContainer)obj).layout();
		}
	}

	/**
	 * How to handle adding a widget.
	 * @param widget
	 */
	protected abstract void addUIObject(UIObject widget);
	
	/**
	 * How to handle adding text
	 * 
	 * @param text
	 */
	private void addText(String text) {
		if ( text != null && text.length() < 100 ) {
			text = text.trim();
		}
		if ( text.length() == 0 )
			return;
		addUIObject(new Html(text));
	}
	
	/**
	 * How to handle adding elements
	 * 
	 * @param element
	 */
	private void addElement(Element element) {
		String html = element.getString();
		if ( !html.contains(MarkupConstants.TYPE_XML_ATTRIBUTE_NAME) ) {
			addText(html);
			return;
		}

		final ElementComponent widget = new ElementComponent(element);

		// now convert the children
		new WidgetDOMConverter<ElementComponent>(ancestors,widget,element) {

			@Override
			protected void addUIObject(UIObject child) {
				widget.add(child);
			}

		};

		// add ourselves to our parent
		addUIObject(widget);
	}
}
