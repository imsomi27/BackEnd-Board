package com.study.domain.member.board.entity.DTO;

import com.study.domain.member.board.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MemberResDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdDate;

    public void setDto(Member entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.createdDate = entity.getCreateDate();
    }
    //기존 entity에 있는 값을 가져오기 위함. get:필드 값을 반환해서 set:필드값을 대입함.
}


