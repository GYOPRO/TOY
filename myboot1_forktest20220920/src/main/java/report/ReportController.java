package report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.*;

import comment.CommentDTO;
import comment.CommentService;
import community.CommunityDTO;
import community.CommunityService;
import member.MemberDTO;
import member.MemberService;
import member.couponDTO;

import product.ProductDTO;
import product.ProductServiceImpl;

@Controller
public class ReportController {
	@Autowired
	@Qualifier("commuservice")
	CommunityService commuserive;
	
	@Autowired
	@Qualifier("reportservice")
	ReportService service;
	
	
		//게시물 신고하기 폼
		@RequestMapping("report")
		public ModelAndView report(int s_seq) {
			CommunityDTO oneCommu = new CommunityDTO();
			oneCommu = commuserive.oneCommunity(s_seq);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("writer",oneCommu.getS_writer());
			mv.addObject("title",oneCommu.getS_title());
			mv.addObject("s_seq",oneCommu.getS_seq());
			mv.setViewName("community/report");
			return mv;
		}
		//신고하기
		@RequestMapping("reportss")
		public void reportss(ReportDTO dto){
			System.out.println(dto.s_seq);
			service.insertReport(dto);
		}
		
		//어드민 신고내역 보기
		@RequestMapping("reportlist")
		public ModelAndView reportlist() {
			List<ReportDTO> reportlist = service.reportlist();
			ModelAndView mv = new ModelAndView();
			mv.addObject("list",reportlist);
			mv.setViewName("admin/reportlist");
			System.out.println(reportlist.get(0));
			return mv;
			
		}
		// 신고받은 게시물 삭제
		@RequestMapping("deletereport")
		public void deletereport(int s_seq) {
			commuserive.deleteCommunity(s_seq);
		}
	
}