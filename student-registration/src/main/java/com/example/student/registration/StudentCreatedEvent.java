package com.example.student.registration;
import org.springframework.context.ApplicationEvent;

class StudentCreatedEvent extends ApplicationEvent {
    public StudentCreatedEvent(Student student) {
        super(student);
    }
}