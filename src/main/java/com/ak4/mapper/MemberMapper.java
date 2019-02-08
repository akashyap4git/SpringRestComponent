package com.ak4.mapper;

import com.ak4.entity.AddressEntity;
import com.ak4.entity.CredentialEntity;
import com.ak4.entity.GenderEntity;
import com.ak4.entity.MemberEntity;
import com.ak4.schema.Address;
import com.ak4.schema.Credential;
import com.ak4.schema.Gender;
import com.ak4.schema.Member;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MemberMapper {

    public Member from(MemberEntity memberEntity) {
        Member member = new Member();
        Address address = new Address();
        address.setZipCode(memberEntity.getAddressEntity().getZipCode());
        address.setCity(memberEntity.getAddressEntity().getCity());
        address.setAddressId(memberEntity.getAddressEntity().getAddressId());
        address.setAddressLine1(memberEntity.getAddressEntity().getAddressLine1());
        address.setAddressLine2(memberEntity.getAddressEntity().getAddressLine2());
        address.setCountry(memberEntity.getAddressEntity().getCountry());
        address.setState(memberEntity.getAddressEntity().getState());
        Credential credential = new Credential();
        credential.setUsername(memberEntity.getCredentialEntity().getUsername());
        credential.setPassword(memberEntity.getCredentialEntity().getPassword());
        credential.setCredId(memberEntity.getCredentialEntity().getCredId());
        member.setCredential(credential);
        member.setAddress(address);
        member.setDateOfBirth(memberEntity.getDateOfBirth());
        member.setEmailId(memberEntity.getEmailId());
        member.setFirstName(memberEntity.getFirstName());

        GenderEntity genderEntity = GenderEntity.valueOf(memberEntity.getGenderEntity().name());
        Gender gender = Gender.fromValue(genderEntity.name());
        member.setGender(gender);
        member.setLastName(memberEntity.getLastName());
        member.setMemberId(memberEntity.getId());
        member.setPhoneNumber(memberEntity.getPhoneNumber());
        return member;
    }

    public MemberEntity from(Member member) {
        MemberEntity memberEntity = new MemberEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setZipCode(member.getAddress().getZipCode());
        addressEntity.setCity(member.getAddress().getCity());
        addressEntity.setAddressLine1(member.getAddress().getAddressLine1());
        addressEntity.setAddressLine2(member.getAddress().getAddressLine2());
        addressEntity.setCountry(member.getAddress().getCountry());
        addressEntity.setState(member.getAddress().getState());
        CredentialEntity credentialEntity = new CredentialEntity();
        credentialEntity.setPassword(member.getCredential().getPassword());
        credentialEntity.setUsername(member.getCredential().getUsername());
        memberEntity.setCredentialEntity(credentialEntity);
        memberEntity.setAddressEntity(addressEntity);
        memberEntity.setDateOfBirth(member.getDateOfBirth());
        memberEntity.setEmailId(member.getEmailId());
        memberEntity.setFirstName(member.getFirstName());
        memberEntity.setLastName(member.getLastName());
        memberEntity.setPhoneNumber(member.getPhoneNumber());
        Gender gender = Gender.valueOf(member.getGender().name());
        GenderEntity genderEntity = GenderEntity.valueOf(gender.name());
        memberEntity.setGenderEntity(genderEntity);
        memberEntity.setLastUpdatedBy("admin");
        memberEntity.setLastUpdatedDate(new Date());
        return memberEntity;
    }
}
