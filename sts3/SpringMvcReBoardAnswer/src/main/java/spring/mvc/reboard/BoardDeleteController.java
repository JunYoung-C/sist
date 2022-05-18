package spring.mvc.reboard;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDaoInter;

@Controller
public class BoardDeleteController {

	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView deletePassForm(
			@RequestParam String num,
			@RequestParam String currentPage)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("board/deletepassform"); //jsp주소
		
		return model;
	}
	
	@PostMapping("/board/delete")
	public String delete(
			@RequestParam String num,
			@RequestParam String currentPage,
			@RequestParam String pass,
			HttpSession session)
	{
		//비번이 맞는지 체크
		int check=dao.getCheckPass(num, pass);
		
		if(check==0) { //비번이 틀림
			
			return "board/passfail";
		}else { //비번이 맞는경우
			
			//포토폴더 사진지우기
			String photo=dao.getData(Integer.parseInt(num)).getPhoto();
			if(!photo.equals("no")) {
				//,로분리
				String [] fName=photo.split(",");
				
				//실제업로드 경로
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				System.out.println(path);
				
				for(String f:fName)
				{
					File file=new File(path+"\\"+f);
					file.delete();
				}
			}
		}
		
		//db삭제
		dao.deleteBoard(Integer.parseInt(num));
		
		return "redirect:list?currentPage="+currentPage;
	}
}
