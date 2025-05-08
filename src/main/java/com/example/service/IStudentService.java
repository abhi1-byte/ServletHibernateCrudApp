package com.example.service;

import com.example.dto.Student;

public interface IStudentService {
    public Integer save(Student s);

    public Student getById(Integer sid);

    public Integer updateById(Student s);

    public Integer deleteById(Integer sid);
}
