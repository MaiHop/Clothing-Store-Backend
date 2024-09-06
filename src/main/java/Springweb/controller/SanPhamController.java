/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.SanPham;
import Springweb.repository.SanPhamRepository;
import Springweb.service.SanPhamServiceImpl;
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
public class SanPhamController {

    @Autowired
    private SanPhamServiceImpl sanPhamServiceImpl;   
    
    @GetMapping("/SanPham/readAll")
    public@ResponseBody Iterable<SanPham> readallSanPham() throws InterruptedException, ExecutionException{
        return sanPhamServiceImpl.getAll();
    }
    
    
    @GetMapping("/SanPham/get")
    public @ResponseBody SanPham getSanPham(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return sanPhamServiceImpl.get(id);
    }
    
    @PostMapping("/SanPham/create")
    public @ResponseBody String createSanPham(@RequestBody SanPham kt ) throws InterruptedException, ExecutionException{
        return sanPhamServiceImpl.save(kt);
    }
    
    @PutMapping("/SanPham/update")
    public @ResponseBody String updateSanPham(@RequestBody SanPham kt ) throws InterruptedException, ExecutionException{
        return sanPhamServiceImpl.update(kt);
        
    }
    
    @PutMapping("/SanPham/delete")
    public @ResponseBody String deleteSanPham(@RequestBody SanPham kt ) throws InterruptedException, ExecutionException{
        return sanPhamServiceImpl.delete(kt);
        
    }
    
}
