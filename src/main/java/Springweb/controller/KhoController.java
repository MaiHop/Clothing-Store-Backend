/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.Kho;
import Springweb.repository.KhoRepository;
import Springweb.service.KhoServiceImpl;
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
public class KhoController {

    @Autowired
    private KhoServiceImpl khoServiceImpl;   
    
    @GetMapping("/Kho/readAll")
    public@ResponseBody Iterable<Kho> readallKho() throws InterruptedException, ExecutionException{
        return khoServiceImpl.getAll();
    }
    
    
    @GetMapping("/Kho/get")
    public @ResponseBody Kho getKho(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return khoServiceImpl.get(id);
    }
    
    @PostMapping("/Kho/create")
    public @ResponseBody String createKho(@RequestBody Kho kt ) throws InterruptedException, ExecutionException{
        return khoServiceImpl.save(kt);
    }
    
    @PutMapping("/Kho/update")
    public @ResponseBody String updateKho(@RequestBody Kho kt ) throws InterruptedException, ExecutionException{
        return khoServiceImpl.update(kt);
        
    }
    
    @PutMapping("/Kho/delete")
    public @ResponseBody String deleteKho(@RequestBody Kho kt ) throws InterruptedException, ExecutionException{
        return khoServiceImpl.delete(kt);
        
    }
    
}
