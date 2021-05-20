package com.security.demo.repository;


import com.security.demo.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MessageRepo extends JpaRepository<Message, Long> {
}
