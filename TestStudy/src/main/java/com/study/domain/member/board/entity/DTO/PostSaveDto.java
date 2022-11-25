package com.study.domain.member.board.entity.DTO;

import com.study.domain.member.board.entity.Posts;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;

@ApiModel(description = "게시글 생성 요청")
@Getter
public class PostSaveDto {
    @NotNull
    private String title;
    @NotNull
    private String content;

    @Builder
    public PostSaveDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //필수 변수를 생성자로 값을 넣는다.
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .build();
    }
    //엔티티 객체 생성
}
