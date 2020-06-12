package dao;

import domain.Board;
import domain.Post;
import orm.BBSConstants;
import orm.RowMapper;
import orm.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostDao {

    private SqlSession sqlSession = new SqlSession();



    //获取总记录个数的方法  指定板块（不包括置顶帖子）
    private int getTotalRecord(int boardId){
        String sql = "SELECT COUNT(*) FROM T_POST WHERE BOARDID = ? AND STATUS != '置顶'";
        int totalRecord = sqlSession.selectOne(sql,(rs) -> rs.getInt(1),new Object[]{boardId});
        System.out.println(totalRecord);
        return totalRecord;
    }
    //获取总页数的方法  公有方法 供servlet使用
    public int getTotalPage(int boardId){
        int totalRecord = this.getTotalRecord(boardId);
        int pageSize = BBSConstants.PAGE_SIZE;
        //pageSize-1 理解为 totalRecord/pageSize 的最大余数
        int totalPage = (totalRecord + pageSize-1)/pageSize;
        return totalPage;
    }
    //纠正页码的方法   公有方法 供servlet使用
    public int correctPage(int pageNo,int totalPage){
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > totalPage){
            pageNo = totalPage;
        }
        return pageNo;
    }


    RowMapper rm = new RowMapper() {
        @Override
        public Object mapperRow(ResultSet rs) throws SQLException {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            post.setDate(rs.getDate("date"));
            post.setStatus(rs.getString("status"));
            post.setBoard(new Board(rs.getInt("boardId"),null,null,null));
            return post;
        }
    };

    public List<Post> queryTopPosts(int boardId) {
        String sql = "SELECT * FROM T_POST WHERE BOARDID = ? AND STATUS = '置顶' ORDER BY DATE DESC";

        List<Post> topPosts = sqlSession.selectList(sql, rm, new Object[]{boardId});
        return topPosts;
    }

    public List<Post> queryOtherPosts(int boardId,int pageNo) {
        String sql = "SELECT * FROM T_POST WHERE BOARDID = ? AND STATUS != '置顶' ORDER BY DATE DESC LIMIT ?,?";
        //pageNo = this.correctPage(pageNo);//页码校验
        List<Post> otherPosts = sqlSession.selectList(sql, rm, new Object[]{boardId, BBSConstants.PAGE_SIZE*(pageNo-1),BBSConstants.PAGE_SIZE});
        return otherPosts;
    }
}
