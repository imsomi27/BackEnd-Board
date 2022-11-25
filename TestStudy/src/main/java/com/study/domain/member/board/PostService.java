package com.study.domain.member.board;

import com.study.domain.member.board.entity.*;
import com.study.domain.member.board.entity.DTO.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostsRepository postsRepository;
    private final MemberRepository memberRepository;
    private final PostsQueryRepository postsQueryRepository;
    //게시글 등록
    @Transactional
    public PostResDto createBoard(Long memberId, PostSaveDto postSaveDto) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Posts post = postsRepository.save(postSaveDto.toEntity());
        post.setMember(member);
        PostResDto postResDto = new PostResDto();
        postResDto.setDto(post);
        return postResDto;
    }
    //전체게시글 조회
    @Transactional
    public List<Posts> BoardList() {
        return postsQueryRepository.boardList();
    }

    //상세게시글 조회
    //[작성자, 제목, 컨텐츠, 작성날짜, 수정날짜로 나오게 해야함.]
    @Transactional
    public List<PostListResponseDto> postsList(Long id) {
        return postsQueryRepository.postsList(id);
    }

    //작성자 조회[어떤 유저의 글만 보이게[제목, 작성자, 작성날짜]

//    @Transactional(readOnly = true)
//    public List<SearchIdResDto> selectId(Long id) {
//        return postsQueryRepository.searchId(id);
//    }

//    게시글 수정
//    @Transactional
//    public PostListResponseDto updatePost(Long id, PostUpdateReqDto postUpdateReqDto) {
//        Posts post = postsRepository.findById(id).orElseThrow();
//        post.update(postUpdateReqDto);
//        PostListResponseDto dto = new PostListResponseDto();
//        dto.setDto(post);
//        return dto;
//    }
//    @Transactional
//    public PostListResponseDto updatePost(PostSaveDto postSaveDto) {
//        Posts post = postsRepository.findById(postSaveDto.toEntity().getId()).orElseThrow();
//        post.update(postSaveDto);
//        PostListResponseDto listdto = new PostListResponseDto();
//        listdto.setDto(post);
//        return listdto;
//    }
//    @Transactional
//    public PostListResponseDto updatePost(Long id, PostUpdateDto postUpdateDto) {
//        Posts post = postsRepository.findById(id).orElseThrow();
//        post.update(postUpdateDto);
//        PostListResponseDto dto = new PostListResponseDto();
//        dto.setDto(post);
//        return dto;
//    }

    //게시글 삭제
    @Transactional
    public List<Posts> deleteBoard(Long id) {
        Posts post = postsRepository.findById(id).get();
        postsRepository.delete(post);
        return postsRepository.findAll();
    }


   /* @Transactional
    public Boards createBoard(String title, String email) {
        Boards boards = Boards.builder().TITLE(title).EMAIL(email).build();
        return boardsRepository.save(boards);
    }

    @Transactional(readOnly = true)
    public List<Boards> getBoardList() { return boardsRepository.findAll();}

    @Transactional
    public Boards updateBoard(Long id, String title, String email) {
        Boards boards = boardsRepository.findById(id).get();
        boards.update(title, email);
        return boards;
    }
    @Transactional
    public List<Boards> deleteBoard(Long id) {
        Boards boards = boardsRepository.findById(id).get();
        boardsRepository.delete(boards);
        return boardsRepository.findAll();*/
//}
}
