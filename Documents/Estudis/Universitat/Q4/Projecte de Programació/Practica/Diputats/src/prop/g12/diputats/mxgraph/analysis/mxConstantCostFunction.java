/**
 * Copyright (c) 2007, Gaudenz Alder
 */
package prop.g12.diputats.mxgraph.analysis;

import prop.g12.diputats.mxgraph.view.mxCellState;

/**
 * Implements a cost function for a constant cost per traversed cell.
 */
public class mxConstantCostFunction implements mxICostFunction
{

	/**
	 * 
	 */
	protected double cost = 0;

	/**
	 * 
	 * @param cost
	 */
	public mxConstantCostFunction(double cost)
	{
		this.cost = cost;
	}

	/**
	 *
	 */
	public double getCost(mxCellState state)
	{
		return cost;
	}

}
