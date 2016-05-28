package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.domain.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
