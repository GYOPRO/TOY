package community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {

	@Autowired
	@Qualifier("commuservice")
	CommunityService commuserive;
	
	@GetMapping("/community")
	public ModelAndView communityListPaging(@RequestParam(value="page",defaultValue = "1") int page,HttpServletRequest request) {
		int totalPage = commuserive.countroom(); //전체 게시물 수 조회
		List<CommunityDTO> communityListPaging = commuserive.limitCommunity(page);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPage", totalPage);
		mv.addObject("boardlist",communityListPaging);
		
		mv.setViewName("community/main");
		return mv;
	}
	
	@RequestMapping("/game")
	public ModelAndView gameroom(@RequestParam(value="g_seq") int g_seq, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		String player = (String)session.getAttribute("m_id");
		session.setAttribute("m_id",player );
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/gameroom");
		return mv;
	}
	
}




