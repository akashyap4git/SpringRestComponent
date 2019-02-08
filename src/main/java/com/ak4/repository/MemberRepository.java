package com.ak4.repository;

import com.ak4.entity.MemberEntity;
import com.ak4.schema.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    String USERNAME = "username";

    @Query("select account from MemberEntity account, CredentialEntity cred where account.credentialEntity.credId = cred.credId and cred.username = :username")
    MemberEntity findByUsername(@Param(USERNAME) String username);

}
