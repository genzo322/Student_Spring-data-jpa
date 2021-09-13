package com.se.springjpa_crud.repository;

import com.se.springjpa_crud.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("update Student e set e.firstName = ?2 where e.StudentID = ?1")
    public void updateById(Long id, String newFirstName);

    @Transactional
    @Modifying
    @Query(value = "update tbl_student set last_name = ?2 where studentid = ?1", nativeQuery = true)
    public void updateStudentByLastName(Long id, String newLastName);

    @Query("select e from Student e where e.StudentID = ?1")
    public Student findStudentById(Long id);

    @Transactional
    @Modifying
    @Query("delete from Student e where e.StudentID = ?1")
    public void deleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where studentid = ?1", nativeQuery = true)
    public void deleteStudent(Long id);


    @Query(value = "select * from tbl_student where email = ?1", nativeQuery = true)
    public Student findStudentByEmail(String email);
}
