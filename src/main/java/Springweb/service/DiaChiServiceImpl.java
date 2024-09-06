/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DiaChi;
import Springweb.repository.DiaChiRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DiaChiServiceImpl implements InterfaceService<DiaChi> {
    
    @Autowired
    private DiaChiRepository diaChiRepository;
    
    @Override
    public Iterable<DiaChi> getAll() {
        return diaChiRepository.findAll();
    }
    
    @Override
    public DiaChi get(Integer id) {
        return diaChiRepository.findById(id).get();
    }
    
    @Override
    public String save(DiaChi t) {
        diaChiRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(DiaChi t) {
        diaChiRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(DiaChi t) {
        t.setKhachhang(null);
        diaChiRepository.save(t);
        diaChiRepository.delete(t);
        return "Delete complete";
    }
    
}
