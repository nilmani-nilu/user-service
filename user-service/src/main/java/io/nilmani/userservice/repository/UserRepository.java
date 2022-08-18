package io.nilmani.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.nilmani.userservice.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
    User findByUserId(Integer userId);
}
