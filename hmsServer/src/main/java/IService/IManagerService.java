package IService;

import dao.UserStudent;
import dao.UserTeacher;

public interface IManagerService {

	String queryAllTeacher();

	String queryAllStudent();

	String queryAddDept();

	String addTeacher(UserTeacher userTeacher);

	String queryAddClass();

	String addStudent(UserStudent userStudent);

}
