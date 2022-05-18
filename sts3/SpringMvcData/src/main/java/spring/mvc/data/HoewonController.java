package spring.mvc.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hoewon.data.HoewonDaoInter;
import hoewon.data.HoewonDto;

@Controller
public class HoewonController {

	@Autowired
	HoewonDaoInter dao;
	
	@GetMapping("/hoewon/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		int totalCount=dao.getTotalCount(); //전체개수
		List<HoewonDto> list=dao.getAllDatas(); //전체멤버
		
		model.addObject("totalCount", totalCount);
		model.addObject("list", list); 
		model.setViewName("hoewon/hlist");
		return model;
	}
	
	@GetMapping("/hoewon/form")
	public String form()
	{
		return "hoewon/hform";
	}
	
	@PostMapping("/hoewon/insert")
	public String insert(@ModelAttribute HoewonDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session)
	{
		
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		String photo="";
		//사진선택 안하면 no,했을경우..
		if(upload.getOriginalFilename().equals(""))
			photo="no";
		else {
			
			String fName=upload.getOriginalFilename();
			photo=fName;
			
			//업로드
			try {
				upload.transferTo(new File(path+"\\"+photo));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//insert전에 dto의 photo에 넣어주기
		dto.setPhoto(photo);
		
		//insert
		dao.insertHoewon(dto);
		
		return "redirect:list";
	}
	
}
