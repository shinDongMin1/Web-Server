package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component // 컴포넌트 스캔할때 인식(bean방식X)
@Aspect // AOP로 인식
public class TimeTraceAop {

    //@Around("execution(* hello.hellospring..*(..))) // 타겟을 설정한다-aop 기술(bean방식X)
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)") // (bean방식)

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed(); // 실제 서비스가 실행된다.
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }

    }
}
// 위에 코드는 프록시라는 기술로 공통+핵심을 합친 코드로 스프링 bean에 등록되며 리턴할때 joinPoint.proceed()으로 핵심 관련사항 코드가 실행
