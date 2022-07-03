package com.study.board.repository;


import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {


}


