package user.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		new Main().menu(context);

	}
	
	private void menu(ApplicationContext context) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserService userService = null;
		int num;

		while (true) {
			
			System.out.println();
			System.out.println("―――――――――――――――――――――――");
			System.out.println("#   1. 입력");
			System.out.println("#   2. 출력");
			System.out.println("#   3. 수정");
			System.out.println("#   4. 삭제");
			System.out.println("#   5. 종료");
			System.out.println("―――――――――――――――――――――――");
			System.out.print("   번호 입력 : ");

			try {
				num = Integer.parseInt(br.readLine());

			} catch (IOException | NumberFormatException e) {
				System.out.println("똑바로 입력하쇼잉");
				num = 0;
			}

			if (num == 5)
				break;

			if (num == 1)
				userService = (UserService) context.getBean("userInsertService");
			else if (num == 2)
				userService = (UserService) context.getBean("userSelectService");
			else if (num == 3)
				userService = (UserService) context.getBean("userUpdateService");
			else if (num == 4)
				userService = (UserService) context.getBean("userDeleteService");
			else
				continue;
			
			

			userService.execute();

		} // while
	}

}
