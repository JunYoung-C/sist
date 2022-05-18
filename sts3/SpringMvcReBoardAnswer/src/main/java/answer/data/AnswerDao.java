package answer.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AnswerDao extends SqlSessionDaoSupport implements AnswerDaoInter {

	@Override
	public void insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfReAnswer", dto);
	}

	@Override
	public List<AnswerDto> getAnswerList(int num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectNumOfReAnswer", num);
	}

}
