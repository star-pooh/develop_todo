package org.example.develop_todo.lv1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv1.dto.TodoRequestDto;
import org.example.develop_todo.lv1.dto.TodoResponseDto;
import org.example.develop_todo.lv1.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  /**
   * 일정 생성 API
   *
   * @param dto 등록에 사용할 요청 데이터
   * @return 등록된 일정 정보
   */
  @PostMapping
  public ResponseEntity<Map<String, TodoResponseDto>> createTodo(@RequestBody TodoRequestDto dto) {
    TodoResponseDto todoResponseDto =
        this.todoService.createTodo(dto.getUsername(), dto.getTitle(), dto.getContents());

    Map<String, TodoResponseDto> response = new HashMap<>();
    response.put("todoData", todoResponseDto);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /**
   * 일정 전체 조회 API
   *
   * @return 조회된 일정 정보
   *     <p>일정 정보가 1건도 없을 시, 빈 배열 반환
   */
  @GetMapping
  public ResponseEntity<Map<String, List<TodoResponseDto>>> findAllTodo() {
    List<TodoResponseDto> todoResponseDtoList = this.todoService.findAllTodo();

    Map<String, List<TodoResponseDto>> response = new HashMap<>();
    response.put("todoData", todoResponseDtoList);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * 일정 1건 조회 API
   *
   * @param id 일정 ID
   * @return 조회된 일정 정보
   */
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, TodoResponseDto>> findById(@PathVariable Long id) {
    TodoResponseDto todoResponseDto = this.todoService.findById(id);

    Map<String, TodoResponseDto> response = new HashMap<>();
    response.put("todoData", todoResponseDto);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * 일정 수정 API
   *
   * @param id 일정 ID
   * @param dto 수정에 사용할 요청 데이터
   * @return 수정된 일정 정보
   */
  @PatchMapping("/{id}")
  public ResponseEntity<Map<String, TodoResponseDto>> updateTodo(
      @PathVariable Long id, @RequestBody TodoRequestDto dto) {
    this.todoService.updateTodo(id, dto.getUsername(), dto.getTitle(), dto.getContents());
    // 수정일이 반영된 데이터가 필요하기 때문에 다시 조회를 실행
    TodoResponseDto todoResponseDto = this.todoService.findById(id);

    Map<String, TodoResponseDto> response = new HashMap<>();
    response.put("todoData", todoResponseDto);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * 일정 삭제 API
   *
   * @param id 일정 ID
   * @return 삭제 결과
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
    this.todoService.deleteTodo(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
