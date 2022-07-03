package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired //객체생성
    private BoardRepository boardRepository;

    //Board class를 받아서 board에 넣어준다.
    public void write(Board board, MultipartFile file) throws Exception {
        //저장할경로 지정

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        //식별자 파일의 이름을 생성해준다.
        UUID uuid = UUID.randomUUID();

        String fileName  = uuid + "_" + file.getOriginalFilename();
        //파일껍데기 생성
        File saveFile = new File(projectPath, fileName);

        //save file
        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/" + fileName);
        boardRepository.save(board);
    }


    // 게시글 리스트 보기
    public List<Board> boardList(){
        return boardRepository.findAll();
    }


    //특정 게시글 보기  Board
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }
    //특정게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }


}
