package community;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //매퍼객체 사용 인식
@Repository("commudao") //new 객체생성
public interface CommunityDAO {
	
	// 전체 방 개수 조회
	public int countroom();
	
	// 페이징(최신순)
	public List<CommunityDTO> limitCommunity(int page);
}
