package com.example.bbsproject.controller;


import com.example.bbsproject.bbsentity.Board;
import com.example.bbsproject.dto.BoardDTO;
import com.example.bbsproject.repository.Boardrepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j  //롬복 == > 로깅을 위한 어노테이션 현업에서는 system.out.println안쓴다!!(기록에 남지도않고 서버성능에 악영향을 많이 준다함)
@Controller
public class BbsController {
    @Autowired // 객체 자동 주입 어노테이션
    private Boardrepository boardrepository;

    @GetMapping("/board/new") // 새글 작성
    public String newBoardForm() {

        return "board/new";
    }


    @PostMapping("/board/create")   //폼 넘길때는 무조건 post로!!!!!!  여기 코드가 중요!!!!
    public String createArticle(BoardDTO dto) {
        log.info(dto.toString());  //로깅

        //1. dto를 entity 테이블 형식으로 변환 작업! dto 클래스만으로는 디비가 인식을 못한다.. 테이블화 시켜야됨 !
        Board board = dto.toEntity();
        log.info(board.toString());

         //2.repository에게 entity를 디비안에 저장하게 함!!
        Board saved = boardrepository.save(board);
        log.info(saved.toString());
        return "redirect:/board/" + saved.getId();  // 새 글 저장 후, 상세 페이지로!
    }

    @GetMapping("/board/{id}") // 해당 게시글만 보기 !!
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        //1. id로 데이터를 가져온다

        Board boardEntity = boardrepository.findById(id).orElse(null);
        // 문법 뜻: id를 통해서 데이터를 가져오는데 가져올게 없으면 null을 반환(question?? title도 있고 content로도 가져올 수 있는데 왜 id? ==> 타이틀이나 컨텐츠는 중복된 것들이 여러개 있을 수 있지만 id는 pk => 고유한 값.. pk를 매개로 데이터를 가져와야 한다!!!!

        //2. 가져온 데이터를 모델에 등록한다
        model.addAttribute("board", boardEntity); // board라는 이름으로 boardEntity를 등록한다


        //3. 보여줄 페이지를 설정
        return "board/show";
    }

    @GetMapping("board")  // 전체 게시글 보기!!
    public String index(Model model){
        //1. 모든 board를 가져온다
        List<Board> boardEntityList  =  boardrepository.findAll();

        //2. 가져온 board 묶음을 뷰로 전달하기
        model.addAttribute("boardList",boardEntityList);

        //3. 뷰 페이지를 설정!

        return "board/index";

    }

    @GetMapping("/board/{id}/edit")   //여기서는 중괄호{board.id} 하나  뷰 페이지에서는 중괄호 두개 {{board.id}}
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기!!
        Board boardEntity  = boardrepository.findById(id).orElse(null);

        model.addAttribute("board", boardEntity);

        // 뷰 페이지 설정!
        return "board/edit";
    }


    @PostMapping("/board/update")
    public String update(BoardDTO dto) {
        log.info(dto.toString());

        // 1: DTO를 엔티티로 변환
        Board boardEntity = dto.toEntity();
        log.info(dto.toString());


        // 2: 엔티티를 DB로 저장( 두 단계로 처리)

        // 2-1(첫번째 단계): DB에서 기존 데이터를 가져옴
        Board target = boardrepository.findById(boardEntity.getId()).orElse(null);
        // 2-2(두번째 단계): 기존 데이터가 있다면, 값을 수정한 데이터로 갱신
        if (target != null) { //데이터가 비어있지않다면 ..
            boardrepository.save(boardEntity);
        }

        // 3: 수정 결과 페이지로 리다이렉트
        return "redirect:/board/" + boardEntity.getId();


    }
}
