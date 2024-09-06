/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.KhuyenMai;
import Springweb.repository.KhuyenMaiRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class KhuyenMaiServiceImpl implements InterfaceService<KhuyenMai> {
    
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;
    
    @Override
    public Iterable<KhuyenMai> getAll() {
        return khuyenMaiRepository.findAll();
    }
    
    @Override
    public KhuyenMai get(Integer id) {
        return khuyenMaiRepository.findById(id).get();
    }
    
    @Override
    public String save(KhuyenMai t) {
        khuyenMaiRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(KhuyenMai t) {
        khuyenMaiRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(KhuyenMai t) {
        t.setDonhang(null);
        t.setKhachhang(null);
        t.setSanpham(null);
        khuyenMaiRepository.save(t);
        khuyenMaiRepository.delete(t);
        return "Delete complete";
    }
    
}
