package com.cs544.roommate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cs544.roommate.domain.Room;
import com.cs544.roommate.service.IRoomService;

@Controller
public class RoomController {
	
	private IRoomService roomService;
	
	@Autowired
	public void setShoppingListService(IRoomService shoppingListService) {
		this.roomService = shoppingListService;
	}

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)	
	public @ResponseBody Collection<Room> list() {
		return roomService.getRoomList();		
	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addItem(@RequestBody Room room) {
		roomService.addRoom(room);
	}

	@RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
	public @ResponseBody Room findRoom(@PathVariable("id") int id) {
		return roomService.getRoom(id);
	}

	@RequestMapping(value = "/room", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateRoom(@RequestBody Room room) {
		roomService.updateRoom(room);
	}

	@RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteItem(@PathVariable("id") Integer id) {
		roomService.removeRoom(id);
	}
	
}
