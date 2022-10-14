package com.sqliteproject.sqliteproject.service;

import com.sqliteproject.sqliteproject.data.dto.StudentDto;
import com.sqliteproject.sqliteproject.data.entity.DepartmentEntity;
import com.sqliteproject.sqliteproject.data.entity.StudentEntity;
import com.sqliteproject.sqliteproject.repository.DepartmentRepository;
import com.sqliteproject.sqliteproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final DepartmentRepository departmentRepository;

    public StudentDto addStudent(StudentDto studentDto, Integer departmentId){
        StudentEntity studentEntity = new StudentEntity (studentDto);
        DepartmentEntity department = getStudentDepartment ( departmentId );
        studentEntity.setDepartment ( department );
        studentRepository.save ( studentEntity );
        return new StudentDto (studentEntity);
    }

    public StudentDto getStudentById(Integer studentId){
        StudentEntity student = findStudentById ( studentId );
            return new StudentDto (student);

    }

    public List<StudentDto> findAllStudent(){
        List<StudentEntity> allStudents = studentRepository.findAll ();
        return allStudents.stream ()
                .map ( StudentDto::new )
                .collect( Collectors.toList());
    }

    public String deleteStudent(Integer studentId){
       StudentEntity student =  findStudentById ( studentId );
       studentRepository.delete ( student );
       return "student with id " +studentId+ " has been deleted";
    }



    public StudentDto updateStudentRecord(Integer studentId, StudentDto studentDto, Integer departmentId){
        StudentEntity student = findStudentById ( studentId );
        student.setDepartment ( studentDto.getDepartment () );
        student.setFirstName ( studentDto.getFirstName () );
        student.setLastName ( studentDto.getLastName () );
        DepartmentEntity department = getStudentDepartment ( departmentId );
        student.setDepartment ( department );
        studentRepository.save ( student );
        return new StudentDto (student);
    }

    private DepartmentEntity getStudentDepartment(Integer departmentId){
        Optional<DepartmentEntity> department = departmentRepository.findById ( departmentId );
        if (department.isEmpty ()){
            throw new IllegalArgumentException ("Department id " + departmentId + " does not exist");
        }
        return department.get ();
    }

    private StudentEntity findStudentById(Integer studentId){
        Optional<StudentEntity> student = studentRepository.findById ( studentId );
        if (student.isPresent ()){
            return  student.get ();
        }
        else
            throw new IllegalArgumentException ("student with id" +studentId+ " does not exist");
    }
}
