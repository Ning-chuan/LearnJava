package dao;

import orm.RowMapper;
import orm.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoardDao {

    private SqlSession sqlSession = new SqlSession();

    /*
    public List<Board> selectAllParentBoards(){
        String sql = "select * from t_board where parentId is null ";
        String sql2 = "select * from t_board where parentId=?";
        RowMapper rm = new RowMapper() {
            @Override
            public Object mapperRow(ResultSet rs) throws SQLException {
                Board board = new Board();
                board.setId(rs.getInt("id"));
                board.setBoardName(rs.getString("boardName"));
                return board;
            }
        };

        List<Board> parentBoards = sqlSession.selectList(sql,rm,new Object[]{});
        for(int i=0;i<parentBoards.size();i++){
            Board parentBoard = parentBoards.get(i);
            List<Board> childrenBoards = sqlSession.selectList(sql2,rm,new Object[]{new Integer(parentBoard.getId())});

            parentBoard.setChildren(childrenBoards);



        }



        return parentBoards;
    }
     */


}
