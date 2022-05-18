package board.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfBoard");
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfBoard", dto);
	}

	@Override
	public List<BoardDto> getAllDatas() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllOfBoard");
	}

	@Override
	public BoardDto getData(String num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneOfBoard", num);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfBoard", dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfBoard", num);
	}

	
}
