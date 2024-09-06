/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.VanChuyen;
import Springweb.repository.VanChuyenRepository;
import Springweb.service.VanChuyenServiceImpl;
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
public class VanChuyenController {

    @Autowired
    private VanChuyenServiceImpl vanChuyenServiceImpl;   
    
    @GetMapping("/VanChuyen/readAll")
    public@ResponseBody Iterable<VanChuyen> readallVanChuyen() throws InterruptedException, ExecutionException{
        return vanChuyenServiceImpl.getAll();
    }
    
    
    @GetMapping("/VanChuyen/get")
    public @ResponseBody VanChuyen getVanChuyen(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return vanChuyenServiceImpl.get(id);
    }
    
    @PostMapping("/VanChuyen/create")
    public @ResponseBody String createVanChuyen(@RequestBody VanChuyen kt ) throws InterruptedException, ExecutionException{
        return vanChuyenServiceImpl.save(kt);
    }
    
    @PutMapping("/VanChuyen/update")
    public @ResponseBody String updateVanChuyen(@RequestBody VanChuyen kt ) throws InterruptedException, ExecutionException{
        return vanChuyenServiceImpl.update(kt);
        
    }
    
    @PutMapping("/VanChuyen/delete")
    public @ResponseBody String deleteVanChuyen(@RequestBody VanChuyen kt ) throws InterruptedException, ExecutionException{
        return vanChuyenServiceImpl.delete(kt);
        
    }
    
}
