package com.multi.campus.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.multi.campus.dao.RegisterDAO;
import com.multi.campus.dto.RegisterDTO;

@Service  //어노테이션 덕에 controller에서 registerservice에서 상속된 요기를 자동으로 찾아올수있게됨
public class RegisterServiceImpl implements RegisterService {
//	오버라이딩 안해서 빨간줄
	//객체생성
	//	@AutoWired, @Inject : interface를 객체로 생성해주는 어노테이션
	@Inject
	RegisterDAO dao;
	
	@Override					//registermapper에서 #{param}으로 파라미터 들어가
	public RegisterDTO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid,userpwd); //-> 요기서 RegisterDAO호출해서 loginOk메소드 불러서 registermapper의 쿼리문 읽게
	}

}
