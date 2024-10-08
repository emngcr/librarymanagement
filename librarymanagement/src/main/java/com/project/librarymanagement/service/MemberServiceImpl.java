package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Author;
import com.project.librarymanagement.entity.Member;
import com.project.librarymanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService{
    private MemberRepository memberRepository;
    @Autowired
    MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member addAuthor(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member update(Member member, Long id) {
        Optional<Member> optional = memberRepository.findById(id);// olup olmadigina dair denetim

        if(optional.isPresent()){
            Member newMember = optional.get();
            return newMember;
        }
        else {
            throw new RuntimeException("Doesn't exist : "+ id );
        }
    }
}
