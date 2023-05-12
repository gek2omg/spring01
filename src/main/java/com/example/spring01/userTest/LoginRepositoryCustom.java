package com.example.spring01.userTest;

import java.util.List;

import com.example.spring01.userTest.dto.LoginListDto;

public interface LoginRepositoryCustom {

	LoginListDto searchUserIdV1(String userId);
}
