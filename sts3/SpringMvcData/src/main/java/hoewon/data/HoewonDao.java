package hoewon.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class HoewonDao extends SqlSessionDaoSupport implements HoewonDaoInter {

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfHoewon");
	}

	@Override
	public void insertHoewon(HoewonDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfHoewon", dto);
	}

	@Override
	public List<HoewonDto> getAllDatas() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllOfHoewon");
	}

}
