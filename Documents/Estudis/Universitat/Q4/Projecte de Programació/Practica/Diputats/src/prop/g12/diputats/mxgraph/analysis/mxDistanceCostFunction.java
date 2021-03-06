/**
 * Copyright (c) 2007-2009, JGraph Ltd
 */
package prop.g12.diputats.mxgraph.analysis;

import prop.g12.diputats.mxgraph.util.mxPoint;
import prop.g12.diputats.mxgraph.view.mxCellState;

/**
 * Implements a cost function for the Euclidean length of an edge.
 */
public class mxDistanceCostFunction implements mxICostFunction
{

	/**
	 * Returns the Euclidean length of the edge defined by the absolute
	 * points in the given state or 0 if no points are defined.
	 */
	public double getCost(mxCellState state)
	{
		double cost = 0;
		int pointCount = state.getAbsolutePointCount();

		if (pointCount > 0)
		{
			mxPoint last = state.getAbsolutePoint(0);

			for (int i = 1; i < pointCount; i++)
			{
				mxPoint point = state.getAbsolutePoint(i);
				cost += point.getPoint().distance(last.getPoint());
				last = point;
			}
		}

		return cost;
	}
}
