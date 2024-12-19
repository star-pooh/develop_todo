package org.example.develop_todo.lv9.repository;

import org.example.develop_todo.lv9.entity.Reply;
import org.example.develop_todo.lv9.exception.CustomRepositoryException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

  default Reply findByIdElseOrThrow(Long id) {
    return findById(id)
        .orElseThrow(
            () ->
                new CustomRepositoryException(
                    HttpStatus.NOT_FOUND, "존재하지 않는 댓글 ID 입니다. ID : " + id));
  }
}
