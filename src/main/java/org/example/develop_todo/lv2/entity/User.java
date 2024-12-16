package org.example.develop_todo.lv2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

  // 사용자 ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 사용자 이름
  @Column(nullable = false)
  private String username;

  // 이메일
  @Column(nullable = false)
  private String email;

  // 생성일
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdDate;

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public User() {}

  /**
   * 사용자 정보 수정
   *
   * @param username 사용자 이름
   * @param email 이메일
   */
  public void updateUser(String username, String email) {
    if (!Objects.isNull(username)) {
      this.username = username;
    }

    if (!Objects.isNull(email)) {
      this.email = email;
    }
  }
}
