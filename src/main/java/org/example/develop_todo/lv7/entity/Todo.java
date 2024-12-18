package org.example.develop_todo.lv7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  // 작성자
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // 일정 제목
  @Column(nullable = false)
  private String title;

  // 일정 내용
  @Column(nullable = false)
  private String contents;

  public Todo(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }

  public Todo() {}

  /**
   * 작성자 정보 설정
   *
   * @param user 작성자 정보
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * 일정 내용 수정
   *
   * @param title 일정 제목
   * @param contents 일정 내용
   */
  public void updateTodo(String title, String contents) {
    if (!Objects.isNull(title)) {
      this.title = title;
    }

    if (!Objects.isNull(contents)) {
      this.contents = contents;
    }
  }
}
