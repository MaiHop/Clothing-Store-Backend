/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.ThanhToan;
import Springweb.repository.ThanhToanRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class ThanhToanServiceImpl implements InterfaceService<ThanhToan> {
    
    @Autowired
    private ThanhToanRepository thanhToanRepository;
    
    @Override
    public Iterable<ThanhToan> getAll() {
        return thanhToanRepository.findAll();
    }
    
    @Override
    public ThanhToan get(Integer id) {
        return thanhToanRepository.findById(id).get();
    }
    
    @Override
    public String save(ThanhToan t) {
        thanhToanRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(ThanhToan t) {
        thanhToanRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(ThanhToan t) {
        t.setKhachhang(null);
        thanhToanRepository.save(t);
        thanhToanRepository.delete(t);
        return "Delete complete";
    }
    
}
