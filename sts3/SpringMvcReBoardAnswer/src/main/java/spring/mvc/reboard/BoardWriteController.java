package spring.mvc.reboard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDaoInter;
import board.data.BoardDto;

@Controller
public class BoardWriteController {

	@Autowired
	BoardDaoInter dao;
	
	//새글,답글 모두 해당
	@GetMapping("/board/writeform")
	public ModelAndView form(
			@RequestParam Map<String, String> map
			)
	{
		ModelAndView model=new ModelAndView();
		//아래 5개의 글은 답글일경우에만 넘어온다(새글은 안넘어옴)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String relevel=map.get("relevel");
		String restep=map.get("restep");
		
		System.out.println(currentPage+","+num);//새글인경우 null값 나옴
		//답글이면 숫자로 나옴
		
		//입력폼에 hidden으로 넣어줘야 함...답글일때 대비
		model.addObject("currentPage", currentPage==null?"1":currentPage);
		model.addObject("num", num==null?"0":num); //0이라야 dao에서 새글로 인식
		model.addObject("relevel", relevel==null?"0":relevel);
		model.addObject("regroup", regroup==null?"0":regroup);
		model.addObject("restep", restep==null?"0":restep);
		
		//0이라고 넣어야 새글로 인식하므로
		//폼이 새글,답글 공용이므로
		model.setViewName("board/writeform");
		return model;
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam int currentPage,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session)
	{
		//업로드할 실제경로
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		String photo="";
		
		//사진선택 안했을경우 no, 했을경우 ,로 나열
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fName=f.getOriginalFilename();
				photo+=fName+",";
				
				//업로드
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			//photo에서 마지막 컴마 제거
			photo=photo.substring(0, photo.length()-1);
		}
		
		//dto의 photo에 넣어주기
		dto.setPhoto(photo);
		
		//dao에서 insert호출
		dao.insertReboard(dto);
		
		//맥스넘 
		int num=dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+currentPage; 
		//content만든후 content로 이동하게 수정할예정
	}
	
	
}
