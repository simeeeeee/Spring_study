package com.multi.campus.service;

import com.multi.campus.dto.RegisterDTO;

public interface RegisterService {
	//RegisterDAO에 있는 메소드와 동일하게 복붙
	public RegisterDTO loginOk(String userid, String userpwd);
}
