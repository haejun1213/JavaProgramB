package kr.ac.kopo.memberProject.dao;

import kr.ac.kopo.memberProject.Member;

public interface MemberDAO {
    int insert(Member member);
    int delete(String id);
    Member select(String id);
    int update(Member member);
    boolean exists(String id);
}