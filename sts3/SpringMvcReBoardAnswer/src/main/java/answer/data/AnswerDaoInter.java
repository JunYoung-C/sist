package answer.data;

import java.util.List;

public interface AnswerDaoInter {

	public void insertAnswer(AnswerDto dto);
	public List<AnswerDto> getAnswerList(int num);
}
