package user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		
		System.out.println("1. 이름으로 검색");
		System.out.println("2. 아이디로 검색");
		System.out.println("번호 입력");
		
		Scanner scan =  new Scanner(System.in);
		int num = scan.nextInt();
			
		String value = null;
		String check =null;

		switch(num){
			case 1 : System.out.println("찾고자 하는 이름 입력:");
					 value = scan.next();
					check ="name";
					 break;
			case 2 : System.out.println("찾고자 하는 아이디 입력:");
					 value = scan.next();
					check ="id";
					 break;
			default : System.out.println("1~2사이의 숫자 입력");
		}
			
		Map <String, String> map = new HashMap<String, String>();
		map.put("value",value);
		map.put("check",check);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		if(list.size()==0) System.out.println("찾으시는 값이 없습니다.");
		else {
			System.out.println("이름\t아이디\t패스워드");
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
			}
		}
	}
	

}
