package com.dotodo.DoToDo.dao;

import com.dotodo.DoToDo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Boolean existsByEmail(String email);

  @Transactional
  @Modifying
  void deleteByEmail(String email);

  Optional<User> findByEmail(String email);
}
