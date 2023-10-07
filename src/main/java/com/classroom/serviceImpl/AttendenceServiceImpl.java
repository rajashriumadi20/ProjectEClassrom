package com.classroom.serviceImpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classroom.model.Attendence;
import com.classroom.repositiory.AttendenceRepo;
import com.classroom.service.AttendenceService;

@Service
public class AttendenceServiceImpl implements AttendenceService {
	@Autowired
	private AttendenceRepo attend;

	@Override
	public Attendence saveAttendance(Attendence attendance) {
		// TODO Auto-generated method stub
		return attend.save(attendance);
	}

	@Override
	public List<Attendence> getAttendance() {
		// TODO Auto-generated method stub
		return attend.findAll();
	}

	@Override
	public Attendence updateAttendence(Attendence attendence) {
		// TODO Auto-generated method stub
		return attend.save(attendence);
	}

	@Override
	public void deleteAttendence(int id) {
		// TODO Auto-generated method stub
		attend.deleteById(id);
	}

	@Override
	public Attendence getAttendanceByIdAnddate(int rollNo, Date date) {
		// TODO Auto-generated method stub
		return attend.findByRollNoAndDate(rollNo, date);
	}

	@Override
	public List<Attendence> getAttendanceByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return attend.findByRollNo(rollNo);
	}

}
