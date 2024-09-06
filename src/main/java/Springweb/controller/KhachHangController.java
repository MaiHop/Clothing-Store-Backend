/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.KhachHang;
import Springweb.repository.KhachHangRepository;
import Springweb.service.KhachHangServiceImpl;
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
public class KhachHangController {

    @Autowired
    private KhachHangServiceImpl khachHangServiceImpl;   
    
    @GetMapping("/KhachHang/readAll")
    public@ResponseBody Iterable<KhachHang> readallKhachHang() throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.getAll();
    }
    
    
    @GetMapping("/KhachHang/get")
    public @ResponseBody KhachHang getKhachHang(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.get(id);
    }
    
    @GetMapping("/KhachHang/getbyUID")
    public @ResponseBody KhachHang findKhachHangbyUID(@RequestParam String uid ) throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.findKhachHangbyUID(uid);
    }
    
    @PostMapping("/KhachHang/create")
    public @ResponseBody String createKhachHang(@RequestBody KhachHang kt ) throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.save(kt);
    }
    
    @PutMapping("/KhachHang/update")
    public @ResponseBody String updateKhachHang(@RequestBody KhachHang kt ) throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.update(kt);
        
    }
    
    @PutMapping("/KhachHang/delete")
    public @ResponseBody String deleteKhachHang(@RequestBody KhachHang kt ) throws InterruptedException, ExecutionException{
        return khachHangServiceImpl.delete(kt);
        
    }
    
}
