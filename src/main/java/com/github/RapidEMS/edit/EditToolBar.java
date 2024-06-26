
/*-----------------------------------------------------------------------
 * Copyright (C) 2001 Green Light District Team, Utrecht University 
 *
 * This program (Green Light District) is free software.
 * You may redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by
 * the Free Software Foundation (version 2 or later).
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * See the documentation of Green Light District for further information.
 *------------------------------------------------------------------------*/

package com.github.RapidEMS.edit;

import com.github.RapidEMS.GLDToolBar;
import com.github.RapidEMS.tools.*;
import com.github.RapidEMS.utils.IconButton;

import java.awt.event.ActionEvent;

/**
 *
 * The ToolBar for the editor
 *
 * @author Group GUI
 * @version 1.0
 */

public class EditToolBar extends GLDToolBar
{
	protected static final int TOTAL = APPBUTTON;
	protected static final int MOVE = APPBUTTON + 1;
	protected static final int NODE = APPBUTTON + 2;
	protected static final int ROAD = APPBUTTON + 3;
	protected static final int LANE = APPBUTTON + 4;

	public EditToolBar(EditController ec) {
		super(ec, true);
	}
	
	protected void addTools() {
//  	addButton("src/main/java/com/github/RapidEMS/images/total.gif", this, TOTAL);
//		addButton("src/main/java/com/github/RapidEMS/images/move.gif", this, MOVE);
  	addButton("src/main/java/com/github/RapidEMS/images/node.gif", this, NODE);
  	addButton("src/main/java/com/github/RapidEMS/images/road.gif", this, ROAD);
  	addButton("src/main/java/com/github/RapidEMS/images/drivelane.gif", this, LANE);
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		int Id = ((IconButton)e.getSource()).getId();
		switch (Id) {
			case TOTAL : { controller.changeTool(new TotalEditTool((EditController)controller)); break; }
			case MOVE  : { controller.changeTool(new MoveTool((EditController)controller)); break; }
			case NODE  : { controller.changeTool(new NodeTool((EditController)controller)); break; }
			case ROAD  : { controller.changeTool(new RoadTool((EditController)controller)); break; }
			case LANE  : { controller.changeTool(new LaneTool((EditController)controller)); break; }
		}
	}
}