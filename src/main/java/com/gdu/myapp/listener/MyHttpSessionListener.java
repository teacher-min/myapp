package com.gdu.myapp.listener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gdu.myapp.mapper.UserMapper;

@Component
public class MyHttpSessionListener implements HttpSessionListener {

  // 나중에 세션 리스너를 이용해서 동시 로그인 차단 기능을 구현하면 될 듯...
  
  // 세션 만료 시 자동으로 동작
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    
    // HttpSession
    HttpSession session = se.getSession();
    
    // ApplicationContext
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
    
    // session_id
    String sessionId = session.getId();
    
    // getBean()
    // Service 를 추천하나, Mapper 도 가능
    UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);
    
    // updateAccessHistory()
    userMapper.updateAccessHistory(sessionId);
    
    // 확인 메시지
    // System.out.println(sessionId + " 세션 정보가 소멸되었습니다.");
    
  }
  
}
