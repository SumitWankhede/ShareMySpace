package com.cs544.roommate.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs544.roommate.domain.Room;


// Not completed!!!

public interface IRoomDao extends JpaRepository<Room, Integer> {

//	@Query("select p from property p where property_id = :id")
//	public Room getRoom(@Param("id") int id);
//	
//	public void updateRoom(Room room);
//	
//	public Collection<Room> getRoomList();
//	
//	public void addRoom(Room room);
//	
//	public void removeRoom(int roomId);
	
}
