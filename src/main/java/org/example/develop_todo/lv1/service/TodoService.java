package org.example.develop_todo.lv1.service;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv1.dto.TodoResponseDto;
import org.example.develop_todo.lv1.entity.Todo;
import org.example.develop_todo.lv1.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  /**
   * 일정 생성
   *
   * @param username 작성자명
   * @param title 일정 제목
   * @param contents 일정 내용
   * @return 저장된 일정 정보
   */
  public TodoResponseDto createTodo(String username, String title, String contents) {
    Todo todo = new Todo(username, title, contents);
    Todo savedTodo = this.todoRepository.save(todo);

    return TodoResponseDto.toDto(savedTodo);
  }

  /**
   * 전체 일정 조회
   *
   * @return 조회된 일정 정보
   */
  public List<TodoResponseDto> findAllTodo() {
    return this.todoRepository.findAll().stream().map(TodoResponseDto::toDto).toList();
  }

  /**
   * 일정 1건 조회
   *
   * @param id 일정 ID
   * @return 조회된 일정 정보
   */
  public TodoResponseDto findById(Long id) {
    Todo findTodo = this.todoRepository.findByIdOrElseThrow(id);
    return TodoResponseDto.toDto(findTodo);
  }

  /**
   * 일정 수정
   *
   * @param id 일정 ID
   * @param username 작성자명
   * @param title 일정 제목
   * @param contents 일정 내용
   */
  @Transactional
  public void updateTodo(Long id, String username, String title, String contents) {
    Todo findTodo = this.todoRepository.findByIdOrElseThrow(id);
    findTodo.updateTodo(username, title, contents);
  }

  /**
   * 일정 삭제
   *
   * @param id 일정 ID
   */
  public void deleteTodo(Long id) {
    Todo findTodo = this.todoRepository.findByIdOrElseThrow(id);
    this.todoRepository.delete(findTodo);
  }
}
