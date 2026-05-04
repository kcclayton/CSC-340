package _Proj.NextDorm.Student;
import _Proj.NextDorm.User.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        student.setRole(User.UserRole.STUDENT);
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails){
        return studentRepository.findById(id).map(student -> {
            if (studentDetails.getEmail() != null) {
                student.setEmail(studentDetails.getEmail());
            }
            if (studentDetails.getName() != null) {
                student.setName(studentDetails.getName());
            }
            if (studentDetails.getResidenceHall() != null) {
                student.setResidenceHall(studentDetails.getResidenceHall());
            }
            if (studentDetails.getDescription() != null){
                student.setDescription(studentDetails.getDescription());
            }
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found."));
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student getStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public List<Student> getStudentByResidenceHall(String residenceHall){
        return studentRepository.findByResidenceHall(residenceHall);
    }

    public Student authenticate(String email, String password) {
        Student student = getStudentByEmail(email);
        if (student != null && student.getUserPassword().equals(password)) {
            return student;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
