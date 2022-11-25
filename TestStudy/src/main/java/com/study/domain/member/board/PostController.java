package com.study.domain.member.board;

import com.study.domain.member.board.entity.DTO.*;
import com.study.domain.member.board.entity.Posts;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class PostController {
    private final PostService postService;

    @ApiOperation(value = "게시글 생성", notes = "member와 연관된 게시글 생성하기")
    @PostMapping("/board")
    public PostResDto createBoard(Long memberId, @RequestBody PostSaveDto postSaveDto){
        return postService.createBoard(memberId, postSaveDto);
    }
    //전체 게시글 조회
    @GetMapping("/board")
    public List<Posts> getBoardList() {return postService.BoardList();}
    //상세 게시글 조회
    @GetMapping("/post")
    public List<PostListResponseDto> getPostList(Long id) {return postService.postsList(id);}

//    @GetMapping(value = "/board")
//    public List<SearchIdResDto> searchId(Long id) {
//        return postService.selectId(id);
//    }

    //게시글 수정
//    @PutMapping("/board/{id}")
//    public PostListResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateReqDto postUpdateReqDto) {
//        return postService.updatePost(id, postUpdateReqDto);
//    }

    @DeleteMapping("/board/{id}")
    public List<Posts> deleteBoard(@PathVariable Long id) {
        return postService.deleteBoard(id);
    }

//    @PutMapping
//    public Long updateBoard()
    /*@PostMapping("/")
    public Boards createBoard(String title, String email) { return boardService.createBoard(title, email);}

    @GetMapping("/")
    public List<Boards> getBoardList() { return boardService.getBoardList();}

    //@RequestMapping(method = RequestMethod.POST, value = "/board")
    //public Boards postBoard(String title) { return boardService.postBoard(title);}
    @PutMapping("/")
    public Boards updateBoard(Long id, String title, String email) { return boardService.updateBoard(id, title, email);}

    @DeleteMapping("/")
    public Boards deleteBoard(Long id) {return boardService.deleteBoard(id);}*/
}
