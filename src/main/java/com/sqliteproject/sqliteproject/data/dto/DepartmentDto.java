package com.sqliteproject.sqliteproject.data.dto;

import com.sqliteproject.sqliteproject.data.entity.DepartmentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto {
    private Integer departmentId;

    private String departmentName;

    private String faculty;

    public DepartmentDto(DepartmentEntity departmentEntity){
        departmentId = departmentEntity.getDepartmentId ();
        departmentName = departmentEntity.getDepartmentName ();
        faculty = departmentEntity.getFaculty ();
    }
}
