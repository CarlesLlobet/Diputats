package prop.g12.diputats.mxgraph.shape;

import prop.g12.diputats.mxgraph.canvas.mxGraphics2DCanvas;
import prop.g12.diputats.mxgraph.util.mxPoint;
import prop.g12.diputats.mxgraph.view.mxCellState;

public interface mxIMarker
{
	/**
	 * 
	 */
	mxPoint paintMarker(mxGraphics2DCanvas canvas, mxCellState state, String type,
			mxPoint pe, double nx, double ny, double size, boolean source);

}
