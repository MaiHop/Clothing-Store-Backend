/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DacDiem;
import Springweb.repository.DacDiemRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DacDiemServiceImpl implements InterfaceService<DacDiem> {
    
    @Autowired
    private DacDiemRepository dacDiemRepository;
    
    @Override
    public Iterable<DacDiem> getAll() {
        return dacDiemRepository.findAll();
    }
    
    @Override
    public DacDiem get(Integer id) {
        return dacDiemRepository.findById(id).get();
    }
    
    @Override
    public String save(DacDiem t) {
        dacDiemRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(DacDiem t) {
        dacDiemRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(DacDiem t) {
        t.setKichThuoc(null);
        t.setKho(null);
        dacDiemRepository.save(t);
        dacDiemRepository.delete(t);
        return "Delete complete";
    }
    
}
