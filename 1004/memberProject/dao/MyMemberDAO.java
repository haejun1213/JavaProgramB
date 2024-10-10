package kr.ac.kopo.memberProject.dao;

import kr.ac.kopo.memberProject.Member;
import kr.ac.kopo.memberProject.util.ConnectionFactory;
import kr.ac.kopo.memberProject.util.JDBCClose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyMemberDAO implements MemberDAO {
    
    @Override
    public int insert(Member member) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            String sql = "INSERT INTO members(id, password, name, addr) VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getAddr());
            int res = pstmt.executeUpdate();
            
            return res;
        } catch (Exception e) {
        } finally {
            JDBCClose.close(pstmt, conn);
        }
        return 0;
    }

    @Override
    public int delete(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM members WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            int res = pstmt.executeUpdate();
            return res;
        } catch (Exception e) {
        } finally {
            JDBCClose.close(pstmt, conn);
        }
        return 0;
    }

    @Override
    public Member select(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM members WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAddr(rs.getString("addr"));
            }
        } catch (Exception e) {
        } finally {
            JDBCClose.close(pstmt, conn);
        }
        
        return member;
    }

    @Override
    public int update(Member member) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            String sql = "UPDATE members SET password = ?, name = ?, addr = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getAddr());
            pstmt.setString(4, member.getId());
            int res = pstmt.executeUpdate();
            return res;
        } catch (Exception e) {
        } finally {
            JDBCClose.close(pstmt, conn);
        }
        return 0;
    }

    @Override
    public boolean exists(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;
        
        try {
            conn = new ConnectionFactory().getConnection();
            String sql = "SELECT COUNT(*) FROM members WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (Exception e) {
        } finally {
            JDBCClose.close(pstmt, conn);
        }
        
        return exists;
    }
}