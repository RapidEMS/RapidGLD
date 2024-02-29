
/*-----------------------------------------------------------------------
 * Copyright (C) 2001 Green Light District Team, Utrecht University 
 * Copyright of the TC2 algorithm (C) Marco Wiering, Utrecht University
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

package com.github.RapidEMS.algo.tlc;

import com.github.RapidEMS.*;
import com.github.RapidEMS.sim.*;
import com.github.RapidEMS.algo.tlc.*;
import com.github.RapidEMS.infra.*;
import com.github.RapidEMS.utils.*;
import com.github.RapidEMS.xml.*;

import java.io.IOException;
import java.util.*;
import java.awt.Point;

public class PosMov
{	
	public int tlId, pos;
	
	public PosMov(int _tlId, int _pos) {
		tlId = _tlId;
		pos  = _pos;
	}
}
