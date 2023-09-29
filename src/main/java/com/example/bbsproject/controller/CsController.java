package com.example.bbsproject.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j  //롬복 == > 로깅을 위한 어노테이션 현업에서는 system.out.println안쓴다!!(기록에 남지도않고 서버성능에 악영향을 많이 준다함)
@RequiredArgsConstructor
@Controller
public class CsController {

    private final CsService csService;

    @GetMapping("/qna")
    public ModelAndView selectListQnA(@RequestParam QnADTO dto) {
        List<QnADTO> QnAList = csService.selectListQnA(dto);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("QnAList");
        mv.setStatus(HttpStatus.valueOf(200));
        mv.addObject("QnA", QnAList);
        return mv;
    }

    @GetMapping("Notes")
    public ModelAndView selectListNotes(@RequestParam NotesDTO dto) {
        List<NotesDTO> NotesList = CsService.SelectListNotes(dto);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("NotesList");
        mv.setStatus(HttpStatus.valueOf(200));
        mv.addObject("Notes", NotesList);
        return mv;
    }

}
