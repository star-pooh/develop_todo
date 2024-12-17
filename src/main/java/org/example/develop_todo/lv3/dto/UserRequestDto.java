package org.example.develop_todo.lv3.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
  // 사용자 이름
  private final String username;
  // 비밀번호
  private final String password;
  // 이메일
  private final String email;

  public UserRequestDto(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
