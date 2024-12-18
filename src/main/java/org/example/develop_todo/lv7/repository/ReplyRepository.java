package org.example.develop_todo.lv7.repository;

import org.example.develop_todo.lv7.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

  default Reply findByIdElseOrThrow(Long id) {
    return findById(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 댓글 ID 입니다. ID : " + id));
  }
}
