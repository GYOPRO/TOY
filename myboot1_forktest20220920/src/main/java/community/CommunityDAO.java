package community;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //매퍼객체 사용 인식
@Repository("commudao") //new 객체생성
public interface CommunityDAO {
	
}
