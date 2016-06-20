package emforium.gwt.widget.custom;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A sample toolbar for use with {@link RichTextArea}. It provides a simple UI
 * for all rich text formatting, dynamically displayed only for the available
 * functionality.
 */
public class RichTextToolbar extends Composite {

	/**
	 * This {@link ImageBundle} is used for all the button icons. Using an image
	 * bundle allows all of these images to be packed into a single image, which
	 * saves a lot of HTTP requests, drastically improving startup time.
	 */
	public interface Images extends ImageBundle {

		@Resource("emforium/gwt/public/images/toolbar/boldUp.gif")
		AbstractImagePrototype boldUp();

		@Resource("emforium/gwt/public/images/toolbar/boldDown.gif")
		AbstractImagePrototype boldDown();

		@Resource("emforium/gwt/public/images/toolbar/createLink.gif")
		AbstractImagePrototype createLink();

		@Resource("emforium/gwt/public/images/toolbar/hr.gif")
		AbstractImagePrototype hr();

		@Resource("emforium/gwt/public/images/toolbar/indentUp.gif")
		AbstractImagePrototype indentUp();

		@Resource("emforium/gwt/public/images/toolbar/indentDown.gif")
		AbstractImagePrototype indentDown();

		@Resource("emforium/gwt/public/images/toolbar/insertImage.gif")
		AbstractImagePrototype insertImage();

		@Resource("emforium/gwt/public/images/toolbar/italicUp.gif")
		AbstractImagePrototype italicUp();

		@Resource("emforium/gwt/public/images/toolbar/italicDown.gif")
		AbstractImagePrototype italicDown();

		@Resource("emforium/gwt/public/images/toolbar/justifyCenterUp.gif")
		AbstractImagePrototype justifyCenterUp();

		@Resource("emforium/gwt/public/images/toolbar/justifyCenterDown.gif")
		AbstractImagePrototype justifyCenterDown();

		@Resource("emforium/gwt/public/images/toolbar/justifyLeftUp.gif")
		AbstractImagePrototype justifyLeftUp();

		@Resource("emforium/gwt/public/images/toolbar/justifyLeftDown.gif")
		AbstractImagePrototype justifyLeftDown();

		@Resource("emforium/gwt/public/images/toolbar/justifyRightUp.gif")
		AbstractImagePrototype justifyRightUp();

		@Resource("emforium/gwt/public/images/toolbar/justifyRightDown.gif")
		AbstractImagePrototype justifyRightDown();

		@Resource("emforium/gwt/public/images/toolbar/olUp.gif")
		AbstractImagePrototype olUp();

		@Resource("emforium/gwt/public/images/toolbar/olDown.gif")
		AbstractImagePrototype olDown();

		@Resource("emforium/gwt/public/images/toolbar/outdentUp.gif")
		AbstractImagePrototype outdentUp();

		@Resource("emforium/gwt/public/images/toolbar/outdentDown.gif")
		AbstractImagePrototype outdentDown();

		@Resource("emforium/gwt/public/images/toolbar/removeFormat.gif")
		AbstractImagePrototype removeFormat();

		@Resource("emforium/gwt/public/images/toolbar/removeLink.gif")
		AbstractImagePrototype removeLink();

		@Resource("emforium/gwt/public/images/toolbar/strikeThroughUp.gif")
		AbstractImagePrototype strikeThroughUp();

		@Resource("emforium/gwt/public/images/toolbar/strikeThroughDown.gif")
		AbstractImagePrototype strikeThroughDown();

		@Resource("emforium/gwt/public/images/toolbar/subscriptUp.gif")
		AbstractImagePrototype subscriptUp();

		@Resource("emforium/gwt/public/images/toolbar/subscriptDown.gif")
		AbstractImagePrototype subscriptDown();

		@Resource("emforium/gwt/public/images/toolbar/superscriptUp.gif")
		AbstractImagePrototype superscriptUp();

		@Resource("emforium/gwt/public/images/toolbar/superscriptDown.gif")
		AbstractImagePrototype superscriptDown();

