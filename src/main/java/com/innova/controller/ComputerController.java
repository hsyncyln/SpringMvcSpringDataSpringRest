package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Optional;

@Controller
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    //http://localhost:8090/computer/create
    @GetMapping("/computer/create")
    @ResponseBody
    public String getCreateComputer(){
        //String computerName = JOptionPane.showInputDialog("Bilgisayar Adı giriniz");
        String computerName = "computerName44";
        String computerTrade = "computerTrade44";
        String computerPrice = "computerPrice44";

        ComputerEntity computerEntity = ComputerEntity.builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade(computerTrade)
                .computerPrice(computerPrice)
                .build();
        computerRepository.save(computerEntity);
        return "Ekleme başarılı";
    }

    //http://localhost:8090/computer/create2?computer_name=computerName55&&computer_trade=computerTrade55&&computer_price=computerPrice55
    @GetMapping("/computer/create2")
    @ResponseBody
    public String getCreateComputerRequestParam(
            @RequestParam(name="computer_name") String computerName,
            @RequestParam(name="computer_trade") String computerTrade,
            @RequestParam(name="computer_price") String computerPrice

    ){
        ComputerEntity computerEntity = ComputerEntity.builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade(computerTrade)
                .computerPrice(computerPrice)
                .build();
        computerRepository.save(computerEntity);
        return "Ekleme başarılı - Request Param";
    }

    //http://localhost:8090/computer/find/1
    @GetMapping("/computer/find/{id}")
    @ResponseBody
    public String getFindComputer(@PathVariable(name="id") Long myId){

        Optional<ComputerEntity> optionalComputerEntity = computerRepository.findById(myId);

        if(optionalComputerEntity.isPresent()){
            ComputerEntity computerEntity = optionalComputerEntity.get();
            return computerEntity.toString();
        }
        else{
            return "Kayıt bulunamadı";
        }
    }

    //http://localhost:8090/computer/delete/1
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String getDeleteComputer(@PathVariable(name="id") Long myId){

        Optional<ComputerEntity> optionalComputerEntity = computerRepository.findById(myId);

        if(optionalComputerEntity.isPresent()){
            ComputerEntity computerEntity = optionalComputerEntity.get();
            computerRepository.deleteById(myId);
            return "Silindi - " + computerEntity.toString();
        }
        else{
            return "Kayıt silinemedi";
        }
    }

    //http://localhost:8090/computer/update/2?computer_name=computerName66&&computer_trade=computerTrade66&&computer_price=computerPrice66
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String getUpdateComputer(
            @PathVariable(name="id") Long myId,
            @RequestParam(name="computer_name") String computerName,
            @RequestParam(name="computer_trade") String computerTrade,
            @RequestParam(name="computer_price") String computerPrice

    ){

        Optional<ComputerEntity> optionalComputerEntity = computerRepository.findById(myId);

        if(optionalComputerEntity.isPresent()){
            ComputerEntity computerEntity = optionalComputerEntity.get();
            computerEntity.setComputerName(computerName);
            computerEntity.setComputerTrade(computerTrade);
            computerEntity.setComputerPrice(computerPrice);
            computerRepository.save(computerEntity);
            return "Güncellendi - " + computerEntity.toString();
        }
        else{
            return "Kayıt bulunamadı";
        }
    }
}
