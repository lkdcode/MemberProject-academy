import com.edu.controller.MemberController;
import com.edu.entity.MemberEntity;

import java.util.Scanner;

public class MemberMain {
    private final Scanner scanner;
    private MemberController memberController;

    public MemberMain() {
        this.scanner = new Scanner(System.in);
        this.memberController = new MemberController();
    }

    public void menu() {
        //1.추가 2.삭제 3.전체보기 4.찾기 5.종료
        String name;
        String phone;

        while (true) {
            System.out.println("1.추가 2.삭제 3.전체보기 4.찾기 5.종료");
            System.out.print("선택 (1~5) : ");
            int inputMenuNumber = scanner.nextInt();

            switch (inputMenuNumber) {
                case 1:
                    // 추가

                    System.out.print("추가할 사람의 이름 : ");
                    name = scanner.next();
                    System.out.print("추가할 사람의 전화 : ");
                    phone = scanner.next();

                    MemberEntity memberEntity = new MemberEntity();
                    memberEntity.setName(name);
                    memberEntity.setPhone(phone);

                    memberController.insertMember(memberEntity);
                    break;

                case 2:
                    // 삭제
                    System.out.print("삭제할 사람 : ");
                    name = scanner.next();

                    memberController.deleteMember(name);

                    break;
                case 3:
                    // 전체보기

                    memberController.getMemberList();

                    break;
                case 4:
                    // 찾기
                    System.out.print("찾을 사람 : ");
                    name = scanner.next();

                    memberController.getMember(name);

                    break;
                case 5:
                    //종료
                    System.out.println("*** 작업 끝 ***");
                    return;
            }

        }

    }

    public static void main(String[] args) {
        new MemberMain().menu();
    }
}

