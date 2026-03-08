package in.tanuj.attendence.controller;

import in.tanuj.attendence.model.Student;
import in.tanuj.attendence.service.StudentService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class StudentController {
    
    //StudentService stdService = new StudentServiceImpl();

    //dependency injection
    @Autowired
    StudentService stdService;    

    @GetMapping("student")
    public List<Student> getallstudent() {
        return stdService.ReadAllStudents();
    }

    @GetMapping("student/{rollNo}")
    public Student getstudentbyid(@PathVariable int rollNo) {
        return stdService.ReadStudentById(rollNo);
    }
    
    @PostMapping("student")
    public String createStudent(@RequestBody Student student) {
        return stdService.CreateStudent(student);
    }
    
    @DeleteMapping("student/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        if((stdService.DeleteStudent(rollNo))==true)
            return "Student deleted successfully";
       return "Student not found";
    }

    @PutMapping("student/{rollNo}")
    public String updateStudent(@PathVariable int rollNo, @RequestBody Student student) {
        return stdService.UpdateStudent(rollNo, student);
    }
}
