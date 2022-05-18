package hoewon.data;

import java.util.List;


public interface HoewonDaoInter {

	public int getTotalCount();
	public void insertHoewon(HoewonDto dto);
	public List<HoewonDto> getAllDatas();
}
