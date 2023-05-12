package com.example.spring01.userTest;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.gateway.GatewayService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	 private final LoginService loginService;
	
    @GetMapping("/login")
    public String gatewayList(Model model) throws Exception {
    	
        return "user/login/login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId, 
                        @RequestParam("password") String password,HttpSession session) throws LoginException {
    	
    	boolean result = loginService.loginProc(userId,password);
    	
        // 로그인 처리 코드
        if(result == true) {
        	session.setAttribute("LoggedIn", true);
        	return "redirect:/user/test"; // 로그인 후 리다이렉트할 페이지 경로
        }
        return "user/login/login";
    }    
}
