package in.tanuj.attendence.service;

import in.tanuj.attendence.entity.StudentEntity;
import in.tanuj.attendence.model.Student;
import in.tanuj.attendence.repository.StudentServiceRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentServiceRepository studentRepository;

    //List<Student> students = new ArrayList<>();
    @Override

    public String CreateStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return "Student added successfully";
    }

    @Override
    public List<Student> ReadAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<Student> students = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            Student student = new Student();
            BeanUtils.copyProperties(studentEntity, student);
            students.add(student);
        }
        return students;
    }

    @Override
    public boolean DeleteStudent(int rollNo) {
        StudentEntity std = studentRepository.findById(rollNo).get();
        studentRepository.delete(std);
        return true;
    }

    @Override
    public String UpdateStudent(int rollNo, Student updatedStudent) {
        for (Student student : ReadAllStudents()){
            if(student.getRollNo()==rollNo){
                StudentEntity studentEntity = new StudentEntity();
                BeanUtils.copyProperties(updatedStudent, studentEntity);
                studentEntity.setRollNo(rollNo);
                studentRepository.save(studentEntity);
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }

    @Override
    public Student ReadStudentById(int rollNo) {
        StudentEntity exStudentEntity = studentRepository.findById(rollNo).get();
        Student student = new Student();
        BeanUtils.copyProperties(exStudentEntity, student);
        return student;
    }

    
}
