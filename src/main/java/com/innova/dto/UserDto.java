package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserDto {

    private Long userId;

    @NotEmpty(message = "Ad alanını boş geçemezsiniz")
    private String userName;

    @NotEmpty(message = "Soyad alanını boş geçemezsiniz")
    private String userSurname;

    @NotEmpty(message = "Email alanını boş geçemezsiniz")
    @Email(message = "Uygun formatta mail giriniz")
    private String emailAddress;

    @Min(value = 18, message = "18 yaşından küçüksünüz. Başvuramazsınız")
    @Max(value = 45, message = "45 yaşından büyüksünüz. Başvuramazsınız")
    private int userAge;

    @NotEmpty(message = "Mesaj alanını boş geçemezsiniz")
    @Size(min = 1,max=255)
    private String userMessage;
}
