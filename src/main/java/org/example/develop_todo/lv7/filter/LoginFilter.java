package org.example.develop_todo.lv7.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

@Slf4j
public class LoginFilter implements Filter {

  // 필터 처리 제외 URI
  private static final String[] WHITE_LIST = {"/users/signup", "/login"};

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    String requestURI = httpServletRequest.getRequestURI();

    // 필터 처리 대상 URI라면 로그인 되어 있는지 확인
    if (!isWhiteList(requestURI)) {
      HttpSession session = httpServletRequest.getSession(false);

      if (Objects.isNull(session) || Objects.isNull(session.getAttribute("loginUser"))) {
        throw new RuntimeException("로그인 해주세요");
      }

      log.info("로그인에 성공했습니다.");
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  /**
   * 필터 처리 제외 URI인지 확인
   *
   * @param requestURI 요청 URI
   * @return true : 필터 처리 제외 URI / false : 필터 처리 대상 URI
   */
  private boolean isWhiteList(String requestURI) {
    return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
  }
}
