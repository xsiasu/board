package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm() {

        return "boardWrite";
    }

    @GetMapping("/board/list") //localhost:8080/board/list
    public String boardList(Model model) {
        model.addAttribute("list",boardService.boardList());
//        model.addAttribute("list", boardService.boardList());
        return "boardList";
    }
    @GetMapping("/board/view") //localhost:8080/board/view
    public String boardView() {

        return  "boardView";
    }

    @PostMapping("/board/writepro")//프로세스
    public String boardWritePro(Board board) {
        boardService.write(board);

        return "";
    }
}
