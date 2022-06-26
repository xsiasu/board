package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired //객체생성
    private BoardRepository boardRepository;

    //Board class를 받아서 board에 넣어준다.
    public void write(Board board){

        boardRepository.save(board);
    }


}
