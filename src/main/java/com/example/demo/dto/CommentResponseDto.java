package com.example.demo.dto;

import com.example.demo.domain.Ask;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Member;
import lombok.Getter;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {
    private Long commentNo;
    private String reply;
    private Ask askNo;

    private Member writer;

    private Long commentGroup=0L;
    private Long depth=0L;

    private String selected="false";
    private String replyDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    public CommentResponseDto(Comment comment) {
        this.commentNo = comment.getCommentNo();
        this.reply = comment.getReply();
        this.replyDate = comment.getReplyDate();
        this.askNo = comment.getAsk();
        this.writer = comment.getMember();
        this.commentGroup = comment.getCommentGroup();
        this.depth = comment.getDepth();
        this.selected = comment.getSelected();
    }
}
