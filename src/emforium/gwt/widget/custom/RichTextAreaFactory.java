/**
 * 
 */
package emforium.gwt.widget.custom;

import com.extjs.gxt.ui.client.XDOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import emforium.gwt.util.GwtXMLHelper;
import emforium.gwt.widget.WidgetDOMConverter;
import emforium.gwt.widget.AttributeSetter.IntegerAttributeSetter;
import emforium.gwt.widget.AttributeSetter.StringAttributeSetter;

/**
 * Factory for the NumberField widget.
 *
 */
public class RichTextAreaFactory extends emforium.gwt.widget.gwt.RichTextAreaFactory {
    /** tag used in XML file to lookup factory */
    public static final String XML_TAG = "RichTextArea";

	public RichTextAreaFactory() {
	}
	
    protected void registerAttributes() {
        super.registerAttributes();
        register("remainingNotifId", new StringAttributeSetter<RichTextArea>() {
			public void set(final RichTextArea widget, Element element,String name, String value) {
				widget.setRemainingNotifElementId(value);
			}
        });
        /*
        register("hiddenFieldId", new StringAttributeSetter<RichTextArea>() {
			public void set(final RichTextArea widget, Element element,String name, String value) {
				final String hiddenfieldId = value;
				FocusListener focusListener = new FocusListener() {
					  public void onFocus(Widget sender) {
						  GwtXMLHelper.setAttribute(hiddenfieldId, "value",   widget.getHTML());
					  }
					  public void onLostFocus(Widget sender) {
						  widget.setTextWithMaxLimitCheck();
					  }
				};
				widget.addFocusListener(focusListener);
			}
        });
        */
        register("maxLength", new IntegerAttributeSetter<RichTextArea>() {
			public void set(final RichTextArea widget, Element element,String name, final int value) {
				if ( value <= 0 )
					return;
				
				widget.setMaxLength(value);
				widget.setTextWithMaxLimitCheck();
				KeyboardListener keyListener = new KeyboardListenerAdapter() {
					  public void onKeyUp(Widget sender, char keyCode, int modifiers) {
						  widget.setTextWithMaxLimitCheck();
					  }
				};
				widget.addKeyboardListener(keyListener);
				FocusListener focusListener = new FocusListener() {
					  public void onFocus(Widget sender) {
						  widget.setTextWithMaxLimitCheck();
					  }
					  public void onLostFocus(Widget sender) {
						  widget.setTextWithMaxLimitCheck();
					  }
				};
				widget.addFocusListener(focusListener);
				MouseListener mouseListener = new MouseListenerAdapter() {
					  public void onMouseUp(Widget sender, int x, int y) {
						  widget.setTextWithMaxLimitCheck();
					  }
				};
				widget.addMouseListener(mouseListener);
			}
        });
    }

    protected RichTextArea newInstance(Element element) {
    	String txt = element.getInnerHTML();
    	RichTextArea ta = new RichTextArea();
    	if ( txt != null ) {
    		txt = txt.trim();
    		ta.setHTML(txt);
    	}
    	return ta;
	}

    public RichTextArea create(java.util.List<Object> ancestors,final Element element) {
        final RichTextArea item = (RichTextArea)createInstance(element);
        new WidgetDOMConverter<RichTextArea>(ancestors,item,element) {
            @Override
            protected void addUIObject(UIObject widget) {
            }
        };
        return item;
    }
}

class RichTextArea extends com.google.gwt.user.client.ui.RichTextArea {
	private String remainingNotifElementId;
	private String hiddenFieldId;
	private int maxLength;

	public String getRemainingNotifElementId() {
		return remainingNotifElementId;
	}
	public void setRemainingNotifElementId(String remainingNotifElementId) {
		this.remainingNotifElementId = remainingNotifElementId;
	}

	public void setHiddenFieldId(String hiddenFieldId) {
		this.hiddenFieldId = hiddenFieldId;
	}

	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	void setTextWithMaxLimitCheck() {
		String txt = getHTML(); 
		if ( txt == null )
			return;
		if ( txt.length() > maxLength ) {
			txt = txt.substring(0,maxLength);
			setHTML(txt);
		}
		if ( remainingNotifElementId != null && remainingNotifElementId.length() > 0 ) {
			Element elem = XDOM.getElementById(remainingNotifElementId);
			if ( elem != null ) {
				int remaining = maxLength - txt.length();
				elem.setInnerHTML(remaining+"");
			}
		}
	}
}