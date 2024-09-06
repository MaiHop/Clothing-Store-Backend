/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.KichThuoc;
import Springweb.repository.KichThuocRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class KichThuocServiceImpl implements InterfaceService<KichThuoc> {
    
    @Autowired
    private KichThuocRepository kichThuocRepository;
    
    @Override
    public Iterable<KichThuoc> getAll() {
        return kichThuocRepository.findAll();
    }
    
    @Override
    public KichThuoc get(Integer id) {
        return kichThuocRepository.findById(id).get();
    }
    
    @Override
    public String save(KichThuoc t) {
        kichThuocRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(KichThuoc t) {
        kichThuocRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(KichThuoc t) {
        kichThuocRepository.delete(t);
        return "Delete complete";
    }
    
}
