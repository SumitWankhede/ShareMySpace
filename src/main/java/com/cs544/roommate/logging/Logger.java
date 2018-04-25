package com.cs544.roommate.logging;

public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("RoomateLogger").info(logstring);
	}

}
