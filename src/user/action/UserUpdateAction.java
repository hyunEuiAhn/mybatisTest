package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		UserDAO userDAO = UserDAO.getInstance();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 아이디를 입력하세요.");
		
		UserDTO userDTO = new UserDTO();
		String id = scan.next();
		userDTO = userDAO.check(id);

		if(id.equals(userDTO.getId())) {
			System.out.println(userDTO.getId()+" "+userDTO.getName()+" "+userDTO.getPwd());
			System.out.println("수정할 이름을 입력하세요.");
			String name = scan.next();
			System.out.println("수정할 비밀번호를 입력하세요.");
			String pwd = scan.next();
			
//			Map<String, String> map = new HashMap<String , String>();
//			map.put("name", name);
//			map.put("id", id);
//			map.put("pwd", pwd);
//			
//			userDAO.update(userDTO);
			
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			userDAO.update(userDTO);
			System.out.println("수정 완료.");
		}else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}

}
