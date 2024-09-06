/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.DanhGia;
import Springweb.repository.DanhGiaRepository;
import Springweb.service.DanhGiaServiceImpl;
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
public class DanhGiaController {

    @Autowired
    private DanhGiaServiceImpl danhGiaServiceImpl;   
    
    @GetMapping("/DanhGia/readAll")
    public@ResponseBody Iterable<DanhGia> readallDanhGia() throws InterruptedException, ExecutionException{
        return danhGiaServiceImpl.getAll();
    }
    
    
    @GetMapping("/DanhGia/get")
    public @ResponseBody DanhGia getDanhGia(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return danhGiaServiceImpl.get(id);
    }
    
    @PostMapping("/DanhGia/create")
    public @ResponseBody String createDanhGia(@RequestBody DanhGia kt ) throws InterruptedException, ExecutionException{
        return danhGiaServiceImpl.save(kt);
    }
    
    @PutMapping("/DanhGia/update")
    public @ResponseBody String updateDanhGia(@RequestBody DanhGia kt ) throws InterruptedException, ExecutionException{
        return danhGiaServiceImpl.update(kt);
        
    }
    
    @PutMapping("/DanhGia/delete")
    public @ResponseBody String deleteDanhGia(@RequestBody DanhGia kt ) throws InterruptedException, ExecutionException{
        return danhGiaServiceImpl.delete(kt);
        
    }
    
}
