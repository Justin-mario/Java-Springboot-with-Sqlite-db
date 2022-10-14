package com.sqliteproject.sqliteproject.controller;

import com.sqliteproject.sqliteproject.data.dto.StudentDto;
import com.sqliteproject.sqliteproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add/{departmentId}")
    public ResponseEntity<?> addStudent(@PathVariable Integer departmentId, @RequestBody StudentDto studentDto){
        return new ResponseEntity<> (  studentService.addStudent ( studentDto, departmentId ), HttpStatus.CREATED );
    }

    @GetMapping("/get-by-id/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer studentId){
        return new ResponseEntity<> ( studentService.getStudentById ( studentId ), HttpStatus.OK );
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<> ( studentService.findAllStudent (), HttpStatus.OK );
    }

    @DeleteMapping("/delete-by-id/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Integer studentId){
        return new ResponseEntity<> ( studentService.deleteStudent ( studentId ), HttpStatus.OK );
    }

    @PatchMapping("/update/{studentId}/{departmentId}")
    public ResponseEntity<?> updateStudentRecord(@PathVariable Integer studentId, @PathVariable Integer departmentId, @RequestBody StudentDto studentDto){
        return new ResponseEntity<> ( studentService.updateStudentRecord ( studentId, studentDto, departmentId ), HttpStatus.OK );
    }
}
