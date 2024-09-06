/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.ThanhToan;
import Springweb.repository.ThanhToanRepository;
import Springweb.service.ThanhToanServiceImpl;
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
public class ThanhToanController {

    @Autowired
    private ThanhToanServiceImpl thanhToanServiceImpl;   
    
    @GetMapping("/ThanhToan/readAll")
    public@ResponseBody Iterable<ThanhToan> readallThanhToan() throws InterruptedException, ExecutionException{
        return thanhToanServiceImpl.getAll();
    }
    
    
    @GetMapping("/ThanhToan/get")
    public @ResponseBody ThanhToan getThanhToan(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return thanhToanServiceImpl.get(id);
    }
    
    @PostMapping("/ThanhToan/create")
    public @ResponseBody String createThanhToan(@RequestBody ThanhToan kt ) throws InterruptedException, ExecutionException{
        return thanhToanServiceImpl.save(kt);
    }
    
    @PutMapping("/ThanhToan/update")
    public @ResponseBody String updateThanhToan(@RequestBody ThanhToan kt ) throws InterruptedException, ExecutionException{
        return thanhToanServiceImpl.update(kt);
        
    }
    
    @PutMapping("/ThanhToan/delete")
    public @ResponseBody String deleteThanhToan(@RequestBody ThanhToan kt ) throws InterruptedException, ExecutionException{
        return thanhToanServiceImpl.delete(kt);
        
    }
    
}
