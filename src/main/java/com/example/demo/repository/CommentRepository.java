package com.example.demo.repository;

import com.example.demo.domain.Comment;
import com.example.demo.dto.CommentResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);





    Optional<Comment> findByCommentNo(Long commentNo);

    Optional<Comment> findByReply(String reply);

    Optional<Comment> findByReplyDate(String replyDate);

    List<Comment> findByReplyContaining(String reply);

    List<Comment> findByReplyDateContaining(String replyDate);

    //  Optional<Comment> findByWriterNo(Long writerNo);

    Optional<Comment> findByAskNo(Long askNo);

    List<Comment> findAll();

    List<Comment> findAllByAskNo(Long no);

    List<Comment> findAllByCommentGroup(Long commentGroup);

    List<Comment> findByCommentGroup(Long commentNo);



   Comment findBySelectedAndAskNo(String selected, Long askNo);
    //u Comment update(Long commentNo, String reply



    //글쓰기
}
