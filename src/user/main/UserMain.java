package user.main;

import java.util.Scanner;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSearchAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;

public class UserMain {

	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
		System.out.println("종료");
	}

	private void menu() {
		Scanner scan = new Scanner(System.in);
		UserAction userAction = null;
		while(true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.검색");
			System.out.println("6.종료");
			System.out.println("----------");
			System.out.println("번호입력 :");
			
			int num=scan.nextInt();
			
			if(num==1) {
				userAction = new UserInsertAction();
			}else if(num==2) {
				userAction = new UserSelectAction();
			}else if(num==3) {
				userAction = new UserUpdateAction();
			}else if(num==4) {
				userAction = new UserDeleteAction();
			}else if(num==5) {
				userAction = new UserSearchAction();
			}else if(num==6) 
				break;
			else {
				System.out.println("1~6 사이의 값을 입력하세요");
				continue;
			}

			userAction.execute();
		}
		
	}

}
