package com.example.demo.dto;

import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ImageResponseDto {
    private Long imageNo;
    private String caption;
    private String postImageUrl;
    private String createDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    private Member member_no;

    public ImageResponseDto(Image image) {
        this.imageNo = image.getImageNo();
        this.caption = image.getCaption();
        this.postImageUrl = image.getPostImageUrl();
        this.createDate = image.getCreateDate();
        this.member_no = image.getMember();
    }
}
