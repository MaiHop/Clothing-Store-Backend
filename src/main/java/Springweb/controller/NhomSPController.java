/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.NhomSP;
import Springweb.repository.NhomSPRepository;
import Springweb.service.NhomSPServiceImpl;
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
public class NhomSPController {

    @Autowired
    private NhomSPServiceImpl nhomSPServiceImpl;   
    
    @GetMapping("/NhomSP/readAll")
    public@ResponseBody Iterable<NhomSP> readallNhomSP() throws InterruptedException, ExecutionException{
        return nhomSPServiceImpl.getAll();
    }
    
    
    @GetMapping("/NhomSP/get")
    public @ResponseBody NhomSP getNhomSP(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return nhomSPServiceImpl.get(id);
    }
    
    @PostMapping("/NhomSP/create")
    public @ResponseBody String createNhomSP(@RequestBody NhomSP kt ) throws InterruptedException, ExecutionException{
        return nhomSPServiceImpl.save(kt);
    }
    
    @PutMapping("/NhomSP/update")
    public @ResponseBody String updateNhomSP(@RequestBody NhomSP kt ) throws InterruptedException, ExecutionException{
        return nhomSPServiceImpl.update(kt);
        
    }
    
    @PutMapping("/NhomSP/delete")
    public @ResponseBody String deleteNhomSP(@RequestBody NhomSP kt ) throws InterruptedException, ExecutionException{
        return nhomSPServiceImpl.delete(kt);
        
    }
    
}
