package com.classroom.service;

import java.util.Date;
import java.util.List;
import com.classroom.model.Attendence;

public interface AttendenceService {

	public Attendence saveAttendance(Attendence attendance);

	public List<Attendence> getAttendance();

	public Attendence updateAttendence(Attendence attendence);

	public void deleteAttendence(int id);
	
	public Attendence getAttendanceByIdAnddate (int rollNo,Date date);
	
	public List<Attendence> getAttendanceByRollNo(int rollNo);
	

}
