package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Room;
import com.project.hms.repository.RoomRepository;
import com.project.hms.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	private RoomRepository roomRepository;
	

	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public List<Room> getAllRooms() {
	
		return roomRepository.findAll();
	}
	

	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(Integer id) {
		// TODO Auto-generated method stub
		return roomRepository.findById(id).get();
	}

	@Override
	public Room updateRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public void deleteRoomById(Integer id) {
		// TODO Auto-generated method stub
		roomRepository.deleteById(id);
		
	}

}