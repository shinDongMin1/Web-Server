package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
// 스프링이 내장톰켓서버와 컨테이너를 만듬 그리고 컨테이너 안에 컨트롤러(외부), 서비스(비지니스), 리포지포리(DB)등 빈을 등록
// 스프링 빈등록: 1.컴포넌트 스캔과 자동 의존관계 설정(@Component) 2.자바 코드로 직접 스프링 빈 등록(콜백함수 등록이랑 비슷)
// 멤버컨트롤러, 의존관계 설정 후 
// 홈컨트롤러로 시작페이지를 설정하는데 아무것도 없으면 정적파일이 웰컴페이즈로 되고 있다면 템플릿파일로 설정됨