package com.example.demo.controller;

import com.example.demo.domain.CustomValidationException;
import com.example.demo.domain.Image;
import com.example.demo.domain.Member;
import com.example.demo.dto.ImageRequestDto;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.ImageService;
import com.example.demo.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final LoginService loginService;
    private final ImageRepository imageRepository;


    @PostMapping(value="/image")
    public String imageUpload(ImageRequestDto imageUploadDto, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member LoginMember = loginService.getUserById(authentication.getName());
        if(imageUploadDto.getFile().isEmpty()){
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }
        Image image=imageRepository.findByMemberNo(LoginMember.getNo());
        if(image!=null){
            //기존 이미지를 삭제
            imageService.deleteImage(LoginMember.getImage().get(0).getImageNo());
        }

        imageService.upload(imageUploadDto, LoginMember);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        return "redirect:/members/memberPage/"+LoginMember.getNo();
    }


    @PostMapping(value="/image/new")
    public String imageUploads(ImageRequestDto imageUploadDto,Long no){


        if(imageUploadDto.getFile().isEmpty()){
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }
        Member member = loginService.getUserByNo(no);
        if(no!=null){
            System.out.println("no = " + no);
            imageService.upload(imageUploadDto, member);
        }


        return "redirect:/members/login";
    }


}

