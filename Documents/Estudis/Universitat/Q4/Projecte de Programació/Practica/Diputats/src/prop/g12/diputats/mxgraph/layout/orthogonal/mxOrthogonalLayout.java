/**
 * Copyright (c) 2008-2009, JGraph Ltd
 */
package prop.g12.diputats.mxgraph.layout.orthogonal;

import prop.g12.diputats.mxgraph.layout.mxGraphLayout;
import prop.g12.diputats.mxgraph.layout.orthogonal.model.mxOrthogonalModel;
import prop.g12.diputats.mxgraph.view.mxGraph;

/**
 *
 */
/**
*
*/
public class mxOrthogonalLayout extends mxGraphLayout
{

  /**
   * 
   */
  protected mxOrthogonalModel orthModel;

  /**
   * Whether or not to route the edges along grid lines only, if the grid
   * is enabled. Default is false
   */
  protected boolean routeToGrid = false;
  
  /**
   * 
   */
  public mxOrthogonalLayout(mxGraph graph)
  {
     super(graph);
     orthModel = new mxOrthogonalModel(graph);
  }

  /**
   * 
   */
  public void execute(Object parent)
  {
     // Create the rectangulation
     
  }

}
