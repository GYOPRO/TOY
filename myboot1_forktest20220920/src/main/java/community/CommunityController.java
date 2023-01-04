package community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {

	@GetMapping("/community")
	public ModelAndView communityListPaging() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sda", "asd");
		mv.setViewName("community/main");
		return mv;
	}
	
}




