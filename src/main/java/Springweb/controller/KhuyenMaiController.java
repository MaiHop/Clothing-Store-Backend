/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;


import Springweb.entity.KhuyenMai;
import Springweb.repository.KhuyenMaiRepository;
import Springweb.service.KhuyenMaiServiceImpl;
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
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiServiceImpl khuyenMaiServiceImpl;   
    
    @GetMapping("/KhuyenMai/readAll")
    public@ResponseBody Iterable<KhuyenMai> readallKhuyenMai() throws InterruptedException, ExecutionException{
        return khuyenMaiServiceImpl.getAll();
    }
    
    
    @GetMapping("/KhuyenMai/get")
    public @ResponseBody KhuyenMai getKhuyenMai(@RequestParam Integer id ) throws InterruptedException, ExecutionException{
        return khuyenMaiServiceImpl.get(id);
    }
    
    @PostMapping("/KhuyenMai/create")
    public @ResponseBody String createKhuyenMai(@RequestBody KhuyenMai kt ) throws InterruptedException, ExecutionException{
        return khuyenMaiServiceImpl.save(kt);
    }
    
    @PutMapping("/KhuyenMai/update")
    public @ResponseBody String updateKhuyenMai(@RequestBody KhuyenMai kt ) throws InterruptedException, ExecutionException{
        return khuyenMaiServiceImpl.update(kt);
        
    }
    
    @PutMapping("/KhuyenMai/delete")
    public @ResponseBody String deleteKhuyenMai(@RequestBody KhuyenMai kt ) throws InterruptedException, ExecutionException{
        return khuyenMaiServiceImpl.delete(kt);
        
    }
    
}
