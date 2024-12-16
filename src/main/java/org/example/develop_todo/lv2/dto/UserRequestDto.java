package org.example.develop_todo.lv2.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
  // 사용자 이름
  private final String username;
  // 이메일
  private final String email;

  public UserRequestDto(String username, String email) {
    this.username = username;
    this.email = email;
  }
}
