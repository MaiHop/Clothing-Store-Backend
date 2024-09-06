/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.DonHangChiTiet;
import Springweb.repository.DonHangChiTietRepository;
import Springweb.service.DonHangChiTietServiceImpl;
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
public class DonHangChiTietController {

    @Autowired
    private DonHangChiTietServiceImpl donHangChiTietServiceImpl;   
    
    @GetMapping("/DonHangChiTiet/readAll")
    public@ResponseBody Iterable<DonHangChiTiet> readallDonHangChiTiet() throws InterruptedException, ExecutionException{
        return donHangChiTietServiceImpl.getAll();
    }
    
    
    @GetMapping("/DonHangChiTiet/get")
    public @ResponseBody DonHangChiTiet getDonHangChiTiet(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return donHangChiTietServiceImpl.get(id);
    }
    
    @PostMapping("/DonHangChiTiet/create")
    public @ResponseBody String createDonHangChiTiet(@RequestBody DonHangChiTiet kt ) throws InterruptedException, ExecutionException{
        return donHangChiTietServiceImpl.save(kt);
    }
    
    @PutMapping("/DonHangChiTiet/update")
    public @ResponseBody String updateDonHangChiTiet(@RequestBody DonHangChiTiet kt ) throws InterruptedException, ExecutionException{
        return donHangChiTietServiceImpl.update(kt);
        
    }
    
    @PutMapping("/DonHangChiTiet/delete")
    public @ResponseBody String deleteDonHangChiTiet(@RequestBody DonHangChiTiet kt ) throws InterruptedException, ExecutionException{
        return donHangChiTietServiceImpl.delete(kt);
        
    }
    
}
