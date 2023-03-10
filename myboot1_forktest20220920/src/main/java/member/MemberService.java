package member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("memberservice")
public class MemberService  {
	
	@Autowired
	@Qualifier("memberdao")
	MemberDAO dao;

	@Autowired
	SqlSession session;
	
	// 회원가입
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}
	
	//회원가입확인
	public String insertCheck(MemberDTO dto) {
		return dao.insertCheck(dto);
		 
	}
	
	//회원정보조회
	public MemberDTO selectOneMember(String m_id) {
		return dao.selectOneMember(m_id);
	}

	//회원정보 수정
	public void updateMember(MemberDTO dto) {
		dao.updateMember(dto);
	}
	
	//아이디체크
	public int checkId(String m_id) {
		int cnt = dao.checkId(m_id);
		return cnt;
	}
	
	public int checkNick(String nickname) {
		int cnt = dao.checkNick(nickname);
		return cnt;
	}
	
	//회원정보삭제
	public void deleteMember(String m_id) {
		 dao.deleteMember(m_id);
	}
	
	//회원 리스트 조회(가입일자순)
	public List<MemberDTO> selectMemberList(){
		return dao.selectMemberList();
	}
	
	//회원 리스트 조회(아이디 순)
	public List<MemberDTO> selectMemberListId(){
		return dao.selectMemberListId();
	}
	
	//회원 리스트 조회(이름 순)
	public List<MemberDTO> selectMemberListName(){
		return dao.selectMemberListName();
	}
	
	//관리자 회원정보 수정
	public void updateMemberByAdmin(MemberDTO dto) {
		dao.updateMemberByAdmin(dto);
	}
	//관리자 회원정보 수정
	public void deleteMemberByAdmin(String m_id) {
		dao.deleteMemberByAdmin(m_id);
		}
	
	//회원 리스트 조회(일반 회원 조회)
	public List<MemberDTO> selectUserList(){
		return dao.selectUserList();
	}
	
	//일반 회원 등급 변경
	public void updateUserRole(MemberDTO dto) {
		dao.updateUserRole(dto);
	}
	
	public void updateDate(String m_id,String period) {
		dao.updateDate(m_id, period);
	}
	
}
