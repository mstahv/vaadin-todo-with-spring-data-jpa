package com.example.todoexample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoEntityRepository extends JpaRepository<TodoEntity, UUID> {
}
