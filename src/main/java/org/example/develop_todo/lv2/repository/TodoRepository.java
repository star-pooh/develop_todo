package org.example.develop_todo.lv2.repository;

import org.example.develop_todo.lv2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  default Todo findByIdOrElseThrow(Long id) {
    return findById(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 일정 ID 입니다. ID : " + id));
  }
}
