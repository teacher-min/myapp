package com.gdu.myapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// war 파일로 배포할 것이라고 했기 때문에 생긴 파일이다. jar 파일 배포였다면 안 생긴다.
// 스프링 애플리케이션을 외장 톰캣으로 돌리려면 web.xml (Deployment Descriptor, DD)에 애플리케이션 컨텍스트를 등록해야만 한다.
// 그래야 톰캣이 /WEB-INF/web.xml 파일을 이용해서 애플리케이션을 구성한다. 
// Servlet 3.0 스펙 이후 /WEB-INF/web.xml 대신 WebApplicationInitializer 인터페이스를 구현하여 대신한다.
// SpringBootServletInitializer는 WebApplicationInitializer 인터페이스를 구현한 클래스이다.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyappApplication.class);
	}

}
