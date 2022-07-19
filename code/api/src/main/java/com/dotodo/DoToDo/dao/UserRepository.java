package com.dotodo.DoToDo.dao;

import com.dotodo.DoToDo.com.dotodo.DoToDo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<String, User> {
  Boolean existsByUsername(String userName);
}
