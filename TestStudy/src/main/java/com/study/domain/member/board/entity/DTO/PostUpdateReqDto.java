package com.study.domain.member.board.entity.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostUpdateReqDto {
    private String title;
    private String content;
}
