package com.workintech.s19d2.service;
import com.workintech.s19d2.repository.MemberRepository;
import com.workintech.s19d2.entity.Member;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with this email!! -> " + email);
        }

        return memberOptional.get();
    }


}

