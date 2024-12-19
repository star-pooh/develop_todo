package org.example.develop_todo.lv9.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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

  // 댓글 정보
  @OneToMany(mappedBy = "todo")
  private List<Reply> reply;

  private Todo(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }

  protected Todo() {}

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
    this.title = title;
    this.contents = contents;
  }

  /**
   * TODO로 변환
   *
   * @param title 일정 제목
   * @param contents 일정 내용
   * @return Todo
   */
  public static Todo of(String title, String contents) {
    return new Todo(title, contents);
  }
}
