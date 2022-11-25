package com.study.domain.member.board.entity;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.domain.member.board.entity.DTO.BoardListResDto;
import com.study.domain.member.board.entity.DTO.PostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.study.domain.member.board.entity.QMember.member;
import static com.study.domain.member.board.entity.QPosts.posts;

@Repository
@RequiredArgsConstructor
public class PostsQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;
    //전체조회 중에서도 [작성자name, 제목, 작성날짜]
    public List<Posts> boardList() {
        return jpaQueryFactory.selectFrom(posts)
                .fetch();
    }

    //상세게시글 조회 유저 검색에 따른 조회를 원함 [//작성자name, post_id,제목, 컨텐츠, 작성날짜, 수정날짜]
    public List<PostListResponseDto> postsList(Long id) {
        return jpaQueryFactory.select(Projections.constructor(PostListResponseDto.class,
                        posts.id,
                        posts.title,
                        posts.content,
                        posts.createDate,
                        posts.updateDate))
                .from(posts)
                .where(posts.member.id.eq(id))
                .leftJoin(member)
                .on(posts.member.id.eq(member.id))
                .fetch();
    }
//    public List<SearchIdResDto> searchId(Long id) {
//        return jpaQueryFactory.select(Projections.constructor(SearchIdResDto.class,
//                        posts.id,
//                        posts.title,
//                        member.email))
//                .from(posts)
//                .where(posts.member.id.eq(id))
//                .leftJoin(member)
//                 .on(member.id.eq(posts.member.id))
//                .orderBy(sort())
//                .fetch();
//    }
    private OrderSpecifier sort() {
        return posts.id.desc();
    }
//public class BoardsRepositoryImpl implements BoardRepositoryCustom {
//    QBoards b = QBoards.boards;
//    EntityManager em;
//    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//    public BoardsRepositoryImpl(JPAQueryFactory queryFactory) {
//        super(Boards.class);
//        this.queryFactory = queryFactory;
//    }

//    public List<Boards> memberList(Long id) {
//        return queryFactory.selectFrom(b)
//                .where(b.id.eq(id))
//                .orderBy(boards.id.desc())
//                .fetch();
//    }

//    public BooleanBuilder price() {
//        return boards.id.eq(id);
//    }
    // 값이 참일 때 실행,
}
