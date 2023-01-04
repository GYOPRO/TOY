package community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("commuservice")
public class CommunityService {

	@Autowired
	@Qualifier("commudao")
	CommunityDAO dao;
	
	// 전체 방 개수 조회
	public int countroom() {
		return dao.countroom();
	}
	
	// 페이징(최신순)
	public List<CommunityDTO> limitCommunity(int page){
		int limit = (page - 1) * 16;
		return dao.limitCommunity(limit);
	}
	
	
	
}
