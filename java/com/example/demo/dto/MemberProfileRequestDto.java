package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor//모든 필드를 파라미터로 받는 생성자를 만들어줌
@NoArgsConstructor
public class MemberProfileRequestDto {
    private MultipartFile file;
    private Long img_no;
    private Long member_no;
    private String img_name;
    //img_size
    private Long img_size;
    private String content_type;
    private byte[] img_data;



}
