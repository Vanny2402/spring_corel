package com.vn.learn_springboot.service.util;

import com.vn.learn_springboot.dto.LoginDTO;
import com.vn.learn_springboot.model.request.LoginFormRequest;

public class Mapper {

	public static LoginDTO toLoginForm(LoginFormRequest loginForm) {
		
		LoginDTO dto=new LoginDTO() ;
		dto.setUserName(loginForm.getUserName().toUpperCase());
		return dto;
		
	
	}
}
