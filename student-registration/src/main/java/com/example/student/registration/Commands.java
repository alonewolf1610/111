package com.example.student.registration;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
class Commands {
    private final List<Student> students;
    private final ApplicationEventPublisher publisher;

    public Commands(List<Student> students, ApplicationEventPublisher publisher) {
        this.students = students;
        this.publisher = publisher;
    }

    @ShellMethod("Add a student")
    public void addStudent(String firstName, String lastName, int age) {
        Student student = new Student(firstName, lastName, age);
        students.add(student);
        publisher.publishEvent(new StudentCreatedEvent(student));
    }

    @ShellMethod("Remove a student")
    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        publisher.publishEvent(new StudentRemovedEvent(id));
    }

    @ShellMethod("List all students")
    public List<Student> listStudents() {
        return students;
    }

    @ShellMethod("Clear all students")
    public void clearStudents() {
        students.clear();
    }
}
