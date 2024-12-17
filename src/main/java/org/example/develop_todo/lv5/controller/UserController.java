package org.example.develop_todo.lv5.controller;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv5.dto.user.UserRequestDto;
import org.example.develop_todo.lv5.dto.user.UserResponseDto;
import org.example.develop_todo.lv5.service.UserService;
import org.example.develop_todo.lv5.util.Parse;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  /**
   * 사용자 생성 API
   *
   * @param dto 등록에 사용할 요청 데이터
   * @return 등록된 사용자 정보
   */
  @PostMapping("/signup")
  public ResponseEntity<Map<String, Object>> createUser(
      @Valid @RequestBody UserRequestDto dto, BindingResult bindingResult) {
    Map<String, Object> response = new HashMap<>();

    // validation 에러가 있는 경우, 메시지 출력
    if (bindingResult.hasErrors()) {
      String errorMessage = Parse.toString(bindingResult.getFieldErrors());
      response.put("validationError", errorMessage);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    UserResponseDto userResponseDto =
        this.userService.createUser(dto.getUsername(), dto.getPassword(), dto.getEmail());
    response.put("userData", userResponseDto);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /**
   * 사용자 전체 조회 API
   *
   * @return 조회된 사용자 정보
   *     <p>사용자 정보가 1건도 없을 시, 빈 배열 반환
   */
  @GetMapping
  public ResponseEntity<Map<String, List<UserResponseDto>>> findAllUser() {
    Map<String, List<UserResponseDto>> response = new HashMap<>();

    List<UserResponseDto> userResponseDtoList = this.userService.findAllUser();
    response.put("userData", userResponseDtoList);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * 사용자 1명 조회 API
   *
   * @param id 사용자 ID
   * @return 조회된 사용자 정보
   */
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, UserResponseDto>> findById(@PathVariable Long id) {
    Map<String, UserResponseDto> response = new HashMap<>();

    UserResponseDto userResponseDto = this.userService.findById(id);
    response.put("userData", userResponseDto);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /**
   * 사용자 정보 수정 API
   *
   * @param id 사용자 ID
   * @param dto 수정에 사용할 요청 데이터
   * @return 수정된 사용자 정보
   */
  @PatchMapping("/{id}")
  public ResponseEntity<Map<String, Object>> updateUser(
      @PathVariable Long id, @Valid @RequestBody UserRequestDto dto, BindingResult bindingResult) {
    Map<String, Object> response = new HashMap<>();

    // validation 에러가 있는 경우, 메시지 출력
    if (bindingResult.hasErrors()) {
      String errorMessage = Parse.toString(bindingResult.getFieldErrors());
      response.put("validationError", errorMessage);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    UserResponseDto userResponseDto =
        this.userService.updateUser(id, dto.getUsername(), dto.getPassword(), dto.getEmail());
    response.put("userData", userResponseDto);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  /**
   * 사용자 삭제 API
   *
   * @param id 사용자 ID
   * @return 삭제 결과
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    this.userService.deleteUser(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
