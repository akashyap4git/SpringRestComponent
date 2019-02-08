package com.ak4.rest;

import com.ak4.exception.UserAlreadyExistException;
import com.ak4.facade.MemberFacade;
import com.ak4.schema.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service/myapp")
public class MemberRestController {

    private final String MEM_ID = "memberId";

    @Autowired
    private MemberFacade memberFacade;

    Logger logger = LoggerFactory.getLogger(MemberRestController.class);

    @GetMapping("/fetchMember/{memberId}")
    public Member getMember(@PathVariable(MEM_ID) String memberId) {
        logger.info("Fetching Member Data By Member Id");
        return memberFacade.getMemberData(memberId);
    }

    @PostMapping("/createMember")
    public Member createMember(@RequestBody Member member) throws Exception {
        logger.info("Creating Member");
        boolean alreadyExist = checkCustomerAlreadyExist(member.getCredential().getUsername());
        if(alreadyExist) {
            throw new UserAlreadyExistException("Member is already exist with given username");
        }
        return memberFacade.createMemberData(member);
    }

    private boolean checkCustomerAlreadyExist(String username) {
        Member member = memberFacade.getMemberDataByUsername(username);
        boolean alreadyExist = false;
        if(member != null) {
            alreadyExist = true;
        }
        return alreadyExist;
    }
}

