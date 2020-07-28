package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction{
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 : ");
		String name = scan.next();
		
		System.out.println("아이디 입력하세요 : ");
		String id = scan.next();
		
		System.out.println("비밀번호 입력하세요 : ");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setName(name);
		userDTO.setPwd(pwd);

		//db
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.write(userDTO);
		
		if(su==1) {
			System.out.println("데이터 저장 완료");
		}else 
			System.out.println("데이터 저장 실패");
	}

}