		@Resource("emforium/gwt/public/images/toolbar/ulUp.gif")
		AbstractImagePrototype ulUp();

		@Resource("emforium/gwt/public/images/toolbar/ulDown.gif")
		AbstractImagePrototype ulDown();

		@Resource("emforium/gwt/public/images/toolbar/underlineUp.gif")
		AbstractImagePrototype underlineUp();

		@Resource("emforium/gwt/public/images/toolbar/underlineDown.gif")
		AbstractImagePrototype underlineDown();
	}

	/**
	 * This {@link Constants} interface is used to make the toolbar's strings
	 * internationalizable.
	 */
	public interface Strings extends Constants {

		String black();

		String blue();

		String bold();

		String color();

		String createLink();

		String font();

		String green();

		String hr();

		String indent();

		String insertImage();

		String italic();

		String justifyCenter();

		String justifyLeft();

		String justifyRight();

		String large();

		String medium();

		String normal();

		String ol();

		String outdent();

		String red();

		String removeFormat();

		String removeLink();

		String size();

		String small();

		String strikeThrough();

		String subscript();

		String superscript();

		String ul();

		String underline();

		String white();

		String xlarge();

		String xsmall();

		String xxlarge();

		String xxsmall();

		String yellow();
	}

	/**
	 * We use an inner EventListener class to avoid exposing event methods on
	 * the RichTextToolbar itself.
	 */
	private class EventListener implements ClickListener, ChangeListener,
			KeyboardListener {

		public void onChange(Widget sender) {
			if (sender == backColors) {
				basic.setBackColor(backColors.getValue(backColors
						.getSelectedIndex()));
				// backColors.setSelectedIndex(0);
			} else if (sender == foreColors) {
				basic.setForeColor(foreColors.getValue(foreColors
						.getSelectedIndex()));
				// foreColors.setSelectedIndex(0);
			} else if (sender == fonts) {
				basic.setFontName(fonts.getValue(fonts.getSelectedIndex()));
				// fonts.setSelectedIndex(0);
			} else if (sender == fontSizes) {
				basic.setFontSize(fontSizesConstants[fontSizes
						.getSelectedIndex() - 1]);
				// fontSizes.setSelectedIndex(0);
			}
		}

		public void onClick(Widget sender) {
			if (sender == bold) {
				basic.toggleBold();
			} else if (sender == italic) {
				basic.toggleItalic();
			} else if (sender == underline) {
				basic.toggleUnderline();
			} else if (sender == subscript) {
				basic.toggleSubscript();
			} else if (sender == superscript) {
				basic.toggleSuperscript();
			} else if (sender == strikethrough) {
				extended.toggleStrikethrough();
			} else if (sender == indent) {
				extended.rightIndent();
			} else if (sender == outdent) {
				extended.leftIndent();
			} else if (sender == justifyLeft) {
				basic.setJustification(RichTextArea.Justification.LEFT);
			} else if (sender == justifyCenter) {
				basic.setJustification(RichTextArea.Justification.CENTER);
			} else if (sender == justifyRight) {
				basic.setJustification(RichTextArea.Justification.RIGHT);
			} else if (sender == insertImage) {
				String url = Window.prompt("Enter an image URL:", "http://");
				if (url != null) {
					extended.insertImage(url);
				}
			} else if (sender == createLink) {
				String url = Window.prompt("Enter a link URL:", "http://");
				if (url != null) {
					extended.createLink(url);
				}
			} else if (sender == removeLink) {
				extended.removeLink();
			} else if (sender == hr) {
				extended.insertHorizontalRule();
			} else if (sender == ol) {
				extended.insertOrderedList();
			} else if (sender == ul) {
				extended.insertUnorderedList();
			} else if (sender == removeFormat) {
				extended.removeFormat();
			} else if (sender == richText) {
				// We use the RichTextArea's onKeyUp event to update the toolbar
				// status.
				// This will catch any cases where the user moves the cursur
				// using the
				// keyboard, or uses one of the browser's built-in keyboard
				// shortcuts.
				updateStatus();
			}
		}

		public void onKeyDown(Widget sender, char keyCode, int modifiers) {
		}

		public void onKeyPress(Widget sender, char keyCode, int modifiers) {
		}

		public void onKeyUp(Widget sender, char keyCode, int modifiers) {
			if (sender == richText) {
				// We use the RichTextArea's onKeyUp event to update the toolbar
				// status.
				// This will catch any cases where the user moves the cursur
				// using the
				// keyboard, or uses one of the browser's built-in keyboard
				// shortcuts.
				updateStatus();
			}
		}
	}

