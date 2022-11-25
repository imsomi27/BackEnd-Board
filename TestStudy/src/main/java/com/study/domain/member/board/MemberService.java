package com.study.domain.member.board;

import com.study.domain.member.board.entity.DTO.MemberSignUpDto;
import com.study.domain.member.board.entity.DTO.MemberResDto;
import com.study.domain.member.board.entity.DTO.MemberUpdateReqDto;
import com.study.domain.member.board.entity.Member;
import com.study.domain.member.board.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //회원등록
    @Transactional
    public MemberResDto createUser(MemberSignUpDto memberSignUpDto) {
        Member member = memberRepository.save(memberSignUpDto.toEntity());
        MemberResDto meminfo = new MemberResDto();
        meminfo.setDto(member);
        return meminfo;
    }
    //회원 정보 조회
    @Transactional(readOnly = true)
    public List<Member> ReadMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public Member updateMember(Long id, MemberUpdateReqDto dto) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.update(dto);
        return member;
    }
}