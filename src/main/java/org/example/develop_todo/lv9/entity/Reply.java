package org.example.develop_todo.lv9.entity;

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

  private Reply(String contents, User user, Todo todo) {
    this.contents = contents;
    this.user = user;
    this.todo = todo;
  }

  protected Reply() {}

  /**
   * 댓글 정보 수정
   *
   * @param contents 댓글 내용
   */
  public void updateReply(String contents) {
    this.contents = contents;
  }

  /**
   * Reply로 변환
   *
   * @param contents 댓글 내용
   * @param user 사용자 정보
   * @param todo 일정 정보
   * @return Reply
   */
  public static Reply of(String contents, User user, Todo todo) {
    return new Reply(contents, user, todo);
  }
}