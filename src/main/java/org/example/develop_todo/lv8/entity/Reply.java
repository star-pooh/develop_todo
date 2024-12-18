package org.example.develop_todo.lv8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@Entity
@Table(name = "reply")
public class Reply extends BaseEntity {

  // 댓글 ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 댓글 내용
  @NotBlank
  @Column(nullable = false)
  private String contents;

  // 사용자 정보
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // 일정 정보
  @ManyToOne
  @JoinColumn(name = "todo_id")
  private Todo todo;

  public Reply(String contents) {
    this.contents = contents;
  }

  public Reply() {}

  public void setUser(User user) {
    this.user = user;
  }

  public void setTodo(Todo todo) {
    this.todo = todo;
  }

  public void updateReply(String contents) {
    this.contents = contents;
  }
}
