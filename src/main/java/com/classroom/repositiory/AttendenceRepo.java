package com.classroom.repositiory;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.classroom.model.Attendence;

public interface AttendenceRepo extends JpaRepository<	Attendence,Integer> 
{
	public Attendence findByRollNoAndDate(int rollNo,Date date);
	public List<Attendence> findByRollNo(int rollNo);
}
