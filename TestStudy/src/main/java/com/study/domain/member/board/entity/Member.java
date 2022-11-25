package com.study.domain.member.board.entity;

import com.study.common.BaseDateEntity;
import com.study.domain.member.board.entity.DTO.MemberUpdateReqDto;
import com.study.domain.member.board.entity.DTO.PostUpdateReqDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member extends BaseDateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", columnDefinition = "BIGINT COMMENT '멤버_id'")
    private Long id; //primary Key,PK

    @Column(name = "email", nullable = false, columnDefinition = "NVARCHAR(30) COMMENT '사용자 아이디'", unique = true)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "NVARCHAR(30) COMMENT '사용자 비밀번호'")
    private String password;

    @Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(30) COMMENT '사용자 별명'")
    private String name;

    public void update(MemberUpdateReqDto memberUpdateReqDto) {
        this.email = memberUpdateReqDto.getEmail();
        this.name = memberUpdateReqDto.getName();
    }

//    @OneToMany(mappedBy = "members", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private final List<Boards> boards = new ArrayList<>();
}
