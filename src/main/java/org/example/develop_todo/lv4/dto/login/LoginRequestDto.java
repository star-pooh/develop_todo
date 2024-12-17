package org.example.develop_todo.lv4.dto.login;

import lombok.Getter;

@Getter
public class LoginRequestDto {
  // 비밀번호
  private final String password;
  // 이메일
  private final String email;

  public LoginRequestDto(String password, String email) {
    this.password = password;
    this.email = email;
  }
}
