package com.dotodo.DoToDo.auth.dao;

import com.dotodo.DoToDo.auth.model.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String> {

    Optional<UserToken> findByEmail(String email);
}
