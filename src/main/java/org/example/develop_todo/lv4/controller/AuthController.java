package org.example.develop_todo.lv4.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv4.dto.login.LoginRequestDto;
import org.example.develop_todo.lv4.dto.user.UserResponseDto;
import org.example.develop_todo.lv4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> login(
      @RequestBody LoginRequestDto dto, HttpServletRequest request) {
    UserResponseDto userResponseDto =
        this.userService.findByPasswordAndEmail(dto.getPassword(), dto.getEmail());

    HttpSession session = request.getSession();
    session.setAttribute("loginUser", userResponseDto.getId());

    String loginMessage = userResponseDto.getUsername() + "님이 로그인하셨습니다.";
    return new ResponseEntity<>(loginMessage, HttpStatus.OK);
  }
}
