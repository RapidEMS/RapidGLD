
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

package com.github.RapidEMS;


/**
 *
 * Thrown when the filename chosen is invalid.
 *
 * @author Group GUI
 * @version 1.0
 */

public class InvalidFilenameException extends GLDException
{
	/**
	 * Throw a new InvalidFilename Exception with the following message
	 * @param msg The message to be passed to GLDException
	 		*/
	public InvalidFilenameException(String msg) {
		super(msg);
	}
}