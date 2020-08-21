package com.example.test;

import java.util.Objects;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/21 下午2:56
 * @Version: 1.0
 * @Description:
 */
public class Student {
    public int age;
    public String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
