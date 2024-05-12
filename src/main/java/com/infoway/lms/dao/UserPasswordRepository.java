package com.infoway.lms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoway.lms.model.UserPassword;

@Repository
public interface UserPasswordRepository extends JpaRepository<UserPassword, String> {
	Optional<UserPassword> findByUserId(String userId);
}
