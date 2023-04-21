package com.daedalus.auth.service;

import com.daedalus.auth.payload.LoginDto;
import com.daedalus.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
