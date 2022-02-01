package com.project.hms.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Room;
import com.project.hms.service.RoomService;

@Controller
public class RoomController {
	
	private RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	// handler method to handle list room and return mode and view
	@GetMapping("/rooms")
	public String listRooms(Model model) {
		model.addAttribute("room", roomService.getAllRooms());
		return "room";
	}
	
	@GetMapping("/rooms/new")
	public String createRoomForm(Model model) {
		
		// create student object to hold student form data
		Room room = new Room();
		model.addAttribute("room", room);
		return "create_room";
		
	}
	
	@PostMapping("/rooms")
	public String saveRoom(@ModelAttribute("room") Room room) {
		roomService.saveRoom(room);
		return "redirect:/rooms";
	}
	
	@GetMapping("/rooms/edit/{id}")
	public String editRoomForm(@PathVariable Integer id, Model model) {
		model.addAttribute("room", roomService.getRoomById(id));
		return "edit_room";
	}

	@PostMapping("/rooms/{id}")
	public String updateRoom(@PathVariable Integer id,
			@ModelAttribute("room") Room room,
			Model model) {
		
		// get room from database by id
		Room existingRoom = roomService.getRoomById(id);
		existingRoom.setId(id);
		existingRoom.setR_type(room.getR_type());
		existingRoom.setPrice(room.getPrice());
		
		
		// save updated student object
		roomService.updateRoom(existingRoom);
		return "redirect:/rooms";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/rooms/{id}")
	public String deleteRoom(@PathVariable Integer id) {
		roomService.deleteRoomById(id);
		return "redirect:/rooms";
	}
	
}