package kr.ac.kopo.memberProject.service;

import java.util.HashMap;
import java.util.Map;
import kr.ac.kopo.memberProject.Member;
import kr.ac.kopo.memberProject.dao.MemberDAO;
import kr.ac.kopo.memberProject.dao.MyMemberDAO;

public class MyMemberService implements MemberService {
	private MemberDAO memberDAO;
	private Map<String, Member> memberList;

	public MyMemberService() {
		this.memberDAO = new MyMemberDAO();
		this.memberList = new HashMap<>();
	}

	@Override
	public void regist(Member member) {
		if (memberDAO.exists(member.getId())) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}

		System.out.println(memberDAO.insert(member) == 1 ? "회원 가입이 완료되었습니다." : "회원 가입에 실패하였습니다.");
	}

	@Override
	public void remove(String id) {
		if (!memberDAO.exists(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if (memberDAO.delete(id) == 1) {
			memberList.remove(id);
			System.out.println("회원 탈퇴가 완료되었습니다.");
		} else {
			System.out.println("회원 탈퇴에 실패하였습니다.");
		}

	}

	@Override
	public void login(String id, String password) {
		Member member = memberDAO.select(id);
		if (member == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if (!member.getPassword().equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		memberList.put(id, member);
		System.out.println("로그인되었습니다.");
	}

	@Override
	public void logout(String id) {
		if (!memberList.containsKey(id)) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		memberList.remove(id);
		System.out.println("로그아웃되었습니다.");
	}

	@Override
	public void info(String id, String password) {
		Member member = memberDAO.select(id);
		if (member == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if (!member.getPassword().equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.println("회원 정보:");
		System.out.println("ID: " + member.getId());
		System.out.println("이름: " + member.getName());
		System.out.println("주소: " + member.getAddr());
	}
}