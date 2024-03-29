package com.expensetracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.entity.User;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String username);
}