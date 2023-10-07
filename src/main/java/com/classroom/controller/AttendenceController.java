package com.classroom.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.classroom.model.Attendence;
import com.classroom.model.User;
import com.classroom.service.AttendenceService;
import com.classroom.service.UserService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendenceController {

	@Autowired
	private AttendenceService attendenceService;
	@Autowired
	private UserService userService;


	@PostMapping("/add/{status}/{id}")
    public ResponseEntity addAttendance(@PathVariable int id, @PathVariable String status) {
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // role is "student" before adding attendance
            if ("student".equalsIgnoreCase(user.getRole())) {
                boolean present = "present".equalsIgnoreCase(status);
                Attendence attend = new Attendence(id, present, new Date());
                attendenceService.saveAttendance(attend);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>("User is not Registered", HttpStatus.UNAUTHORIZED);
    }
	
	@GetMapping("/get")
	public List<Attendence> getAttendance() {
		return attendenceService.getAttendance();
	}

//	@PutMapping("/update/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable int id, @Validated @RequestBody User updatedUser) {
//		updatedUser.setId(id);
//		return new ResponseEntity<>(userService.updateUser(updatedUser), HttpStatus.OK);
//	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		attendenceService.deleteAttendence(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/check/{id}/{date}")
	public ResponseEntity<Attendence> checkAttendance(@PathVariable int id,@PathVariable Date date){
		return new ResponseEntity<Attendence>(attendenceService.getAttendanceByIdAnddate(id, date),HttpStatus.OK);
	}

	@GetMapping("/getbyrollno/{rollNo}")
	public List<Attendence> getAttendenceByRollNo(@PathVariable int rollNo)
	{
	return  attendenceService.getAttendanceByRollNo(rollNo);
	}
}