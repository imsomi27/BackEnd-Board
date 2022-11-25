package com.study.domain.member.board.entity.DTO;

import com.study.domain.member.board.entity.Member;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 등록 요청")
@Data
@NoArgsConstructor
public class MemberSignUpDto {
    private String name;
    private String email;
    private String password;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
    //엔티티 객체 생성
}
