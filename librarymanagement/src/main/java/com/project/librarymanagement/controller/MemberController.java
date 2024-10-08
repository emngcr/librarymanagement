package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Member;
import com.project.librarymanagement.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;
    MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping
    public List<Member> getAllUsers(){
        return memberService.getAll();
    }
    @GetMapping("/{memberid}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getById(id);
    }
    @PostMapping
    public Member createMember(@RequestBody Member member){
        return memberService.addAuthor(member);
    }
    @PutMapping("/{memberid}")
    public Member  updateMemberById(@RequestBody Member member , @PathVariable Long id){
        return memberService.update(member , id);
    }
    @DeleteMapping("/{memberid}")
    public void deleteMemberById(@PathVariable  Long id){
        memberService.deleteById(id);
    }
}
