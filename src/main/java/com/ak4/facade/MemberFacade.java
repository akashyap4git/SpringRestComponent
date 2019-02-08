package com.ak4.facade;

import com.ak4.schema.Member;
import com.ak4.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberFacade {

    @Autowired
    private MemberService memberService;

    public Member getMemberData(String memberId) {
        return memberService.getMemberDataService(memberId);
    }

    public Member getMemberDataByUsername(String username) {
        return memberService.getMemberDataServiceForUsername(username);
    }

    public Member createMemberData(Member member) {
        return memberService.createMemberDataService(member);
    }
}
