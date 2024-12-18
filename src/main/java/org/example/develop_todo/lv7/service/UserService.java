package org.example.develop_todo.lv7.service;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv7.config.PasswordEncoder;
import org.example.develop_todo.lv7.dto.user.UserResponseDto;
import org.example.develop_todo.lv7.entity.User;
import org.example.develop_todo.lv7.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  /**
   * 사용자 생성
   *
   * @param username 사용자 이름
   * @param password 비밀번호
   * @param email 이메일
   * @return 저장된 사용자 정보
   */
  public UserResponseDto createUser(String username, String password, String email) {
    // 비밀번호 암호화 적용
    String encodedPassword = this.passwordEncoder.encode(password);

    User user = new User(username, encodedPassword, email);
    User savedUser = this.userRepository.save(user);

    return UserResponseDto.toDto(savedUser);
  }

  /**
   * 사용자 전체 조회
   *
   * @return 조회된 사용자 정보
   */
  public List<UserResponseDto> findAllUser() {
    return this.userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
  }

  /**
   * 사용자 1명 조회
   *
   * @param id 사용자 ID
   * @return 조회된 사용자 정보
   */
  public UserResponseDto findById(Long id) {
    User findUser = this.userRepository.findByIdElseOrThrow(id);
    return UserResponseDto.toDto(findUser);
  }

  /**
   * 사용자 정보 수정
   *
   * @param id 사용자 ID
   * @param username 사용자 이름
   * @param password 비밀번호
   * @param email 이메일
   * @return 수정된 사용자 정보
   */
  @Transactional
  public UserResponseDto updateUser(Long id, String username, String password, String email) {
    User findUser = this.userRepository.findByIdElseOrThrow(id);
    // 비밀번호 암호화 적용
    String encodedPassword = this.passwordEncoder.encode(password);
    findUser.updateUser(username, encodedPassword, email);

    return UserResponseDto.toDto(findUser);
  }

  /**
   * 사용자 삭제
   *
   * @param id 사용자 ID
   */
  public void deleteUser(Long id) {
    User findUser = this.userRepository.findByIdElseOrThrow(id);
    this.userRepository.delete(findUser);
  }

  /**
   * 사용자 조회 (로그인용)
   *
   * @param password 비밀번호
   * @param email 이메일
   * @return 조회된 사용자 정보
   */
  public UserResponseDto validLoginUserInfo(String password, String email) {
    User findUser = this.userRepository.findByEmailElseOrThrow(email);
    boolean isMatchesPassword = this.passwordEncoder.matches(password, findUser.getPassword());

    if (!isMatchesPassword) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
    }

    return UserResponseDto.toDto(findUser);
  }
}
