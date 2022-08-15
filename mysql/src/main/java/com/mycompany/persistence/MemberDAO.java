package com.mycompany.persistence;

import com.mycompany.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void signup(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO signin(MemberVO vo) throws Exception;

}


// 관리 qq@qq 1234 12 34 
// 사용 qq@qq2 12344 122 344