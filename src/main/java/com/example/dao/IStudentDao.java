package com.example.dao;

import com.example.dto.Student;

public interface IStudentDao {
    public Integer save(Student s);

    public Student getById(Integer sid);

    public Integer updateById(Student s);

    public Integer deleteById(Integer sid);
}
