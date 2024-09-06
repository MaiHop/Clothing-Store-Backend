/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;

import Springweb.entity.DonHang;
import Springweb.repository.DonHangRepository;
import Springweb.service.DonHangServiceImpl;
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
public class DonHangController {

    @Autowired
    private DonHangServiceImpl donHangServiceImpl;

    @GetMapping("/DonHang/readAll")
    public @ResponseBody
    Iterable<DonHang> readallDonHang() throws InterruptedException, ExecutionException {
        return donHangServiceImpl.getAll();
    }

    @GetMapping("/DonHang/get")
    public @ResponseBody
    DonHang getDonHang(@RequestParam Integer id) throws InterruptedException, ExecutionException {
        return donHangServiceImpl.get(id);
    }

    @GetMapping("/DonHang/findByidKhachHang")
    public @ResponseBody
    List<DonHang> findByidKhachHang(@RequestParam Integer id) throws InterruptedException, ExecutionException {
        return donHangServiceImpl.findByidKhachHang(id);
    }

    @PostMapping("/DonHang/create")
    public @ResponseBody
    String createDonHang(@RequestBody DonHang kt) throws InterruptedException, ExecutionException {
        return donHangServiceImpl.save(kt);
    }

    @PutMapping("/DonHang/update")
    public @ResponseBody
    String updateDonHang(@RequestBody DonHang kt) throws InterruptedException, ExecutionException {
        return donHangServiceImpl.update(kt);

    }

    @PutMapping("/DonHang/delete")
    public @ResponseBody
    String deleteDonHang(@RequestBody DonHang kt) throws InterruptedException, ExecutionException {
        return donHangServiceImpl.delete(kt);

    }

}
