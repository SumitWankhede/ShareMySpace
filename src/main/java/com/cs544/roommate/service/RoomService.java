package com.cs544.roommate.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs544.roommate.domain.Room;
import com.cs544.roommate.repository.IRoomDao;

@Service
public class RoomService implements IRoomService {
	
	private IRoomDao roomDao;
	
	@Autowired
	public void setRoomDao(IRoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public Collection<Room> getRoomList() {
		return roomDao.findAll();
	}

	@Override
	public void addRoom(Room room) {
		roomDao.saveAndFlush(room);
	}

	@Override
	public Room getRoom(int id) {
		return roomDao.findOne(id);
	}

	@Override
	public void updateRoom(Room room) {
		roomDao.save(room);
	}

	@Override
	public void removeRoom(int id) {
		roomDao.delete(id);
	}

}
