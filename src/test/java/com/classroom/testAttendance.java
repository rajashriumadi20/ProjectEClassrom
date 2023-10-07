package com.classroom;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.classroom.model.Attendence;
import com.classroom.service.AttendenceService;

@SpringBootTest
class testAttendance {
	@Autowired
	private AttendenceService attendenceService;

	@Test
	void getAttendance() {
		assertNotNull(this.attendenceService.getAttendance());
	}

	@Test
	void getAttendanceByRollNo() {
		assertNotNull(this.attendenceService.getAttendanceByRollNo(7));
	}

	@Test
	@Disabled
	void getAttendanceByIdAnddate() {
		assertNotNull(this.attendenceService.getAttendanceByIdAnddate(8, new Date()));
	}

	@Test
	@Disabled
	void saveAttendance() {
		assertNotNull(this.attendenceService.saveAttendance(new Attendence(5, true, new Date())));
	}

	@Test
	@Disabled
	void updateAttendence() {
		Attendence att = new Attendence(5, false, new Date());
		att.setId(8);
		assertNotNull(this.attendenceService.updateAttendence(att));
	}

//	@Test
//	void deleteAttendence() {
//		assertNotNull(this.attendenceService.deleteAttendence(5));
//	}
	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

}
