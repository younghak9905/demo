package com.example.demo.service;

import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import com.example.demo.dto.ImageRequestDto;
import com.example.demo.dto.ImageResponseDto;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
@Transactional
@RequiredArgsConstructor
@Service
public class ImageService {
    @Value("${file.path}")//application.properties에 있는 file.path를 가져옴
    private static String uploadFolder;

    private final ImageRepository imageRepository;


    public void upload(ImageRequestDto imageUploadDto, Member member) {
        UUID uuid = UUID.randomUUID();
        String uuidFilename = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();

        Path imageFilePath = Paths.get("C:\\project\\hello-spring1\\src\\main\\resources\\static\\image\\" + uuidFilename);
//convert Path to long
        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes()); //(실제 저장될 경로, 실제 이미지 파일)
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(uuidFilename, member);
        imageRepository.save(image);

    }
    public void defaultImage(Member member) {
        Path imageFilePath = Paths.get(uploadFolder + "기본프로필사진.PNG");
        Image image = Image.builder()
                .caption("기본프로필사진")
                .postImageUrl("기본프로필사진.PNG")
                .member(member)
                .createDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .build();

       imageRepository.save(image);



    }
/*
this.imageNo = image.getImageNo();
        this.caption = image.getCaption();
        this.postImageUrl = image.getPostImageUrl();
        this.createDate = image.getCreateDate();
        this.member_no = image.getMember();
 */
    public void deleteImage(Long no) {
        Image image = imageRepository.findByImageNo(no);
        imageRepository.delete(image);
    }
}
