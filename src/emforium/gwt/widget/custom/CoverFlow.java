package emforium.gwt.widget.custom;

import java.util.ArrayList;
import java.util.List;

import org.gwtwidgets.client.wrap.Callback;
import org.gwtwidgets.client.wrap.Effect;
import org.gwtwidgets.client.wrap.EffectOption;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ChangeListenerCollection;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LoadListener;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.XMLParser;

import emforium.gwt.util.GwtXMLHelper;

class CoverFlowImageSpec {
	private String url;
	private String name;
	private int width;
	private int height;

	CoverFlowImageSpec(com.google.gwt.xml.client.Element elem) {
		url = elem.getAttribute("url");
		name = GwtXMLHelper.getAttribute(elem, "name", url);
		int idx = name.lastIndexOf('/');
		if (idx > 0) {
			name = name.substring(idx + 1);
		}
		width = GwtXMLHelper.getIntAttribute(elem, "width", 100);
		height = GwtXMLHelper.getIntAttribute(elem, "height", 150);
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}

public class CoverFlow extends AbsolutePanel implements WindowResizeListener {
	// Looks best if move & scale durations are the same.
	public static final double MOVE_DURATION = 1.0;
	public static final double SCALE_DURATION = 1.0;
	public static final double LOAD_DURATION = 3.0;
	public static final double SLIDE_DURATION = 0.25;

	public static final double SCALE_RATIO = 0.66d;
	// Calculating so a percent of image width pokes out
	public static final double WIDTH_POKEOUT = 0.4d;

	private static int WIDTH = 0;
	private static int HEIGHT = 1;
	private static int LEFT = 2;
	private static int TOP = 3;

	private int selIdx;
	private Image[] images;
	private List<CoverFlowImageSpec> imageSpecs;
	private int maxWidth = -1;
	private int maxHeight = -1;
	private String onClickCallback;
	private String onDoubleClickCallback;
	private ChangeListenerCollection changeListeners;

	CoverFlow() {
		Window.addWindowResizeListener(this);
	}

	public Image[] getImages() {
		return images;
	}

	public void addChangeListener(ChangeListener listener) {
		if (changeListeners == null) {
			changeListeners = new ChangeListenerCollection();
			sinkEvents(Event.ONCHANGE);
		}
		changeListeners.add(listener);
	}

	protected void onLoad() {
		super.onLoad();
		maxWidth = this.getOffsetWidth();
		maxHeight = this.getOffsetHeight();
		initImages();
		//System.out.println("widht="+maxWidth+", height="+maxHeight);
	}

	public void onWindowResized(int width, int height) {
		this.clear();
		calcPositions(true, false);
	}

	public void setOnClick(String onClickCallback) {
		if (onClickCallback.equalsIgnoreCase("none"))
			onClickCallback = "";
		this.onClickCallback = onClickCallback;
		initImages();
	}

	public void onDoubleClick(String onDoubleClickCallback) {
		if (onClickCallback.equalsIgnoreCase("none"))
			onClickCallback = "";
		this.onDoubleClickCallback = onDoubleClickCallback;
		initImages();
	}

	public void setData(String xmlData) {
		xmlData = xmlData.trim();
		// System.out.println(xmlData);
		com.google.gwt.xml.client.Document doc = XMLParser.parse(xmlData);
		com.google.gwt.xml.client.Element docElem = doc.getDocumentElement();
		com.google.gwt.xml.client.NodeList docNL = docElem.getChildNodes();
		int count = docNL.getLength();
		List<CoverFlowImageSpec> imageSpecList = new ArrayList<CoverFlowImageSpec>();
		for (int ri = 0; ri < count; ri++) {
			com.google.gwt.xml.client.Node node = docNL.item(ri);
			if (!(node instanceof com.google.gwt.xml.client.Element))
				continue;
			com.google.gwt.xml.client.Element elem = (com.google.gwt.xml.client.Element) node;
			imageSpecList.add(new CoverFlowImageSpec(elem));
		}
		this.imageSpecs = imageSpecList;
		initImages();
	}

	private void initImages() {
		if ((maxWidth <= 0) || (maxHeight <= 0) || (imageSpecs == null))
			return;
		setImageSpecs(imageSpecs);
	}

	// public boolean doLayout() {
	// if ( maxWidth <= 0 ) {
	// maxWidth = this.getOffsetWidth();
	// }
	// if ( maxHeight <= 0 ) {
	// maxHeight = this.getOffsetHeight();
	// }
	// initImages();
	// return super.doLayout();
	// }

