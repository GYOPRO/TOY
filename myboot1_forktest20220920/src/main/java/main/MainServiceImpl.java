package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainservice")
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainDAO dao;
	
	

}

