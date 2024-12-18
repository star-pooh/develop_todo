package org.example.develop_todo.lv7.dto.reply;

import java.time.format.DateTimeFormatter;
import lombok.Getter;
import org.example.develop_todo.lv7.entity.Reply;

@Getter
public class ReplyResponseDto {

  // 댓글 ID
  private final Long id;
  // 댓글 내용
  private final String contents;
  // 사용자 ID
  private final Long userId;
  // 일정 ID
  private final Long todoId;
  // 댓글 작성일
  private final String createdDate;
  // 댓글 수정일
  private final String modifiedDate;

  public ReplyResponseDto(
      Long id, String contents, Long userId, Long todoId, String createdDate, String modifiedDate) {
    this.id = id;
    this.contents = contents;
    this.userId = userId;
    this.todoId = todoId;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }

  public static ReplyResponseDto toDto(Reply reply) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    return new ReplyResponseDto(
        reply.getId(),
        reply.getContents(),
        reply.getUser().getId(),
        reply.getTodo().getId(),
        reply.getCreatedDate().format(dtf),
        reply.getModifiedDate().format(dtf));
  }
}