	/**
	 * Sets ImageDTOs for widget & displays them on screen.
	 */
	public void setImageSpecs(List<CoverFlowImageSpec> imageSpecs) {
		this.clear();
		// this.setWidth("100%");
		// this.setHeight("95%");
		this.imageSpecs = imageSpecs;
		this.images = new Image[imageSpecs.size()];
		this.selIdx = imageSpecs.size() / 2;

		for (int i = 0; i < images.length; i++) {
			images[i] = new Image(imageSpecs.get(i).getUrl());
			final int imageIdx = i;
			images[i].addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					setSelectedIndex(imageIdx);
				}
			});

		}
		calcPositions(true, true);
	}

	/**
	 * Sets the selected image that is displayed in the center.
	 */
	public void setSelectedIndex(final int newIdx) {
		if (images == null || imageSpecs == null) {
			return;
		}

		images[selIdx].removeStyleName("coverflow-selected");
		images[newIdx].addStyleName("coverflow-selected");

		if (newIdx == selIdx) {
			return;
		}

		final int oldIdx = selIdx;
		this.selIdx = newIdx;

		final boolean movingLeft = newIdx > oldIdx;

		final int distance = Math.abs(newIdx - oldIdx);
		Callback callback = new Callback() {
			public void execute() {
				// Removing & re-adding the images in order
				// TODO: Change to use z-order (if you can get it to work)
				for (int i = 1; i <= distance; i++) {
					int idx = movingLeft ? (oldIdx + i) : (oldIdx - i);
					int existLeft = getWidgetLeft(images[idx]);
					int existTop = getWidgetTop(images[idx]);
					remove(images[idx]);
					add(images[idx], existLeft, existTop);
				}

				// Kicking off the move animation
				moveImages(oldIdx);
			}
		};

		// Starting at the center, we'll slide images out & bring them to front.
		// This prevents an abrupt transition where one image jumps in front of
		// another.
		int adjacentLeft = getWidgetLeft(images[oldIdx]);
		int adjacentRight = adjacentLeft + images[oldIdx].getWidth();
		for (int i = 1; i <= distance; i++) {
			int idx = movingLeft ? (oldIdx + i) : (oldIdx - i);
			int width = images[idx].getWidth();

			// Sliding images out if we have to
			int currentLeft = getWidgetLeft(images[idx]);
			int left = movingLeft ? Math.max(currentLeft, adjacentRight) : Math
					.min(currentLeft, (adjacentLeft - width));
			int top = getWidgetTop(images[idx]);

			if (i < distance) {
				animateMove(images[idx], left, top, SLIDE_DURATION);
			} else {
				// If we've reached the last image, trigger a callback to
				// re-order & move images to their new positions
				animateMove(images[idx], left, top, SLIDE_DURATION, callback);
			}
			adjacentLeft = left;
			adjacentRight = left + width;
		}

		if (changeListeners != null) {
			changeListeners.fireChange(this);
		}
	}

	public int getSelectedIndex() {
		return selIdx;
	}

	/**
	 * Animates the movement of images
	 */
	private void moveImages(int oldIdx) {
		final int[][] targetWHLT = calcPositions(false, false);
		final boolean[] grow = new boolean[images.length];

		for (int i = 0; i < images.length; i++) {
			animateMove(images[i], targetWHLT[i][LEFT], targetWHLT[i][TOP],
					MOVE_DURATION);
			int oldDistFromCent = Math.abs(i - oldIdx);
			int newDistFromCent = Math.abs(i - selIdx);
			grow[i] = oldDistFromCent > newDistFromCent;
			double percent = getScalePercent(images[i].getWidth(),
					targetWHLT[i][WIDTH]);
			animateScale(images[i].getElement(), percent, images[i].getWidth(),
					images[i].getHeight(), SCALE_DURATION);
		}
	}

	/**
	 * Calculates the position of images on the viewport
	 */
	private int[][] calcPositions(boolean drawImages, boolean animLoad) {
		// Kicking off recursive array filling
		int[][] whlt = new int[images.length][];
		calcImagePosition(selIdx, whlt, drawImages, animLoad);
		// , maxWidth, maxHeight,
		// , getOffsetWidth(), getOffsetHeight(),
		// drawImages, animLoad);
		return whlt;
	}

	/**
	 * Recursive method to calculate the position of images expanding out from
	 * the center.
	 * 
	 * @param imageIdx
	 *            Index of image to calculate position for
	 * @param whlt
	 *            Array to store width, height, left, top for each imageIdx
	 * @param offsetWidth
	 *            Panel's width
	 * @param offsetHeight
	 *            Panel's height
	 * @param addToPanel
	 *            Whether to add images to panel
	 * @param animateAdd
	 *            Whether to animate the image as it is dded
	 */
	private void calcImagePosition(int imageIdx, int[][] whlt,
			boolean addToPanel, boolean animateAdd) {
		if (imageIdx < 0 || imageIdx >= images.length) {
			return; // Stopping recursion once we reach the first or last image
		}
		// Calculating image's width/height based on its distance from center.
		int distFromCenter = Math.abs(selIdx - imageIdx);
		double scaleRatio = SCALE_RATIO * distFromCenter + 1;
		int maxImgWidth = (int) ((maxWidth * .6) / scaleRatio);
		int maxImgHeight = (int) ((maxHeight * .6) / scaleRatio);
		CoverFlowImageSpec imageSpec = imageSpecs.get(imageIdx);
		int[] wh = scaleImage(imageSpec.getWidth(), imageSpec.getHeight(),
				maxImgWidth, maxImgHeight);
		int width = wh[0];
		int height = wh[1];

		// Calculating image's top position so it's always centered on viewport
		int top = (maxHeight / 2) - (height / 2);

		// Calculating image's left position so 45% of its width pokes out
		int left;
		if (imageIdx < selIdx) {
			int xDiff = (int) (width * WIDTH_POKEOUT);
			left = whlt[imageIdx + 1][LEFT] - xDiff;
		} else if (imageIdx > selIdx) {
			int xDiff = (int) (width * (1 - WIDTH_POKEOUT));
			left = whlt[imageIdx - 1][LEFT] + whlt[imageIdx - 1][WIDTH] - xDiff;
		} else { // centering middle image
			left = (maxWidth / 2) - (width / 2);
		}

		whlt[imageIdx] = new int[] { width, height, left, top };

		// Recursive calls to calc positions for images on the left and/or right
		if (imageIdx <= selIdx) {
			calcImagePosition(imageIdx - 1, whlt, addToPanel, animateAdd);
		}
		if (imageIdx >= selIdx) {
			calcImagePosition(imageIdx + 1, whlt, addToPanel, animateAdd);
		}

		// Adding images to the panel. This happens on the initial load and on
		// window resize events. If the user is just clicking between images,
		// they are already on the panel so we don't need to add them.
		if (addToPanel) {
			images[imageIdx].setWidth(width + "px");
			images[imageIdx].setHeight(height + "px");
			// The first time we load, we'll use the Scriptaculous grow effect
			// for any images that are in the viewport.
			if (animateAdd && inViewport(left, images[imageIdx].getWidth())) {
				images[imageIdx].setVisible(false);
				images[imageIdx].addLoadListener(new LoadListener() {
					public void onLoad(Widget sender) {
						Effect.grow(sender,
								new EffectOption[] { new EffectOption(
										"duration", LOAD_DURATION) });
					}

					public void onError(Widget sender) {
						showErrorMessage();
					}
				});
			}
			// Last added are on top, so we add from the outside in.
			this.add(images[imageIdx], left, top);
		}
	}

	/**
	 * Returns whether the image is in the viewport. Useful to avoid animating
	 * an effect that no one will ever see.
	 */
	private boolean inViewport(int widgetLeft, int width) {
		int widgetRight = widgetLeft + width;
		return (widgetLeft < maxWidth) || (widgetRight >= 0);
	}

	/**
	 * Animates a move effect for the given widget w/absolute positioning.
	 */
	private void animateMove(Widget widget, int left, int top, double dur) {
		Effect.move(widget, new EffectOption[] {
				new EffectOption("mode", "absolute"),
				new EffectOption("x", left), new EffectOption("y", top),
				new EffectOption("duration", dur) });
	}

	/**
	 * Animates a move effect for the given widget w/absolute positioning.
	 */
	private void animateMove(Widget widget, int left, int top, double dur,
			Callback callback) {
		Effect.move(widget, new EffectOption[] {
				new EffectOption("mode", "absolute"),
				new EffectOption("x", left), new EffectOption("y", top),
				new EffectOption("duration", dur),
				new EffectOption("afterFinish", callback) });
	}

	/**
	 * Native javascript call to use the Scriptaculous Scale effect.
	 */
	private native void animateScale(Element element, double percent,
			int origWidth, int origHeight, double dur) /*-{
	       var ne = $wnd._nativeExtensions;
	       $wnd._nativeExtensions = false;
	       new $wnd.Effect.Scale(element, percent, {duration: dur, scaleFromCenter: false, 
	           scaleMode: { originalWidth: origWidth, originalHeight: origHeight}});
	       $wnd._nativeExtensions = ne;
	   }-*/;

	private double getScalePercent(int oldWidth, int newWidth) {
		double scale = (double) newWidth / (double) oldWidth;
		double percent = scale * 100d;
		return percent;
	}

	private void showErrorMessage() {
		System.out.println("Error");
		// TODO: Handle exception
	}

	public static int[] scaleImage(int imageWidth, int imageHeight,
			int maxWidth, int maxHeight) {
		double imageScale = (double) imageHeight / (double) imageWidth;
		double scaledWidth = imageWidth * maxWidth / imageWidth;
		double scaledHeight = scaledWidth * imageScale;

		if (scaledHeight > maxHeight) {
			scaledHeight = imageHeight * maxHeight / imageHeight;
			scaledWidth = scaledHeight / imageScale;
		}

		if (scaledWidth > imageWidth || scaledHeight > imageHeight) {
			scaledWidth = imageWidth;
			scaledHeight = imageHeight;
		}

		return new int[] { (int) scaledWidth, (int) scaledHeight };
	}
}