package org.example.develop_todo.lv8.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv8.dto.login.LoginRequestDto;
import org.example.develop_todo.lv8.dto.user.UserResponseDto;
import org.example.develop_todo.lv8.service.UserService;
import org.example.develop_todo.lv8.util.Parse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  /**
   * 사용자 로그인
   *
   * @param dto 로그인에 필요한 요청 데이터
   * @param request HttpServletRequest
   * @return 로그인 결과
   */
  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(
      @Valid @RequestBody LoginRequestDto dto,
      BindingResult bindingResult,
      HttpServletRequest request) {
    Map<String, String> response = new HashMap<>();

    // validation 에러가 있는 경우, 메시지 출력
    if (bindingResult.hasErrors()) {
      String errorMessage = Parse.toString(bindingResult.getFieldErrors());
      response.put("validationError", errorMessage);

      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    UserResponseDto userResponseDto =
        this.userService.validLoginUserInfo(dto.getPassword(), dto.getEmail());

    HttpSession session = request.getSession();
    session.setAttribute("loginUser", userResponseDto.getId());

    String loginMessage = userResponseDto.getUsername() + "님이 로그인하셨습니다.";
    response.put("message", loginMessage);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
