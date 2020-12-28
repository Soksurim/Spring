package sample01;

import java.text.DecimalFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통관심사항, 공통모듈, 부가기능, Aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace 작동");
	}

	public void afterTrace() {
		System.out.println("after trace 작동");
	}

	public void aroundTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		// 공통
		System.out.println("핵심코드 작동 전");
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 = " + methodName);

		StopWatch sw = new StopWatch();
		sw.start(methodName);

		// 핵심 관심사항 호출
		joinPoint.proceed();

		// 공통
		System.out.println("핵심코드 작동 후");
		sw.stop();
		System.out.println("처리시간 : " + new DecimalFormat("#ms").format(sw.getTotalTimeMillis()));
	}
}
