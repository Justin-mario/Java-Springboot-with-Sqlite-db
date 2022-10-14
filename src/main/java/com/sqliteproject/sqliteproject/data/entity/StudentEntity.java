package com.sqliteproject.sqliteproject.data.entity;

import com.sqliteproject.sqliteproject.data.dto.StudentDto;
import com.sqliteproject.sqliteproject.data.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    private String firstName;

    private String lastName;

    @OneToOne
    private DepartmentEntity department;

    public StudentEntity(StudentDto studentDto){
        studentId = studentDto.getStudentId ();
        firstName = studentDto.getFirstName ();
        lastName = studentDto.getLastName ();
//        department = studentDto.getDepartment ();
    }


}
