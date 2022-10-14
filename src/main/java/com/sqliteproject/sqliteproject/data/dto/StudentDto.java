package com.sqliteproject.sqliteproject.data.dto;

import com.sqliteproject.sqliteproject.data.entity.StudentEntity;
import com.sqliteproject.sqliteproject.data.entity.DepartmentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
    private Integer studentId;

    private String firstName;

    private String lastName;

    private DepartmentEntity department;

    public StudentDto(StudentEntity studentEntity){
        studentId = studentEntity.getStudentId ();
        firstName = studentEntity.getFirstName ();
        lastName = studentEntity.getLastName ();
        department = studentEntity.getDepartment ();
    }


}
