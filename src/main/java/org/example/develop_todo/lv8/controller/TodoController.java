package org.example.develop_todo.lv8.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv8.dto.todo.TodoCreateRequestDto;
import org.example.develop_todo.lv8.dto.todo.TodoPagingResponseDto;
import org.example.develop_todo.lv8.dto.todo.TodoResponseDto;
import org.example.develop_todo.lv8.dto.todo.TodoUpdateRequestDto;
import org.example.develop_todo.lv8.service.TodoService;
import org.example.develop_todo.lv8.util.Parse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<Map<String, Object>> createTodo(
      @Valid @RequestBody TodoCreateRequestDto dto,
      BindingResult bindingResult,
      HttpServletRequest request) {
    Map<String, Object> response = new HashMap<>();

    // validation 에러가 있는 경우, 메시지 출력
    if (bindingResult.hasErrors()) {
      String errorMessage = Parse.toString(bindingResult.getFieldErrors());
      response.put("validationError", errorMessage);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    TodoResponseDto todoResponseDto =
        this.todoService.createTodo(dto.getUserId(), dto.getTitle(), dto.getContents());
    response.put("todoData", todoResponseDto);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /**
   * 일정 전체 조회 API
   *
   * @param pageNum 페이지 번호
   * @param pageSize 페이지 크기
   * @return 조회된 일정 정보
   */
  @GetMapping
  public ResponseEntity<Map<String, List<TodoPagingResponseDto>>> findAllTodo(
      @RequestParam(defaultValue = "0") int pageNum,
      @RequestParam(defaultValue = "10") int pageSize) {
    Map<String, List<TodoPagingResponseDto>> response = new HashMap<>();

    List<TodoPagingResponseDto> todoPagingResponseDtoList =
        this.todoService.findAllTodo(pageNum, pageSize);
    response.put("todoData", todoPagingResponseDtoList);

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
    Map<String, TodoResponseDto> response = new HashMap<>();

    TodoResponseDto todoResponseDto = this.todoService.findById(id);
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
  public ResponseEntity<Map<String, Object>> updateTodo(
      @PathVariable Long id,
      @Valid @RequestBody TodoUpdateRequestDto dto,
      BindingResult bindingResult) {
    Map<String, Object> response = new HashMap<>();

    // validation 에러가 있는 경우, 메시지 출력
    if (bindingResult.hasErrors()) {
      String errorMessage = Parse.toString(bindingResult.getFieldErrors());
      response.put("validationError", errorMessage);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    this.todoService.updateTodo(id, dto.getTitle(), dto.getContents());
    // 수정일이 반영된 데이터가 필요하기 때문에 다시 조회를 실행
    TodoResponseDto todoResponseDto = this.todoService.findById(id);
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
