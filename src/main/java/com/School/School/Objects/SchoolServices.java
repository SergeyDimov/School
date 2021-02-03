package com.School.School.Objects;

import java.util.List;
//Методы, которые должны быть реализованы
public interface SchoolServices{
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    List<Teacher> readAllTeachers();
    List<Student> readAllStudents();
    Student readStudent(int id);
    Teacher readTeacher(int id);
    boolean updateTeacher(Teacher teacher, int id);
    boolean updateStudent(Student student, int id);
    boolean deleteTeacher(int id);
    boolean deleteStudent(int id);
}
