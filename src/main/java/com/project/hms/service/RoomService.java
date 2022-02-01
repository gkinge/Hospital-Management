package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Room;

public interface RoomService {
	List<Room> getAllRooms();
	
	Room saveRoom(Room room);
	
	Room getRoomById(Integer id);
	
	Room updateRoom(Room room);
	
	void deleteRoomById(Integer id);
}
