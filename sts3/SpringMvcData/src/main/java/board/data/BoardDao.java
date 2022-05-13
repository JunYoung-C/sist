package board.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

	@Override
	public int getTotalCount() {
		return getSqlSession().selectOne("selectCountOfBoard");
	}

	@Override
	public void insertBoard(BoardDto dto) {
		getSqlSession().insert("insertOfBoard", dto);
	}

}
