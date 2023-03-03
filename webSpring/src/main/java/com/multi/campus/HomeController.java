package com.multi.campus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //annotation 흡사 클래스 -> Controller, RestController
public class HomeController {
		//데이터를 가져가야할 때 -> / , /test 방법
	@RequestMapping(value = "/", method = RequestMethod.GET) //get방식
	public String home(Model model) {
		//매개변수에 Model변수를 선언하고 Model에 필요한 데이터를 셋팅하면 뷰페이지에서 사용할 수 있다.
		model.addAttribute("num", 1234);
		model.addAttribute("name", "방탄소년단");
		return "home"; //home.jsp(뷰)로 페이지 이동
	}
	
	//	localhost:9090/campus/test?name=홍 -> request가 존재 그러므로 request객체 불러와야
	@RequestMapping("/test") //get방식일때는 생략가능
	public ModelAndView test(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("test(이름):"+ name);
		
		//modelandview클래스 객체만들기 (뷰로 안가고 다른 컨트롤러로 갈땐 이방법 only)
		//테이터와 뷰페이지 정보를 함께 가질 수 있는 클래스
		ModelAndView mav = new ModelAndView();
		
		//데이터셋팅
		mav.addObject("num", 5678);
		mav.addObject("name",name); //request한값
		
		//뷰페이지셋팅
		mav.setViewName("home"); //앞경로와 뒤 jsp생략(servlet-context.xml
		return mav;
	}
	//	localhost:9090/campus/test2?addr=서울시
	@RequestMapping("/test2")
	public ModelAndView test2(String addr) { //변수를 같은 이름으로 넣어줬더니 request안해도 바로 변수안에 넣으면 됌 자동으로 서버로 데이터를 가져가는 역할 (by괄호안의 매개변수)
		System.out.println("test2(주소):"+addr);
		
		// /test2를 처리한 후(접속) /test3매핑주소로 이동하도록하기
		//매핑에서 다른 매핑으로 이동하는 방법
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("num",9999);
		mav.addObject("name","손흥민");
		//						 접속할 다른 컨트롤러 매핑주소를 기술한다.
		mav.setViewName("redirect:test3");
		return mav; // /test3로
	}
	
	//	localhost:9090/campus/test3?num=120&name=세종대왕
	//dto의 변수가 정수형이면 문자열을 request하여 정수형으로 형변환해준다.
	@RequestMapping("/test3")
	//public String test3(int num, String name) { //메소드명이 test3아니여도됨
	public String test3(TestDTO dto, Model model) { //dto안에 num, name 존재 같은 변수명만 request해서 담아
		System.out.println("num->"+(dto.getNum()+1000));
		System.out.println(dto.toString()); //손흥민이 콘솔에 찍힘 by test2 //한글이 깨짐
		
		model.addAttribute("num",7777);
		model.addAttribute("name","박지성");
		return "home";
	}
	//	localhost:9090/campus/test4?tel=010-1234-5678
	//@PostMapping("/test4")
	@GetMapping("/test4") //get방식만
	public String test4(String tel) {
		System.out.println("test4(연락처):"+tel);
		return "home";
	}
}
