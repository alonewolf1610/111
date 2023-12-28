package com.example.student.registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    private final List<Student> students;
    public DemoApplication(List<Student> students) {
        this.students = students;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public List<Student> students() {
        return new ArrayList<>();
    }
    @EventListener
    @Order(1)
    public void seedData(ContextRefreshedEvent event) {
        students.add(new Student("Иван", "Петров", 20));
        students.add(new Student("Петр", "Иванов", 21));
        students.add(new Student("Сергей", "Федоров", 22));
    }
}