package com.example.demo.dto;

import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ImageRequestDto {
    private MultipartFile file;
    private String caption;
private String createDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    public Image toEntity(String postImageUrl, Member member){
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .member(member)
                .createDate(createDate)
                .build();
    }
}
