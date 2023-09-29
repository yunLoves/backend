package com.example.bbsproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@AllArgsConstructor //롬복 ==> 생성자 자동 완성 어노테이션
@ToString  //롬복 ==> to string 자동 완성 어노테이션
@Getter
@Setter

public class NotesDTO {
    private int notes_id;
    private String notes_title;
    private String notes_content;
    private String notes_writer;
    private Date notes_date;
    private int notes_cnt;
    private String user_id;

}
