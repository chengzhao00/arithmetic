package com.example.lib_arithmetic.sort;

/**
 * @author:MR-Cheng
 * @date: 2020/8/22
 * @description:
 * @parameter:
 */
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {

        return this.score - student.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
