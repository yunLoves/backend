package com.example.bbsproject.repository;

import com.example.bbsproject.bbsentity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

//왜 리퍼지토리는 인터페이스로 할까?? 인터페이스를 만들면 어떤 클래스를 만들어서 인터페이스가 정의해놓은 메소드를 구현해야하는 강제성이 있는걸로 알고 있는데..
public interface Boardrepository extends CrudRepository<Board,Long> {
    @Override
    ArrayList<Board> findAll(); //디폴트 메소드??    //findAll()의 반환타입이 iterable ..arraylist로 캐스팅함 hashmap으로 하면 안될까???
}
