package com.sqliteproject.sqliteproject.service;

import com.sqliteproject.sqliteproject.data.dto.DepartmentDto;
import com.sqliteproject.sqliteproject.repository.DepartmentRepository;
import com.sqliteproject.sqliteproject.data.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentDto addDepartment(DepartmentDto departmentDto){
        DepartmentEntity departmentEntity = new DepartmentEntity (departmentDto);
        departmentRepository.save ( departmentEntity );
        return new DepartmentDto (departmentEntity);
    }
}
