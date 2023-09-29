package com.example.bbsproject.presentation.controller;

import com.example.bbsproject.domain.entity.Creator;
import com.example.bbsproject.domain.service.CreatorService;
import com.example.bbsproject.presentation.dto.CreatorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class CreatorController {

    private final CreatorService creatorService;

    @GetMapping("/creators")
    public String selectListCreator(Model model) {
        return null;
    }

    /**
     * 크리에이터 상세 페이지
     */
    @GetMapping("/creators/{creatorId}")
    public String selectCreator(@PathVariable Long creatorId, Model model) {
        CreatorDto.SelectResponse result = creatorService.selectCreator(creatorId);
        model.addAttribute("result", result);

        return "creators";
    }

    @PostMapping("/creators")   //포스트형식-제이슨형식인데, Dto받을려면 리퀘스트바디를 사용함
    public String insertCreator(@RequestBody CreatorDto.InsertRequest request){
        creatorService.insertCreator(request);
        
        return "creators"; //jsp 이름 추후 변경할것
    }

}
