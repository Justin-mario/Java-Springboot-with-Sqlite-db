package com.sqliteproject.sqliteproject.repository;


import com.sqliteproject.sqliteproject.data.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
