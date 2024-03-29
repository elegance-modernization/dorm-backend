package com.shiyulu.service.impl;

import com.shiyulu.mapper.StudentMapper;
import com.shiyulu.pojo.Student;
import com.shiyulu.service.StudentService;
import com.shiyulu.mapper.StudentMapper;
import com.shiyulu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByIdAndDorm(Integer studentId, String dormNumber) {

        return studentMapper.findStudentByIdAndDorm(studentId, dormNumber);
    }

    @Override
    public String getStudentUserNameByNumber(String studentNumber) {

        return studentMapper.getStudentUserNameByNumber(studentNumber);
    }

    @Override
    public Student getStudentInfo(String studentUserName) {

        return studentMapper.getStudentInfo(studentUserName);
    }

    @Override
    public List<Student> getStudentByDorm(String dormNumber) {

        return studentMapper.getStudentByDorm(dormNumber);
    }
}
