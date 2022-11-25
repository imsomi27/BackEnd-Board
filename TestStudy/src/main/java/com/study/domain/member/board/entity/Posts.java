package com.study.domain.member.board.entity;

import com.study.common.BaseDateEntity;
import com.study.domain.member.board.entity.DTO.PostUpdateReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "tb_board")
public class Posts extends BaseDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", columnDefinition = "BIGINT COMMENT 'post_id'")
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "NVARCHAR(30) COMMENT '제목'")
    private String title;

    @Column(name = "content", columnDefinition = "NVARCHAR(100) COMMENT '내용'")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id", columnDefinition = "BIGINT COMMENT '작성자 아이디'")
    private Member member;

    @Builder
    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void update(PostUpdateReqDto postUpdateReqDto) {
        if (title != null) this.title = postUpdateReqDto.getTitle();
        if (content != null) this.content= postUpdateReqDto.getContent();
    }

    public void setMember(Member member) {this.member = member; }
}
