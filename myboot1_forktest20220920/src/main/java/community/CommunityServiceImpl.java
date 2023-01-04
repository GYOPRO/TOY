package community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commuservice")
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	CommunityDAO dao;
	
	

}

