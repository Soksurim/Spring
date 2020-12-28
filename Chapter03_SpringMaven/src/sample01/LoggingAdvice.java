package sample01;

import java.text.DecimalFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StopWatch;

//공통관심사항, 공통모듈, 부가기능, Aspect
@Aspect // 공통모듈이라고 xml에 알림
@ComponentScan("spring.conf")
public class LoggingAdvice {
	
	@Before("execution(public void *.*.*Before(..))")
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))" )
	public void afterTrace() {
		System.out.println("after trace...33");
	}
	
	@Around("execution(public * *.*.*Print*(..))")
	public void aroundTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		//공통
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = "+ methodName);
		System.out.println("joinPoint = "+ joinPoint);
		System.out.println("joinPoint.getSignature() = "+ joinPoint.getSignature());
		System.out.println("joinPoint.getSignature().toShortString() = "+ joinPoint.getSignature().toShortString());
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("앞");
		// 핵심 관심사항 호출
		Object ob = joinPoint.proceed();
		System.out.println("# 핵심 리턴 : " + ob);
		System.out.println("뒤");
		
		// 공통
		sw.stop();
		System.out.println("처리시간 : " + new DecimalFormat("#,###ms").format( sw.getTotalTimeMillis()));
	}
}
