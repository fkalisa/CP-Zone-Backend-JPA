package com.example.demo.JPAbackendZone.repository;

import com.example.demo.JPAbackendZone.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
