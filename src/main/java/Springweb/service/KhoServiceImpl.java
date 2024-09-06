/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DacDiem;
import Springweb.entity.Kho;
import Springweb.repository.KhoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class KhoServiceImpl implements InterfaceService<Kho> {
    
    @Autowired
    private KhoRepository khoRepository;
    
    @Override
    public Iterable<Kho> getAll() {
        return khoRepository.findAll();
    }
    
    @Override
    public Kho get(Integer id) {
        return khoRepository.findById(id).get();
    }
    
    @Override
    public String save(Kho t) {
        khoRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(Kho t) {
        khoRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(Kho t) {    
        t.setSanpham(null);
        t.setMau(null);        
        khoRepository.save(t);   
        khoRepository.delete(t);
        return "Delete complete";
    }
    
}
