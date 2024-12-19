package org.example.develop_todo.lv9.repository;

import org.example.develop_todo.lv9.entity.Todo;
import org.example.develop_todo.lv9.exception.CustomRepositoryException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface TodoRepository extends JpaRepository<Todo, Long> {

  default Todo findByIdOrElseThrow(Long id) {
    return findById(id)
        .orElseThrow(
            () ->
                new CustomRepositoryException(
                    HttpStatus.NOT_FOUND, "존재하지 않는 일정 ID 입니다. ID : " + id));
  }

  Page<Todo> findAllByOrderByModifiedDateDesc(Pageable pageable);
}
