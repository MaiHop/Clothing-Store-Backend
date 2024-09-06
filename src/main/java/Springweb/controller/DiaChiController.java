/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.DiaChi;
import Springweb.repository.DiaChiRepository;
import Springweb.service.DiaChiServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author maiho
 */
@Controller
public class DiaChiController {

    @Autowired
    private DiaChiServiceImpl diaChiServiceImpl;   
    
    @GetMapping("/DiaChi/readAll")
    public@ResponseBody Iterable<DiaChi> readallDiaChi() throws InterruptedException, ExecutionException{
        return diaChiServiceImpl.getAll();
    }
    
    
    @GetMapping("/DiaChi/get")
    public @ResponseBody DiaChi getDiaChi(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return diaChiServiceImpl.get(id);
    }
    
    @PostMapping("/DiaChi/create")
    public @ResponseBody String createDiaChi(@RequestBody DiaChi kt ) throws InterruptedException, ExecutionException{
        return diaChiServiceImpl.save(kt);
    }
    
    @PutMapping("/DiaChi/update")
    public @ResponseBody String updateDiaChi(@RequestBody DiaChi kt ) throws InterruptedException, ExecutionException{
        return diaChiServiceImpl.update(kt);
        
    }
    
    @PutMapping("/DiaChi/delete")
    public @ResponseBody String deleteDiaChi(@RequestBody DiaChi kt ) throws InterruptedException, ExecutionException{
        return diaChiServiceImpl.delete(kt);
        
    }
    
}
