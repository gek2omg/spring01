package com.example.spring01.userTest;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring01.userTest.dto.LoginListDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {
	
	@Autowired
    private LoginRepository memberRepository;
	
	public boolean loginProc(String username, String password) throws LoginException {
        LoginListDto loginListDto = memberRepository.searchUserIdV1(username);
        
        if (loginListDto == null) {
            return false;
        }

        if (!loginListDto.getPassword().equals(password)) {
            return false;
        }
		return true;

        // Login successful
        // Add your own logic here for handling the login process
    }

}
