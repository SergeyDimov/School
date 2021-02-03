package com.School.School.Service;

import com.School.School.Objects.Student;
import com.School.School.Objects.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//говорит спрингу, что данный класс является REST контроллером. Т.е. в данном классе будет реализована логика обработки клиентских запросов
public class REST {
        private final SchoolRealisation schoolRealisation;
        @Autowired//говорит спрингу, что в этом месте необходимо внедрить зависимость.
        public REST(SchoolRealisation schoolRealisation){
            this.schoolRealisation=schoolRealisation;
        }
    @PostMapping(value = "/teachers")
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
            schoolRealisation.createTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        schoolRealisation.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/teachers")
    public ResponseEntity <List<Teacher>> readAllTeachers(){
        final List<Teacher> teachers = schoolRealisation.readAllTeachers();
        return  teachers !=null && !teachers.isEmpty()
                ? new ResponseEntity<>(teachers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/students")
    public ResponseEntity <List<Student>> readAllStudents(){
        final List<Student> students = schoolRealisation.readAllStudents();
        return  students !=null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable(name = "id") int id){
            final Student student = schoolRealisation.readStudent(id);
            return student !=null
                    ? new ResponseEntity<>(student, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> readTeacher(@PathVariable(name = "id") int id){
        final Teacher teacher = schoolRealisation.readTeacher(id);
        return teacher !=null
                ? new ResponseEntity<>(teacher, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") int id, @RequestBody Student student){
            final boolean updated = schoolRealisation.updateStudent(student, id);
            return updated
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @PutMapping(value = "/teachers/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable(name = "id") int id, @RequestBody Teacher teacher){
        final boolean updated = schoolRealisation.updateTeacher(teacher, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") int id){
            final boolean delete = schoolRealisation.deleteStudent(id);
            return delete
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/teachers/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable(name = "id") int id){
        final boolean delete = schoolRealisation.deleteTeacher(id);
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
