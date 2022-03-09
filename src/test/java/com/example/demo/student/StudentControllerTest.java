package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    List<Student> studentsMock = new ArrayList<>();

    @BeforeEach
    void setUp() {
        studentsMock.add(new Student("Jamila", "jamila@gmail.com", Gender.FEMALE));
        studentsMock.add(new Student("Jamal", "jamal@gmail.com", Gender.MALE));
        studentsMock.add(new Student("Mustafa", "mustafa@gmail.com", Gender.MALE));
    }

    @Test
    void canGetAllStudents() {
        //given
        when(studentService.getAllStudents()).thenReturn(studentsMock);

        //when
        List<Student> allStudents = studentController.getAllStudents();

        //then
        assertThat(allStudents.size()).isEqualTo(3);
        assertThat(allStudents.get(0).getEmail()).isEqualTo(studentsMock.get(0).getEmail());
    }

    @Test
    @Disabled
    void addStudent() {
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}