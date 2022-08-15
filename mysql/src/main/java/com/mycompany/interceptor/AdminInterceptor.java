package com.mycompany.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mycompany.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req,
				HttpServletResponse res, Object obj) throws Exception {

		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");

		/* 현재의 세션을 불러와 session에 저장 후 member라는 명칭의 세션을 불러와 MemberVO의 형태로 변환 후 MemberVo
		   형태의 변수인 member에 저장 */
		
		if(member == null) {
			res.sendRedirect("/member/signin");
			return false;
		}


		if(member.getVerify() != 9) {
			res.sendRedirect("/");
			return false;
		}
		
		/* 조건문 사용으로 member에 값이 없는 비 로그인 상태와 member.verify의 값이 9가 아닐 경우 조건문의 내부 실행
		   조건문 내부는 가장 처음 화면으로 되돌리는 역할, false 반환 */
		   
		return true;
		
		// preHandle은 반환값이 true면 컨트롤러로 진행, false면 진행 멈춤
	}
} 