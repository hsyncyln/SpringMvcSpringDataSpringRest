package com.innova.controller;

import com.innova.dto.UserDto;
import com.innova.entity.UserEntity;
import com.innova.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Log4j2
public class UserController {

    //Mesaj ekleme formunu getirir
    // http://localhost:8090/user/createForm
    @GetMapping("/user/createForm")
    public String getCreateUserForm(Model model){
        model.addAttribute("user_key",new UserDto());

        return "user/userForm";
    }

    //Mesaj ekleme formunun postudur. Ekleme işlemi için apiye yönlendirir.
    // http://localhost:8090/createForm
    @PostMapping("/user/createForm")
    public String postCreateUserForm(Model model, @Valid @ModelAttribute("user_key") UserDto dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "user/userForm";
        }
        else{
            String url = "http://localhost:8090/service/postCreateUserService";
            RestTemplate restTemplate = new RestTemplate();
            boolean isSuccess = restTemplate.postForObject(url ,dto,Boolean.class);

            if(isSuccess){
                model.addAttribute("Message","Mesaj başarıyla eklendi ! ");
                return "user/formSuccess";
            }
            model.addAttribute("Message","Mesaj eklenirken bir hata oluştu. Lütfen teknik birimle iletişime geçin ! ");
            return "user/formFail";
        }
    }

    //Mesaj Güncelleme formudur. Apiden kayıtlı mesajı getirir.
    // http://localhost:8090/updateForm/1
    @GetMapping("/user/updateForm/{id}")
    public String getUpdateUserForm(Model model,@PathVariable(name="id") Long myId){

        String url = "http://localhost:8090/service/getUserService/" + myId;
        RestTemplate restTemplate = new RestTemplate();
        UserDto dto = restTemplate.getForObject(url,UserDto.class);

        model.addAttribute("user_key",dto);

        return "user/userForm";
    }

    //Mesaj Güncelleme formunun postudur. Güncelleme için apiye gönderir.
    // http://localhost:8090/user/updateForm
    @PostMapping("/user/updateForm")
    public String postUpdateUserForm(Model model, @Valid @ModelAttribute("user_key") UserDto dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "user/userForm";
        }
        else{

            String url = "http://localhost:8090/service/postUpdateUserService";
            RestTemplate restTemplate = new RestTemplate();
            boolean isSuccess = restTemplate.postForObject(url ,dto,Boolean.class);

            if(isSuccess){
                model.addAttribute("Message","Mesaj başarıyla güncellendi ! ");
                return "user/formSuccess";
            }
            model.addAttribute("Message","Mesaj güncellenirken bir hata oluştu. Lütfen teknik birimle iletişime geçin ! ");
            return "user/formFail";

        }
    }

    //Kayıtlı mesajı silmek için apiye yönlendirir.
    // http://localhost:8090/user/deleteUser/1
    @GetMapping("/user/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable(name = "id") Long myId){

        String url = "http://localhost:8090/service/deleteUserService/" + myId;
        RestTemplate restTemplate = new RestTemplate();
        boolean isSuccess = restTemplate.getForObject(url,Boolean.class);

        if(isSuccess){
            model.addAttribute("Message","Mesaj başarıyla silindi ! ");
            return "user/formSuccess";
        }
        model.addAttribute("Message","Mesaj silinirken bir hata oluştu. Lütfen teknik birimle iletişime geçin ! ");
        return "user/formFail";
    }

    //Kayıtlı mesajı apiden çeker.
    // http://localhost:8090/user/findUser/1
    @GetMapping("/user/findUser/{id}")
    public String findUser(Model model, @PathVariable(name = "id") Long myId){

        String url = "http://localhost:8090/service/getUserService/" + myId;
        RestTemplate restTemplate = new RestTemplate();
        UserDto dto = restTemplate.getForObject(url,UserDto.class);

        if(dto != null){
            model.addAttribute("user_key",dto);
            model.addAttribute("isUserFormReadOnly",true);
            return  "user/userForm";
        }
        model.addAttribute("Message","Kayıtlı bir mesaj bulunamadı. Lütfen teknik birimle iletişime geçin ! ");
        return "user/formFail";
    }

}
