/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.KieuSP;
import Springweb.repository.KieuSPRepository;
import Springweb.service.KieuSPServiceImpl;
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
public class KieuSPController {

    @Autowired
    private KieuSPServiceImpl kieuSPServiceImpl;   
    
    @GetMapping("/KieuSP/readAll")
    public@ResponseBody Iterable<KieuSP> readallKieuSP() throws InterruptedException, ExecutionException{
        return kieuSPServiceImpl.getAll();
    }
    
    
    @GetMapping("/KieuSP/get")
    public @ResponseBody KieuSP getKieuSP(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return kieuSPServiceImpl.get(id);
    }
    
    @PostMapping("/KieuSP/create")
    public @ResponseBody String createKieuSP(@RequestBody KieuSP kt ) throws InterruptedException, ExecutionException{
        return kieuSPServiceImpl.save(kt);
    }
    
    @PutMapping("/KieuSP/update")
    public @ResponseBody String updateKieuSP(@RequestBody KieuSP kt ) throws InterruptedException, ExecutionException{
        return kieuSPServiceImpl.update(kt);
        
    }
    
    @PutMapping("/KieuSP/delete")
    public @ResponseBody String deleteKieuSP(@RequestBody KieuSP kt ) throws InterruptedException, ExecutionException{
        return kieuSPServiceImpl.delete(kt);
        
    }
    
}
