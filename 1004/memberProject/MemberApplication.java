package kr.ac.kopo.memberProject;

import kr.ac.kopo.memberProject.ui.MemberView;
import kr.ac.kopo.memberProject.service.MemberService;
import kr.ac.kopo.memberProject.service.MyMemberService;

public class MemberApplication {

    public static void main(String[] args) {
        MemberView view = new MemberView();
        MemberService service = new MyMemberService();

        while(true) {
            System.out.println("**** 회원 관리 시스템 ****");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("3. 로그아웃");
            System.out.println("4. 회원 정보 조회");
            System.out.println("5. 회원 탈퇴");
            System.out.println("0. 종료");
            
            int no = view.scanInt("메뉴 번호를 입력하세요 : ");

            switch(no) {
                case 1:
                    Member member = view.inputMember();
                    service.regist(member);
                    break;
                case 2:
                    String loginId = view.scanStr("아이디: ");
                    String loginPw = view.scanStr("비밀번호: ");
                    service.login(loginId, loginPw);
                    break;
                case 3:
                    String logoutId = view.scanStr("로그아웃할 아이디: ");
                    service.logout(logoutId);
                    break;
                case 4:
                    String infoId = view.scanStr("조회할 아이디: ");
                    String infoPw = view.scanStr("비밀번호: ");
                    service.info(infoId, infoPw);
                    break;
                case 5:
                    String removeId = view.scanStr("탈퇴할 아이디: ");
                    service.remove(removeId);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
            }
        }
    }
}