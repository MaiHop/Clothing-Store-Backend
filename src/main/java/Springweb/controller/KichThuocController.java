/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.KichThuoc;
import Springweb.repository.KichThuocRepository;
import Springweb.service.KichThuocServiceImpl;
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
public class KichThuocController {

    @Autowired
    private KichThuocServiceImpl kichThuocServiceImpl;   
    
    @GetMapping("/KichThuoc/readAll")
    public@ResponseBody Iterable<KichThuoc> readallKichThuoc() throws InterruptedException, ExecutionException{
        return kichThuocServiceImpl.getAll();
    }
    
    
    @GetMapping("/KichThuoc/get")
    public @ResponseBody KichThuoc getKichThuoc(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return kichThuocServiceImpl.get(id);
    }
    
    @PostMapping("/KichThuoc/create")
    public @ResponseBody String createKichThuoc(@RequestBody KichThuoc kt ) throws InterruptedException, ExecutionException{
        return kichThuocServiceImpl.save(kt);
    }
    
    @PutMapping("/KichThuoc/update")
    public @ResponseBody String updateKichThuoc(@RequestBody KichThuoc kt ) throws InterruptedException, ExecutionException{
        return kichThuocServiceImpl.update(kt);
        
    }
    
    @PutMapping("/KichThuoc/delete")
    public @ResponseBody String deleteKichThuoc(@RequestBody KichThuoc kt ) throws InterruptedException, ExecutionException{
        return kichThuocServiceImpl.delete(kt);
        
    }
    
}
