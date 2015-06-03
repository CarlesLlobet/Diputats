/**
 * Copyright (c) 2010, Gaudenz Alder, David Benson
 */
package prop.g12.diputats.mxgraph.shape;

import java.util.Map;

import prop.g12.diputats.mxgraph.canvas.mxGraphics2DCanvas;
import prop.g12.diputats.mxgraph.view.mxCellState;

public interface mxITextShape
{
	/**
	 * 
	 */
	void paintShape(mxGraphics2DCanvas canvas, String text, mxCellState state,
			Map<String, Object> style);

}
