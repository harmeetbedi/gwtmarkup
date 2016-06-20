package emforium.gwt.widget.custom;

import com.google.gwt.user.client.Element;

import emforium.gwt.widget.gwt.AbsolutePanelFactory;


public  class CoverFlowFactory extends AbsolutePanelFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "CoverFlow";
    
    public CoverFlowFactory() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        /*
        register("onClick", new StringAttributeSetter<CoverFlow>() {
            public void set(CoverFlow widget, Element element, String name, String value) {
                widget.setOnClick(value);
            }
        });
        register("onDoubleClick", new StringAttributeSetter<CoverFlow>() {
            public void set(CoverFlow widget, Element element, String name, String value) {
                widget.onDoubleClick(value);
            }
        });
        */
    }

    @Override
    protected CoverFlow newInstance(Element element) {
    	String xmlData = element.getInnerHTML();
		CoverFlow cf = new CoverFlow();
    	cf.setData(xmlData);
		return cf;
    }
}

