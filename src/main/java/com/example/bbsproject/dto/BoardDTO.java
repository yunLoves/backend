package com.example.bbsproject.dto;


import com.example.bbsproject.bbsentity.Board;
import lombok.*;

@AllArgsConstructor //롬복 ==> 생성자 자동 완성 어노테이션
@ToString  //롬복 ==> to string 자동 완성 어노테이션
@Getter
@Setter
public class BoardDto {


   private Long id;
   private String title;
   private String content;



    public Board toEntity(){    // dto 데이터들을 테이블화 시키기 위한 메소드
        return new Board(id,title,content);
    }
}
