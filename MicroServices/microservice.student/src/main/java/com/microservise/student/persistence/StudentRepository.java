package com.microservise.student.persistence;

import com.microservise.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    //@Query("select s from Student s where s.course_id=:idCourse")
    List<Student> findAllByCourseId(long idCourse);
}
