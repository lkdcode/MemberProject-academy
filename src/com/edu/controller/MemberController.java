package com.edu.controller;

import com.edu.dao.MemberDao;
import com.edu.entity.MemberEntity;
import com.edu.view.MemberView;

import java.util.List;

public class MemberController {

    // 필드로 dao, view

    public void getMemberList() {
        MemberDao memberDao = new MemberDao();
        List<MemberEntity> list = memberDao.getMemberList();

        MemberView memberView = new MemberView();
        memberView.getMemberList(list);

    }

    public void getMember(String name) {
        MemberDao memberDao = new MemberDao();
        MemberEntity member = memberDao.getMember(name);

        MemberView memberView = new MemberView();
        memberView.getMember(member);
    }

    public void insertMember(MemberEntity ob) {
        MemberDao memberDao = new MemberDao();
        int n = memberDao.insertMember(ob);

        MemberView memberView = new MemberView();
        memberView.insertMember(n);
    }

    public void deleteMember(String name) {
        MemberDao memberDao = new MemberDao();
        int n = memberDao.deleteMember(name);

        MemberView memberView = new MemberView();
        memberView.deleteMember(n);
    }
}
