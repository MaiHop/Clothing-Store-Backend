/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.VanChuyen;
import Springweb.repository.VanChuyenRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class VanChuyenServiceImpl implements InterfaceService<VanChuyen> {
    
    @Autowired
    private VanChuyenRepository vanChuyenRepository;
    
    @Override
    public Iterable<VanChuyen> getAll() {
        return vanChuyenRepository.findAll();
    }
    
    @Override
    public VanChuyen get(Integer id) {
        return vanChuyenRepository.findById(id).get();
    }
    
    @Override
    public String save(VanChuyen t) {
        vanChuyenRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(VanChuyen t) {
        vanChuyenRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(VanChuyen t) {
        vanChuyenRepository.delete(t);
        return "Delete complete";
    }
    
}
