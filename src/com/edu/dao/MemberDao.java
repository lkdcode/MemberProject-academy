package com.edu.dao;

import com.edu.entity.MemberEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static common.MyConnectionPool.*;


public class MemberDao {

    public int insertMember(MemberEntity ob) {
        // 추가
        int n = 0;

        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO member VALUES(mp_idx.nextval, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ob.getName());
            pstmt.setString(2, ob.getPhone());

            n = pstmt.executeUpdate();

            if (n > 0) {
                commit(conn);
            }


        } catch (SQLException e) {

            rollback(conn);
            n = 0;
        } finally {
            close(conn);
            close(pstmt);
        }

        return n;
    }

    public int deleteMember(String name) {
        int n = 0;

        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM member WHERE name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            n = pstmt.executeUpdate();

            if (n > 0) {
                commit(conn);
            }

        } catch (SQLException e) {
            rollback(conn);
            n = 0;
        } finally {
            close(conn);
            close(pstmt);
        }

        return n;
    }

    public List<MemberEntity> getMemberList() {
        // 전체 조회
        List<MemberEntity> list = new ArrayList<>();

        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM member";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberEntity entity = new MemberEntity();
                entity.setName(rs.getString("name"));
                entity.setPhone(rs.getString("phone"));

                list.add(entity);
            }

        } catch (SQLException e) {

        } finally {
            close(conn);
            close(pstmt);
            close(rs);
        }


        return list;
    }

    public MemberEntity getMember(String name) {
        MemberEntity member = null;

        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM member WHERE name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                member = new MemberEntity();
                member.setName(rs.getString("name"));
                member.setPhone(rs.getString("phone"));
            }

        } catch (SQLException e) {
            member = null;
        } finally {
            close(conn);
            close(pstmt);
            close(rs);
        }

        return member;
    }

}
