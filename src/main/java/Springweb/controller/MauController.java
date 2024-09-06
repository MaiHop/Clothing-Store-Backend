/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.Mau;
import Springweb.repository.MauRepository;
import Springweb.service.MauServiceImpl;
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
public class MauController {

    @Autowired
    private MauServiceImpl mauServiceImpl;   
    
    @GetMapping("/Mau/readAll")
    public@ResponseBody Iterable<Mau> readallMau() throws InterruptedException, ExecutionException{
        return mauServiceImpl.getAll();
    }
    
    
    @GetMapping("/Mau/get")
    public @ResponseBody Mau getMau(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return mauServiceImpl.get(id);
    }
    
    @PostMapping("/Mau/create")
    public @ResponseBody String createMau(@RequestBody Mau kt ) throws InterruptedException, ExecutionException{
        return mauServiceImpl.save(kt);
    }
    
    @PutMapping("/Mau/update")
    public @ResponseBody String updateMau(@RequestBody Mau kt ) throws InterruptedException, ExecutionException{
        return mauServiceImpl.update(kt);
        
    }
    
    @PutMapping("/Mau/delete")
    public @ResponseBody String deleteMau(@RequestBody Mau kt ) throws InterruptedException, ExecutionException{
        return mauServiceImpl.delete(kt);
        
    }
    
}
