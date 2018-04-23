package com.cs544.roommate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.roommate.domain.Property;


// Not completed!!!

public interface IPropertyDao extends JpaRepository<Property, Integer> {

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
