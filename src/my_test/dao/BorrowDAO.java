package my_test.dao;


import util.DatabaseUtil;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowDAO {

    // 도서 대출을 처리 기능
    public void borrowBook(int bookId,int studentPK) throws SQLException{
        // 대출 가능 여부 ---SELECT
        // 대출 가능 하다면 --> INSERT(borrows)
        // 대출이 실행 되었다면 --> UPDATE (books -> available)

        String checkSql = "select available from books where id = ? ";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement checkPstmt = conn.prepareStatement(checkSql)) {
            checkPstmt.setInt(1,bookId);
            ResultSet rs1 = checkPstmt.executeQuery();
            if (rs1.next() && rs1.getBoolean("available")) {
                // insert, update
                String insertSql = "insert into borrows (student_id,book_id,borrow_date) \n" +
                        "values (?,?,current_date) ";
                
            }
        }
    }
}
