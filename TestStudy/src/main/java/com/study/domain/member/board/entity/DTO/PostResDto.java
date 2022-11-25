package com.study.domain.member.board.entity.DTO;

import com.study.domain.member.board.entity.Posts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(description = "게시글 조회 응답")
@Data
@NoArgsConstructor
public class PostResDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private LocalDateTime createDate;
    @ApiModelProperty(required = true, value = "멤버 아이디")
    @NotNull
    private Long memberId;

    public void setDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createDate = entity.getCreateDate();
    }
    //기존 entity에 있는 값을 가져오기 위함. get:필드 값을 반환해서 set:필드값을 대입함.
}
