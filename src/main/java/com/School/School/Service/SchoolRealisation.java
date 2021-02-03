package com.School.School.Service;

import com.School.School.Objects.SchoolServices;
import com.School.School.Objects.Student;
import com.School.School.Objects.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//Реализация методов
@Service
public class SchoolRealisation implements SchoolServices {
    //хранилище учителей
    private static final Map<Integer, Teacher> teachers = new HashMap<>();
    //хранилище учеников
    private static final Map<Integer, Student> students = new HashMap<>();
    //Секвенция id учеников
    private static  final AtomicInteger student_id_count = new AtomicInteger(0);
    //Секвенция id учителей
    private static  final AtomicInteger teachers_id_count = new AtomicInteger(0);


        //Создать нового учителя
        @Override
        public void createTeacher (Teacher teacher){
        final int teacherId = teachers_id_count.incrementAndGet();
        teacher.setId(teacherId);
        teachers.put(teacherId, teacher);

    }
        //Создать нового ученика
        @Override
        public void createStudent (Student student){
        int studentId = student_id_count.incrementAndGet();
        student.setId(studentId);
        students.put(studentId, student);

    }
        //Показать всех учителей
        @Override
        public List<Teacher> readAllTeachers () {
        return new ArrayList<>(teachers.values());
    }
        //Показать всех студентов
        @Override
        public List<Student> readAllStudents () {
        return new ArrayList<>(students.values());
    }
        //Показать данные студента (по id)
        @Override
        public Student readStudent ( int id){
        return students.get(id);
    }
        //Показать данные учителя (по id)
        @Override
        public Teacher readTeacher ( int id){
        return teachers.get(id);
    }
        //Изменить данные в имеющейся записи учителя
        @Override
        public boolean updateTeacher (Teacher teacher,int id){
        if (teachers.containsKey(id)) {
            teacher.setId(id);
            teachers.put(id, teacher);
            return true;
        } else {
            return false;
        }
    }
        //Изменить данные в имеющейся записи ученика
        @Override
        public boolean updateStudent (Student student,int id){
        if (students.containsKey(id)) {
            student.setId(id);
            students.put(id, student);
            return true;
        } else {
            return false;
        }
    }
        //Удалить запись учителя
        @Override
        public boolean deleteTeacher ( int id){
        return teachers.remove(id) != null;
    }
        //Удалить запись ученика
        @Override
        public boolean deleteStudent ( int id){
        return students.remove(id) != null;
    }

    }

