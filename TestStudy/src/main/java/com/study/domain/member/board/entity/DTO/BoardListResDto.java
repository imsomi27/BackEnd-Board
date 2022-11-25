package com.study.domain.member.board.entity.DTO;

import com.study.domain.member.board.entity.Posts;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel(description = "전체 게시판 조회")
@Getter
//@NoArgsConstructor
@AllArgsConstructor
public class BoardListResDto {
    private String title;
    private LocalDateTime createDate;

    public BoardListResDto(Posts entity) {
        this.title = entity.getTitle();
        this.createDate = entity.getCreateDate();
    }
}
