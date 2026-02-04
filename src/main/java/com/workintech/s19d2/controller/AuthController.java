package com.workintech.s19d2.controller;
import com.workintech.s19d2.service.AuthenticationService;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.dto.RegistrationMember;
import com.workintech.s19d2.dto.RegisterResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegistrationMember registrationMember) {
        Member member = authenticationService.register(
                registrationMember.email(),
                registrationMember.password()
        );

        return new RegisterResponse(member.getEmail(), "kayıt başarılı bir şekilde gerçekleşti.");
    }


}

