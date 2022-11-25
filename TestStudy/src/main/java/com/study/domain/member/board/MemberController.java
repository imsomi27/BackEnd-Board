package com.study.domain.member.board;

import com.study.domain.member.board.entity.DTO.MemberSignUpDto;
import com.study.domain.member.board.entity.DTO.MemberResDto;
import com.study.domain.member.board.entity.Member;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "회원 등록", notes = "회원 등록")
    @PostMapping(value = "/member")
    public MemberResDto createId(@RequestBody MemberSignUpDto memberSignUpDto) {
        return memberService.createUser(memberSignUpDto);
    }

    @ApiOperation(value = "user정보", notes = "유저정보")
    @GetMapping(value = "/member")
    public List<Member> getMemberList() {return memberService.ReadMember();}
}
