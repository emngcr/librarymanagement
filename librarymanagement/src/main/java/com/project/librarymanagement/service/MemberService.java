package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAll();
    Member addAuthor(Member member);
    Member getById(Long id);
    void  deleteById(Long id);
    Member update(Member member , Long id);
}
