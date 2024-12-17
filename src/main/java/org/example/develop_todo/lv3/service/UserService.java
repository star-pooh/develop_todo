package org.example.develop_todo.lv3.service;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.develop_todo.lv3.dto.UserResponseDto;
import org.example.develop_todo.lv3.entity.User;
import org.example.develop_todo.lv3.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  /**
   * 사용자 생성
   *
   * @param username 사용자 이름
   * @param password 비밀번호
   * @param email 이메일
   * @return 저장된 사용자 정보
   */
  public UserResponseDto createUser(String username, String password, String email) {
    User user = new User(username, password, email);
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
    findUser.updateUser(username, password, email);
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
}
