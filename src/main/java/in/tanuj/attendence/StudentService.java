package in.tanuj.attendence;

import java.util.List;

public interface StudentService {
    String CreateStudent(Student student);
    List<Student> ReadAllStudents();
    Student ReadStudentById(int rollNo);
    boolean DeleteStudent(int rollNo);
    String UpdateStudent(int rollNo, Student updatedStudent);
    
}
