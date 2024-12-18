package org.example.develop_todo.lv8.service;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv8.dto.todo.TodoPagingResponseDto;
import org.example.develop_todo.lv8.dto.todo.TodoResponseDto;
import org.example.develop_todo.lv8.entity.Todo;
import org.example.develop_todo.lv8.entity.User;
import org.example.develop_todo.lv8.repository.TodoRepository;
import org.example.develop_todo.lv8.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final UserRepository userRepository;

  /**
   * 일정 생성
   *
   * @param userId 작성자 ID
   * @param title 일정 제목
   * @param contents 일정 내용
   * @return 저장된 일정 정보
   */
  public TodoResponseDto createTodo(Long userId, String title, String contents) {
    Todo todo = new Todo(title, contents);
    User findUser = this.userRepository.findByIdElseOrThrow(userId);
    todo.setUser(findUser);

    Todo savedTodo = this.todoRepository.save(todo);
    return TodoResponseDto.toDto(savedTodo);
  }

  /**
   * 전체 일정 조회
   *
   * @return 조회된 일정 정보
   */
  public List<TodoPagingResponseDto> findAllTodo(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page<Todo> foundAllTodoList = this.todoRepository.findAllByOrderByModifiedDateDesc(pageable);

    return foundAllTodoList.stream().map(TodoPagingResponseDto::toDto).toList();
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
   * @param title 일정 제목
   * @param contents 일정 내용
   */
  @Transactional
  public void updateTodo(Long id, String title, String contents) {
    Todo findTodo = this.todoRepository.findByIdOrElseThrow(id);
    findTodo.updateTodo(title, contents);
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
