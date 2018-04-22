package com.cs544.roommate.service;

import java.util.Collection;

import com.cs544.roommate.domain.Room;

public interface IRoomService {

	public Collection<Room> getRoomList();
	public void addRoom(Room room);
	public Room getRoom(int id);
	public void updateRoom(Room room);
	public void removeRoom(int id);
}
