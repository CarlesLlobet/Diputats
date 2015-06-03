package prop.g12.diputats.mxgraph.shape;

import java.awt.Rectangle;

import prop.g12.diputats.mxgraph.canvas.mxGraphics2DCanvas;
import prop.g12.diputats.mxgraph.util.mxConstants;
import prop.g12.diputats.mxgraph.util.mxRectangle;
import prop.g12.diputats.mxgraph.util.mxUtils;
import prop.g12.diputats.mxgraph.view.mxCellState;

public class mxSwimlaneShape extends mxBasicShape
{

	/**
	 * 
	 */
	public void paintShape(mxGraphics2DCanvas canvas, mxCellState state)
	{
		int start = (int) Math.round(mxUtils.getInt(state.getStyle(),
				mxConstants.STYLE_STARTSIZE, mxConstants.DEFAULT_STARTSIZE)
				* canvas.getScale());

		Rectangle tmp = state.getRectangle();

		if (mxUtils
				.isTrue(state.getStyle(), mxConstants.STYLE_HORIZONTAL, true))
		{
			if (configureGraphics(canvas, state, true))
			{
				canvas.fillShape(new Rectangle(tmp.x, tmp.y, tmp.width, Math
						.min(tmp.height, start)));
			}

			if (configureGraphics(canvas, state, false))
			{
				canvas.getGraphics().drawRect(tmp.x, tmp.y, tmp.width,
						Math.min(tmp.height, start));
				canvas.getGraphics().drawRect(tmp.x, tmp.y + start, tmp.width,
						tmp.height - start);
			}
		}
		else
		{
			if (configureGraphics(canvas, state, true))
			{
				canvas.fillShape(new Rectangle(tmp.x, tmp.y, Math.min(
						tmp.width, start), tmp.height));
			}

			if (configureGraphics(canvas, state, false))
			{
				canvas.getGraphics().drawRect(tmp.x, tmp.y,
						Math.min(tmp.width, start), tmp.height);
				canvas.getGraphics().drawRect(tmp.x + start, tmp.y,
						tmp.width - start, tmp.height);
			}
		}

	}

	/**
	 * 
	 */
	protected mxRectangle getGradientBounds(mxGraphics2DCanvas canvas,
			mxCellState state)
	{
		int start = (int) Math.round(mxUtils.getInt(state.getStyle(),
				mxConstants.STYLE_STARTSIZE, mxConstants.DEFAULT_STARTSIZE)
				* canvas.getScale());
		mxRectangle result = new mxRectangle(state);

		if (mxUtils
				.isTrue(state.getStyle(), mxConstants.STYLE_HORIZONTAL, true))
		{
			result.setHeight(Math.min(result.getHeight(), start));
		}
		else
		{
			result.setWidth(Math.min(result.getWidth(), start));
		}

		return result;
	}

}