	private static final RichTextArea.FontSize[] fontSizesConstants = new RichTextArea.FontSize[] {
			RichTextArea.FontSize.XX_SMALL, RichTextArea.FontSize.X_SMALL,
			RichTextArea.FontSize.SMALL, RichTextArea.FontSize.MEDIUM,
			RichTextArea.FontSize.LARGE, RichTextArea.FontSize.X_LARGE,
			RichTextArea.FontSize.XX_LARGE };

	private Images images = (Images) GWT.create(Images.class);
	private Strings strings = (Strings) GWT.create(Strings.class);
	private EventListener listener = new EventListener();

	private RichTextArea richText;
	private RichTextArea.BasicFormatter basic;
	private RichTextArea.ExtendedFormatter extended;

	private VerticalPanel outer = new VerticalPanel();
	private HorizontalPanel topPanel = new HorizontalPanel();
	private HorizontalPanel bottomPanel = new HorizontalPanel();
	private ToggleButton bold;
	private ToggleButton italic;
	private ToggleButton underline;
	private ToggleButton subscript;
	private ToggleButton superscript;
	private ToggleButton strikethrough;
	private PushButton indent;
	private PushButton outdent;
	private PushButton justifyLeft;
	private PushButton justifyCenter;
	private PushButton justifyRight;
	private PushButton hr;
	private PushButton ol;
	private PushButton ul;
	private PushButton insertImage;
	private PushButton createLink;
	private PushButton removeLink;
	private PushButton removeFormat;

	private ListBox backColors;
	private ListBox foreColors;
	private ListBox fonts;
	private ListBox fontSizes;

	/**
	 * Creates a new toolbar that drives the given rich text area.
	 * 
	 * @param richText
	 *            the rich text area to be controlled
	 */
	public RichTextToolbar(RichTextArea richText) {
		this.richText = richText;
		this.basic = richText.getBasicFormatter();
		this.extended = richText.getExtendedFormatter();

		outer.add(topPanel);
		outer.add(bottomPanel);
		topPanel.setWidth("100%");
		bottomPanel.setWidth("100%");

		initWidget(outer);
		setStyleName("gwt-RichTextToolbar");
		richText.addStyleName("hasRichTextToolbar");

		if (basic != null) {
			topPanel.add(bold = createToggleButton(images.boldUp(), images.boldDown(), strings.bold()));
			topPanel.add(italic = createToggleButton(images.italicUp(), images.italicDown(), strings.italic()));
			topPanel.add(underline = createToggleButton(images.underlineUp(), images.underlineDown(), strings.underline()));
			topPanel.add(subscript = createToggleButton(images.subscriptUp(), images.subscriptDown(), strings.subscript()));
			topPanel.add(superscript = createToggleButton(images.superscriptUp(), images.superscriptDown(), strings.superscript()));
			topPanel.add(justifyLeft = createPushButton(images.justifyLeftUp(), images.justifyLeftDown(), strings.justifyLeft()));
			topPanel.add(justifyCenter = createPushButton(images.justifyCenterUp(), images.justifyCenterDown(), strings.justifyCenter()));
			topPanel.add(justifyRight = createPushButton(images.justifyRightUp(), images.justifyRightDown(), strings.justifyRight()));
		}

		if (extended != null) {
			topPanel.add(strikethrough = createToggleButton(images.strikeThroughUp(), images.strikeThroughDown(), strings.strikeThrough()));
			topPanel.add(indent = createPushButton(images.indentUp(), images.indentDown(), strings.indent()));
			topPanel.add(outdent = createPushButton(images.outdentUp(), images.outdentDown(), strings.outdent()));
			topPanel.add(hr = createPushButton(images.hr(), strings.hr()));
			topPanel.add(ol = createPushButton(images.olUp(), images.olDown(),strings.ol()));
			topPanel.add(ul = createPushButton(images.ulUp(), images.ulDown(),strings.ul()));
			topPanel.add(insertImage = createPushButton(images.insertImage(), strings.insertImage()));
			topPanel.add(createLink = createPushButton(images.createLink(), strings.createLink()));
			topPanel.add(removeLink = createPushButton(images.removeLink(), strings.removeLink()));
			topPanel.add(removeFormat = createPushButton(images.removeFormat(), strings.removeFormat()));
		}

		if (basic != null) {
			bottomPanel.add(backColors = createColorList("Background"));
			bottomPanel.add(foreColors = createColorList("Foreground"));
			bottomPanel.add(fonts = createFontList());
			bottomPanel.add(fontSizes = createFontSizes());

			// We only use these listeners for updating status, so don't hook
			// them up
			// unless at least basic editing is supported.
			richText.addKeyboardListener(listener);
			richText.addClickListener(listener);
		}
	}

