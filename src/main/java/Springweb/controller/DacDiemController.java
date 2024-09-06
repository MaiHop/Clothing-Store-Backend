/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.DacDiem;
import Springweb.repository.DacDiemRepository;
import Springweb.service.DacDiemServiceImpl;
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
public class DacDiemController {

    @Autowired
    private DacDiemServiceImpl dacDiemServiceImpl;   
    
    @GetMapping("/DacDiem/readAll")
    public@ResponseBody Iterable<DacDiem> readallDacDiem() throws InterruptedException, ExecutionException{
        return dacDiemServiceImpl.getAll();
    }
    
    
    @GetMapping("/DacDiem/get")
    public @ResponseBody DacDiem getDacDiem(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return dacDiemServiceImpl.get(id);
    }
    
    @PostMapping("/DacDiem/create")
    public @ResponseBody String createDacDiem(@RequestBody DacDiem t ) throws InterruptedException, ExecutionException{
        return dacDiemServiceImpl.save(t);
    }
    
    @PutMapping("/DacDiem/update")
    public @ResponseBody String updateDacDiem(@RequestBody DacDiem t ) throws InterruptedException, ExecutionException{
        return dacDiemServiceImpl.update(t);
        
    }
    
    @PutMapping("/DacDiem/delete")
    public @ResponseBody String deleteDacDiem(@RequestBody DacDiem t ) throws InterruptedException, ExecutionException{
        return dacDiemServiceImpl.delete(t);
        
    }
    
}
