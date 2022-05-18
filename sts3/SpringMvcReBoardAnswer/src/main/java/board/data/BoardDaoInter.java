package board.data;

import java.util.List;

public interface BoardDaoInter {
	 public int getTotalCount();
	 public int getMaxNum();
	 public void updateRestep(int regroup,int restep);
	 public void insertReboard(BoardDto dto);
	 public List<BoardDto> getList(int start,int perpage);
	 public void updateReadCount(int num);
	 public BoardDto getData(int num);
	 public int getCheckPass(String num,String pass);
	 public void updateBoard(BoardDto dto);
	 public void deleteBoard(int num);
}
