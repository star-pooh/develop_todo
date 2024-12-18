package org.example.develop_todo.lv7.dto.user;

import lombok.Getter;
import org.example.develop_todo.lv7.entity.User;

@Getter
public class UserResponseDto {
  // 사용자 ID
  private final Long id;
  // 사용자 이름
  private final String username;
  // 이메일
  private final String email;

  public UserResponseDto(Long id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }

  public static UserResponseDto toDto(User user) {
    return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
  }
}
