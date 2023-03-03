package com.multi.campus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.service.RegisterService;

@Controller
public class RegisterController {
	//서비스 객체만들기
	@Autowired
	RegisterService service; //loginOk메소드 존재(4시강의)//registerMepping의 registerDAO(에 담긴거
	//로그인폼
	@GetMapping("/loginForm")
	public String login() {
		return "register/loginForm"; // /WEB-INF/views/register/loginForm.jsp
	}
	//로그인 (DB)
	@PostMapping("/loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpServletRequest request, HttpSession session) { //loginForm.jsp에 있는 userid, userpwd가 들어감
		//Session 객체얻어오기
		//매개변수로 HttpServletRequest request -> Session구하기
		//매개변수로 HttpSession session
		
		System.out.println("userid->"+userid); //인코딩 잘 됐는지 확인 -> post방식 한글깨지는거 방지는 web.xml에 처리해서 다 처리되게설정(3.2 5시 15분)
		
		RegisterDTO dto = service.loginOk(userid, userpwd);
		// 아이디나 비번 없을시 dto->null인경우 선택레코드가 없다. - 로그인실패
		//						  이 아닌경우 선택레코드가 있다. - 로그인 성공
		ModelAndView mav = new ModelAndView();
		if(dto != null) {//로그인 성공
			//세션객체얻어오기
			session.setAttribute("logId", dto.getUserid());
			session.setAttribute("logName", dto.getUsername());
			session.setAttribute("logStatus", "Y");
			// home("/")으로 가게 처리
			mav.setViewName("redirect:/");
		}else {//로그인 실패
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	//로그아웃 - 세션제거
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//회원가입폼
	@GetMapping("/join")
	public String join() {
		return "register/join";
	}
	
	
}
