package member;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	//로그인 페이지
		@RequestMapping("/login")
		public String loginform() {
			return "member/login";
		}
	//콜백 페이지 페이지
		@RequestMapping("/callback")
		public String callbackform() {
			return "member/callback";
		}
				
	//로그인 페이지
		@RequestMapping("/login2")
		public String loginform2() {
			return "member/login2";
		}
				
	//로그인
		@PostMapping("/loginprocess")
		public ModelAndView login_check(@ModelAttribute MemberDTO dto, HttpSession session, HttpServletRequest request) {
			String name = service.insertCheck(dto);
			MemberDTO m_dto = service.selectOneMember(dto.getId());
			ModelAndView mv = new ModelAndView();
			session = request.getSession();
			
			if (name != null) { // 로그인 성공 시
				session.setAttribute("m_id", dto.getId());
				session.setAttribute("nick", m_dto.nickname);
				mv.setViewName("main/index");
			} else { // 로그인 실패 시
				mv.setViewName("member/login");
				mv.addObject("message", "error");
			}
			return mv;
		}
		
	//로그아웃
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.invalidate();
			return "main/index";
		}
		
	 
	//회원가입폼 이동
		@GetMapping("/signin")
		public String signin() {
			return "member/singinform";
		}
		

	//회원가입
	      @RequestMapping(value = "/signin", method = RequestMethod.POST)
	      public String insertMember(MemberDTO dto) throws Exception{
	            service.insertMember(dto);
	            

	            return "main/index";
	      }
	 //idcheck
		
	//마이페이지 접속
		@RequestMapping("/mypage")
		public String mypage(HttpServletRequest request,String m_id,Model model) throws Exception{
			
			
			HttpSession session = request.getSession();
			m_id = (String)session.getAttribute("m_id");
			MemberDTO mdto = service.selectOneMember(m_id);


			return "member/mypage";
		}
		
	//회원정보수정 폼
		@RequestMapping("/updateform")
		public ModelAndView updateMember(String m_id, HttpServletRequest request) {
			HttpSession session = request.getSession();
			m_id = (String)session.getAttribute("m_id");
			MemberDTO dto = service.selectOneMember(m_id);
			ModelAndView mv = new ModelAndView();
			mv.addObject("memberdto",dto);
			mv.setViewName("member/updateform");
			return mv;
		}
	// 회원정보수정
		@PostMapping("/updatemember")
		public String updateBoard(MemberDTO dto) {
			service.updateMember(dto);
			return "member/mypage";
		}
		
	//아이디중복확인
		@RequestMapping("/idCheck")
		@ResponseBody
		public int idCheck(@RequestParam("m_id") String m_id) {
			int cnt = service.checkId(m_id);
			return cnt;
		}
	//닉네임 중복확인
		@RequestMapping("/nickCheck")
		@ResponseBody
		public int nickCheck(@RequestParam("nickname") String nickname) {
			int cnt = service.checkNick(nickname);
			System.out.println(cnt);
			return cnt;
		}
		
	//회원탈퇴
		@RequestMapping("/deletemember")
		public String deleteprocess(String m_id, HttpServletRequest request) {
			HttpSession session = request.getSession();
			m_id = (String) session.getAttribute("m_id");
			service.deleteMember(m_id);
			session.invalidate();
			return "main/index";
		}
		
	//회원 리스트 불러오기(가입일자 순)
		@RequestMapping("/memberlist")
		public ModelAndView memberlist() throws Exception {
			List<MemberDTO> memberlist = service.selectMemberList();
			ModelAndView mv = new ModelAndView();
			mv.addObject("memberlist",memberlist);
			mv.setViewName("admin/memberlist");
			return mv;
		}
		
	//회원 리스트 불러오기(id 순)
		@RequestMapping("/memberlistid")
		public ModelAndView memberlistId() throws Exception {
			List<MemberDTO> memberlist = service.selectMemberListId();
			ModelAndView mv = new ModelAndView();
			mv.addObject("memberlist",memberlist);
			mv.setViewName("admin/memberlist");
			return mv;
		}
		
	//회원 리스트 불러오기(이름 순)
		@RequestMapping("/memberlistname")
		public ModelAndView memberlistName() throws Exception {
			List<MemberDTO> memberlist = service.selectMemberListName();
			ModelAndView mv = new ModelAndView();
			mv.addObject("memberlist",memberlist);
			mv.setViewName("admin/memberlist");
			return mv;
		}
		
	// 관리자 회원 수정
		@PostMapping("/updateMemberByAdmin")
		public String updateMemberByAdmin(MemberDTO dto) {
			service.updateMemberByAdmin(dto);
			return "redirect:/memberlist";
		}
	// 관리자 회원 탈퇴
		@PostMapping("/deleteMemberByAdmin")
		public String deleteMemberByAdmin(MemberDTO dto) {
			service.deleteMemberByAdmin(dto.id);
			return "redirect:/memberlist";
		}
		
	//회원 리스트 불러오기(일반회원)
		@RequestMapping("/userlist")
		public ModelAndView userlistName() throws Exception {
			List<MemberDTO> userlist = service.selectUserList();
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("memberlist",userlist);
			mv.setViewName("admin/userlist");
			return mv;
		}
	//일반 회원 등급 변경
		@PostMapping("/updateUserRole")
		public String updateUserRole(MemberDTO dto) {
			service.updateUserRole(dto);
			return "redirect:/userlist";
		}

}

