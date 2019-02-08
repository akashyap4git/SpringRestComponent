package com.ak4.service;

import com.ak4.entity.MemberEntity;
import com.ak4.mapper.MemberMapper;
import com.ak4.repository.MemberRepository;
import com.ak4.schema.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    public Member getMemberDataService(String memberId) {
        MemberEntity memberEntity = memberRepository.getOne(memberId);
        return memberMapper.from(memberEntity);
    }

    public Member createMemberDataService(Member member) {
        MemberEntity memberEntity = memberMapper.from(member);
        MemberEntity updatedMemberEntity = memberRepository.save(memberEntity);
        return memberMapper.from(updatedMemberEntity);
    }

    public Member getMemberDataServiceForUsername(String username) {
        MemberEntity memberEntity = memberRepository.findByUsername(username);
        return memberMapper.from(memberEntity);
    }
}
