package answercontroller.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import answer.data.AnswerDaoInter;
import answer.data.AnswerDto;

@Controller
public class AnswerController {

	@Autowired
	AnswerDaoInter adao;
	
	@PostMapping("/board/ainsert")
	public String answerInser(
			@ModelAttribute AnswerDto dto,
			@RequestParam String currentPage
			)
	{
		
		//db에추가
		adao.insertAnswer(dto);
		//내용보기..num,currentPage
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
}
