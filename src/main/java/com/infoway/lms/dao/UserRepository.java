package com.infoway.lms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoway.lms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUserId(String userId);
}

