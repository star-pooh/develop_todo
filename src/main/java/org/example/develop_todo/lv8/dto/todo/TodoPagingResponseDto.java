package org.example.develop_todo.lv8.dto.todo;

import java.time.format.DateTimeFormatter;
import lombok.Getter;
import org.example.develop_todo.lv8.entity.Todo;

@Getter
public class TodoPagingResponseDto {
  private final String title;
  private final String contents;
  private final int replyNum;
  private final String createdDate;
  private final String modifiedDate;
  private final String userName;

  public TodoPagingResponseDto(
      String title,
      String contents,
      int replyNum,
      String createdDate,
      String modifiedDate,
      String userName) {
    this.title = title;
    this.contents = contents;
    this.replyNum = replyNum;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
    this.userName = userName;
  }

  public static TodoPagingResponseDto toDto(Todo todo) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    return new TodoPagingResponseDto(
        todo.getTitle(),
        todo.getContents(),
        todo.getReply().size(),
        todo.getCreatedDate().format(dtf),
        todo.getModifiedDate().format(dtf),
        todo.getUser().getUsername());
  }
}