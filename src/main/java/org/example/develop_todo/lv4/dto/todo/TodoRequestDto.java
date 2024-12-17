package org.example.develop_todo.lv4.dto.todo;

import lombok.Getter;

@Getter
public class TodoRequestDto {
  // 작성자 ID
  private final Long userId;
  // 일정 제목
  private final String title;
  // 일정 내용
  private final String contents;

  public TodoRequestDto(Long userId, String title, String contents) {
    this.userId = userId;
    this.title = title;
    this.contents = contents;
  }
}