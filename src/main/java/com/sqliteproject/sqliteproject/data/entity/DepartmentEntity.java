package com.sqliteproject.sqliteproject.data.entity;

import com.sqliteproject.sqliteproject.data.dto.DepartmentDto;
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
public class DepartmentEntity {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer departmentId;

    private String departmentName;

    private String faculty;

    public DepartmentEntity(DepartmentDto departmentDto){
        departmentId = departmentDto.getDepartmentId ();
        departmentName = departmentDto.getDepartmentName ();
        faculty = departmentDto.getFaculty ();
    }
}
