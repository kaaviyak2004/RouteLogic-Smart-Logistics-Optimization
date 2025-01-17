package com.routemasterapi.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.routemasterapi.api.model.UserIdRequest;
import com.routemasterapi.api.model.UserRequestBody;
import com.routemasterapi.api.service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserRequestBody userReqBody) throws Exception {
		return ResponseEntity.ok(userService.createUser(userReqBody));
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserRequestBody userReqBody) throws Exception {
		return ResponseEntity.ok(userService.updateUser(userReqBody));
	}
	
	@RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(userService.listAllUsersFromDB(pageNumber, size));
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestBody UserIdRequest userIdRequest) throws Exception {
		return ResponseEntity.ok(userService.deleteUser(userIdRequest));
	}
	
	@RequestMapping(value = "/usersCount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfUsers() throws Exception {
		return ResponseEntity.ok(userService.countNumberofUsers());
	}
	
}