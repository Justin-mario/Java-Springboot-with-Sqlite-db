package com.sqliteproject.sqliteproject.controller;

import com.sqliteproject.sqliteproject.data.dto.DepartmentDto;
import com.sqliteproject.sqliteproject.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<> ( departmentService.addDepartment ( departmentDto ), HttpStatus.CREATED );
    }

}
