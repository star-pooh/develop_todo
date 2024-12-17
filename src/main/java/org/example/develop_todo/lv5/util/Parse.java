package org.example.develop_todo.lv5.util;

import java.util.List;
import org.springframework.validation.FieldError;

public class Parse {

  /**
   * validation 에러 메시지 변환
   *
   * @param fieldErrorList validation 필드 에러 리스트
   * @return 에러 메시지만 모은 문자열
   */
  public static String toString(List<FieldError> fieldErrorList) {
    StringBuilder errorMessage = new StringBuilder();

    for (FieldError error : fieldErrorList) {
      errorMessage.append(error.getDefaultMessage()).append('\n');
    }

    return errorMessage.toString().trim();
  }
}
