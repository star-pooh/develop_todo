package org.example.develop_todo.lv1.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
  // 작성자명
  private final String username;
  // 일정 제목
  private final String title;
  // 일정 내용
  private final String contents;

  public TodoRequestDto(String username, String title, String contents) {
    this.username = username;
    this.title = title;
    this.contents = contents;
  }
}
