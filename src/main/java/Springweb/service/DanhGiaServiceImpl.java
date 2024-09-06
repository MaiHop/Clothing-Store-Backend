/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DanhGia;
import Springweb.repository.DanhGiaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DanhGiaServiceImpl implements InterfaceService<DanhGia> {
    
    @Autowired
    private DanhGiaRepository danhGiaRepository;
    
    @Override
    public Iterable<DanhGia> getAll() {
        return danhGiaRepository.findAll();
    }
    
    @Override
    public DanhGia get(Integer id) {
        return danhGiaRepository.findById(id).get();
    }
    
    @Override
    public String save(DanhGia t) {
        danhGiaRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(DanhGia t) {
        danhGiaRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(DanhGia t) {
        t.setKhachHang(null);
        t.setSanpham(null);
        danhGiaRepository.save(t);
        danhGiaRepository.delete(t);
        return "Delete complete";
    }
    
}