	private ListBox createColorList(String caption) {
		ListBox lb = new ListBox();
		lb.addChangeListener(listener);
		lb.setVisibleItemCount(1);

		lb.addItem(caption);
		lb.addItem(strings.white(), "white");
		lb.addItem(strings.black(), "black");
		lb.addItem(strings.red(), "red");
		lb.addItem(strings.green(), "green");
		lb.addItem(strings.yellow(), "yellow");
		lb.addItem(strings.blue(), "blue");
		return lb;
	}

	private ListBox createFontList() {
		ListBox lb = new ListBox();
		lb.addChangeListener(listener);
		lb.setVisibleItemCount(1);

		lb.addItem(strings.font(), "");
		lb.addItem(strings.normal(), "");
		lb.addItem("Times New Roman", "Times New Roman");
		lb.addItem("Arial", "Arial");
		lb.addItem("Courier New", "Courier New");
		lb.addItem("Georgia", "Georgia");
		lb.addItem("Trebuchet", "Trebuchet");
		lb.addItem("Verdana", "Verdana");
		return lb;
	}

	private ListBox createFontSizes() {
		ListBox lb = new ListBox();
		lb.addChangeListener(listener);
		lb.setVisibleItemCount(1);

		lb.addItem(strings.size());
		lb.addItem(strings.xxsmall());
		lb.addItem(strings.xsmall());
		lb.addItem(strings.small());
		lb.addItem(strings.medium());
		lb.addItem(strings.large());
		lb.addItem(strings.xlarge());
		lb.addItem(strings.xxlarge());
		return lb;
	}

	private PushButton createPushButton(AbstractImagePrototype img, String tip) {
		return createPushButton(img, null, tip);
	}

	private PushButton createPushButton(AbstractImagePrototype upImg,
										AbstractImagePrototype downImg, String tip) 
	{
		PushButton pb = (downImg == null) 
				? new PushButton(upImg.createImage())
				: new PushButton(upImg.createImage(), downImg.createImage());
		pb.addClickListener(listener);
		pb.setTitle(tip);
		return pb;
	}

	private ToggleButton createToggleButton(AbstractImagePrototype upImg,
											AbstractImagePrototype downImg, String tip) 
	{
		ToggleButton tb = (downImg == null) 
		? new ToggleButton(upImg.createImage()) 
		: new ToggleButton(upImg.createImage(), downImg.createImage());
		tb.addClickListener(listener);
		tb.setTitle(tip);
		return tb;
	}

	/**
	 * Updates the status of all the stateful buttons.
	 */
	private void updateStatus() {
		if (basic != null) {
			bold.setDown(basic.isBold());
			italic.setDown(basic.isItalic());
			underline.setDown(basic.isUnderlined());
			subscript.setDown(basic.isSubscript());
			superscript.setDown(basic.isSuperscript());
		}

		if (extended != null) {
			strikethrough.setDown(extended.isStrikethrough());
		}
	}
}
