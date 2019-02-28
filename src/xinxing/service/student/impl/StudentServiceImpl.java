package xinxing.service.student.impl;

import xinxing.business.StudentBusiness;
import xinxing.model.Students;
import xinxing.service.student.StudentService;

import java.util.List;

/**
 * 
 */
public class StudentServiceImpl implements StudentService{

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return StudentBusiness.getAllStudents();
	}

}
