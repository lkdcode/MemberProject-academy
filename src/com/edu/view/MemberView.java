package com.edu.view;

import com.edu.entity.MemberEntity;

import java.util.List;

public class MemberView {
    public void getMemberList(List<MemberEntity> list) {
        if (list.size() > 0) {
            for (MemberEntity entity : list) {
                System.out.println(entity.getName() + "\t" + entity.getPhone());
            }
        } else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }

    public void getMember(MemberEntity member) {
        if (member != null) {
            System.out.println(member.getName() + "\t" + member.getPhone());
        } else {
            System.out.println("찾는 사람이 없습니다.");
        }

    }

    public void insertMember(int n) {
        if (n > 0) {
            System.out.println(n + "건의 데이터가 추가되었습니다.");
        } else {
            System.out.println("데이터 추가에 실패하였습니다.");
        }
    }

    public void deleteMember(int n) {
        if (n > 0) {
            System.out.println(n + "건의 데이터가 삭제되었습니다.");
        } else {
            System.out.println("데이터 삭제에 실패하였습니다.");
        }
    }


}
