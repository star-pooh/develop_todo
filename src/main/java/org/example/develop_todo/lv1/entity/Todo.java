package org.example.develop_todo.lv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

  // 일정 ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 작성자명
  @Column(nullable = false)
  private String username;

  // 일정 제목
  @Column(nullable = false)
  private String title;

  // 일정 내용
  @Column(nullable = false)
  private String contents;

  public Todo(String username, String title, String contents) {
    this.username = username;
    this.title = title;
    this.contents = contents;
  }

  public Todo() {}

  /**
   * 일정 내용 수정
   *
   * @param username 작성자명
   * @param title 일정 제목
   * @param contents 일정 내용
   */
  public void updateTodo(String username, String title, String contents) {
    if (!Objects.isNull(username)) {
      this.username = username;
    }

    if (!Objects.isNull(title)) {
      this.title = title;
    }

    if (!Objects.isNull(contents)) {
      this.contents = contents;
    }
  }
}
