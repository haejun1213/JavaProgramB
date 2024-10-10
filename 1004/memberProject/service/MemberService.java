package kr.ac.kopo.memberProject.service;

import kr.ac.kopo.memberProject.Member;

public interface MemberService {
	void regist(Member member);
	void remove(String id);
	void login(String id, String password);
	void logout(String id);
	void info(String id, String password);
}
