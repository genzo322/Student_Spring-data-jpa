package com.se.springjpa_crud;

import com.se.springjpa_crud.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.se.springjpa_crud.repository.StudentRepository;

import java.util.List;

@SpringBootTest
class SpringJpaCrudApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    //Repo Save
    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Thu")
                .lastName("Trang")
                .email("thu192@gmail.com")
                .build();
        studentRepository.save(student);
    }

    //Repo FindAll
    @Test
    public void findAllStudent() {
        List<Student> student = (List<Student>) studentRepository.findAll();
        System.out.println(student);
    }

    //JPQL Find By Id
    @Test
    public void findByStudentId(){
        System.out.println(studentRepository.findStudentById(Long.valueOf(4)));
    }

    //Navtive Find By Email
    @Test
    public void findStudentByEmail(){
        Student student = studentRepository.findStudentByEmail("thanhtoan7383@gmail.com");
        System.out.println(student);
    }

    //JPQL Update
    @Test
    public void updateById() {
        studentRepository.updateById(Long.valueOf(1), "Thanh");
    }

    //Repo Update
    @Test
    public void updateById1() {
        Student student = studentRepository.findById(Long.valueOf(2)).get();
        student.setEmail("toanpt322@gmail.com");
        student.setFirstName("Toan");
        student.setLastName("Phung");
        studentRepository.save(student);
    }

    // Native update
    @Test
    public void updateById2(){
        studentRepository.updateStudentByLastName(Long.valueOf(4), "Thanh");
    }

    //Repo Delete
    @Test
    public void deleteStudent() {
        studentRepository.deleteById(Long.valueOf(1));
        System.out.println("Thành công");
    }

    //JPQL Delete
    @Test
    public void deleteById(){
        studentRepository.deleteStudentById(Long.valueOf(3));
        System.out.println("Thành công");
    }

    //Native Delete
    @Test
    public void deleteStudent1(){
        studentRepository.deleteStudent(Long.valueOf(5));
        System.out.println("Thành công");
    }

}
