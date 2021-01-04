package user.aop;

import java.text.DecimalFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StopWatch;

//공통관심사항, 공통모듈, 부가기능, Aspect
@Aspect
@ComponentScan("user.*")
public class LoggingAdvice {
	
	@Before("execution(public void *.*.*Before(..))")
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))" )
	public void afterTrace() {
		System.out.println("after trace...33");
	}

	@Around("execution(void user.service.*.execute())")
	public void read(ProceedingJoinPoint joinPoint) throws Throwable {
		// 공통
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("핵심코드 작동 전");
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = " + methodName);
		System.out.println("-----------------------------");
		System.out.println();

		StopWatch sw = new StopWatch();
		sw.start(methodName);

		// 핵심 관심사항 호출
		joinPoint.proceed();

		// 공통
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("핵심코드 작동 후");
		sw.stop();
		System.out.println("처리시간 : " + new DecimalFormat("#ms").format(sw.getTotalTimeMillis()));
		System.out.println("-----------------------------");
		System.out.println();
	}
	
	
}
