package in.tanuj.attendence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    //List<Student> students = new ArrayList<>();
    @Override
    public String CreateStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);
        return "Student added successfully";
    }

    @Override
    public List<Student> ReadAllStudents() {
        List<StudentEntity> studentList = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for(StudentEntity studentEntity : studentList) {
            Student student = new Student();
            student.setRollNo(studentEntity.getRollNo());
            student.setName(studentEntity.getName());
            student.setEmail(studentEntity.getEmail());

            students.add(student);
        }
        return students;
    }

    @Override
    public boolean DeleteStudent(int rollNo) {
        for (Student)
    }

    @Override
    public String UpdateStudent(int rollNo, Student updatedStudent) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }
}
