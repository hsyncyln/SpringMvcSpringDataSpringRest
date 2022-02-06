package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.repository.IComputerRepository;
import com.innova.repository.IMyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Log4j2
@Controller
public class ComputerController {

    @Autowired
    IComputerRepository computerRepository;

    //http://localhost:8090/computer/create
    @GetMapping("/computer/create")
    @ResponseBody
    public String getCreateComputer(){
        //String computerName = JOptionPane.showInputDialog("Bilgisayar Adı giriniz");
        String computerName = "computerName44";
        String computerTrade = "computerTrade44";
        double computerPrice = 44;

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
            @RequestParam(name="computer_price") double computerPrice

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
            return "Silindi - " + computerEntity;
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
            @RequestParam(name="computer_price") double computerPrice

    ){

        Optional<ComputerEntity> optionalComputerEntity = computerRepository.findById(myId);

        if(optionalComputerEntity.isPresent()){
            ComputerEntity computerEntity = optionalComputerEntity.get();
            computerEntity.setComputerName(computerName);
            computerEntity.setComputerTrade(computerTrade);
            computerEntity.setComputerPrice(computerPrice);
            computerRepository.save(computerEntity);
            return "Güncellendi - " + computerEntity;
        }
        else{
            return "Kayıt bulunamadı";
        }
    }

    //Select
    //http://localhost:8090/computer/select/findAll
    @GetMapping("/computer/select/findAll")
    @ResponseBody
    public String getComputerSelectAll(){
        var iterableList = computerRepository.findAll();

        for(var item: iterableList){
            log.info(item);
        }
        return iterableList.toString();
    }

    //Select
    //http://localhost:8090/computer/select/findAll/spessific/computerName66
    @GetMapping("/computer/select/findAll/spessific/{computer_name}")
    @ResponseBody
    public String getComputerSelectAllSpessific(
            @PathVariable(name="computer_name") String computerName
    ){
        var iterableList = computerRepository
                .findComputerEntitiesByComputerName(computerName);

        for(var item: iterableList){
            log.info(item);
        }
        return iterableList.toString();
    }

    //Kendi repositoryimizi kullanalım
    //computerRepository'e implement ettik
    @Autowired
    IMyRepository myRepository;

    //Select
    //http://localhost:8090/computer/select/minPrice/66
    @GetMapping("/computer/select/minPrice/{price}")
    @ResponseBody
    public String getComputerSelectMinPrice(
            @PathVariable(name="price") double price
    ){
        var iterableList = myRepository
                .findComputerPriceMin(price);

        for(var item: iterableList){
            log.info(item);
        }
        return iterableList.toString() + "\n";
    }

}
