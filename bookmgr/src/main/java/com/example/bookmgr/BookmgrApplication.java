package com.example.bookmgr;

import com.example.bookmgr.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmgrApplication.class, args);
	}
}
