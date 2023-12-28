package com.example.student.registration;

import org.springframework.context.ApplicationEvent;

class StudentRemovedEvent extends ApplicationEvent {
    public StudentRemovedEvent(Integer id) {
        super(id);
    }
}