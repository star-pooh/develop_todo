package org.example.develop_todo.lv4.repository;

import java.util.Optional;
import org.example.develop_todo.lv4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  default User findByIdElseOrThrow(Long id) {
    return findById(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 유저 ID 입니다. ID : " + id));
  }

  Optional<User> findByPasswordAndEmail(String password, String email);

  default User findByPasswordAndEmailElseOrThrow(String password, String email) {
    return findByPasswordAndEmail(password, email)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호 또는 이메일이 일치하지 않습니다."));
  }
}
