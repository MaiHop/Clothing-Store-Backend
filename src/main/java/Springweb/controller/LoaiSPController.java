/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.LoaiSP;
import Springweb.repository.LoaiSPRepository;
import Springweb.service.LoaiSPServiceImpl;
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
public class LoaiSPController {

    @Autowired
    private LoaiSPServiceImpl loaiSPServiceImpl;   
    
    @GetMapping("/LoaiSP/readAll")
    public@ResponseBody Iterable<LoaiSP> readallLoaiSP() throws InterruptedException, ExecutionException{
        return loaiSPServiceImpl.getAll();
    }
    
    
    @GetMapping("/LoaiSP/get")
    public @ResponseBody LoaiSP getLoaiSP(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return loaiSPServiceImpl.get(id);
    }
    
    @PostMapping("/LoaiSP/create")
    public @ResponseBody String createLoaiSP(@RequestBody LoaiSP kt ) throws InterruptedException, ExecutionException{
        return loaiSPServiceImpl.save(kt);
    }
    
    @PutMapping("/LoaiSP/update")
    public @ResponseBody String updateLoaiSP(@RequestBody LoaiSP kt ) throws InterruptedException, ExecutionException{
        return loaiSPServiceImpl.update(kt);
        
    }
    
    @PutMapping("/LoaiSP/delete")
    public @ResponseBody String deleteLoaiSP(@RequestBody LoaiSP kt ) throws InterruptedException, ExecutionException{
        return loaiSPServiceImpl.delete(kt);
        
    }
    
}
