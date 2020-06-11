package dao;

import domain.Board;
import orm.RowMapper;
import orm.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    private SqlSession sqlSession = new SqlSession();

    public List<Board> selectAllParentBoards() {
        String sql = "SELECT ID,BOARDNAME,PARENTID FROM T_BOARD WHERE PARENTID IS NULL";
        String sql1 = "SELECT ID,BOARDNAME,PARENTID FROM T_BOARD WHERE PARENTID = ?";
        /*以前的写法：
        RowMapper rm = new RowMapper() {
            @Override
            public Object mapperRow(ResultSet rs) throws SQLException {
                //这个匿名内部类说明了每一条结果具体的处理方法
                Board board = new Board();
                board.setId(rs.getInt("id"));
                board.setBoardName(rs.getString("boardName"));
                return board;
            }
        };*/
        //现在的写法：
        RowMapper rm = rs -> {
            //这个匿名内部类说明了每一条结果具体的处理方法
            Board board = new Board();
            board.setId(rs.getInt("id"));
            board.setBoardName(rs.getString("boardName"));
            return board;
        };
        //查出所有父板块
        List<Board> parentBoards = sqlSession.selectList(sql, rm, new Object[]{});
        //遍历父板块 根据其id查出对应的子版块并赋值
        for(Board board:parentBoards){
            Integer id = board.getId();
            List<Board> children = sqlSession.selectList(sql1, rm, new Object[]{id});
            board.setChildren(children);
        }

        return parentBoards;
    }

}
