package kr.ac.kopo.memberProject.ui;

import java.util.Scanner;

import kr.ac.kopo.memberProject.Member;

public class MemberView {

	private Scanner sc;

	public MemberView() {
		this.sc = new Scanner(System.in);
	}
	
	public int scanInt(String msg) {
		return Integer.parseInt(scanStr(msg));
	}
	
	public String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	public Member inputMember() {
	    String id = scanStr("아이디: ");
	    String password = scanStr("비밀번호: ");
	    String name = scanStr("이름: ");
	    String addr = scanStr("주소: ");
	    
	    return new Member(id, password, name, addr);
	}
}
