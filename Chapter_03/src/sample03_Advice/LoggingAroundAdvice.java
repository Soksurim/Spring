package sample03_Advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//핵심 호출
		System.out.println("# 어라운드 입실체크 start");
		long start = System.currentTimeMillis();
		
		Object ob = invocation.proceed(); // 핵심코드
		
		System.out.println("# 어라운드 입실체크 end");
		long end = System.currentTimeMillis();
		
//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
		System.out.println("걸린 시간 : " + (long)(end - start));
		
		return ob;
	}

	
}
