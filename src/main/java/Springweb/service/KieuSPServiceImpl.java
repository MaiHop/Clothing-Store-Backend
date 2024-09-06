/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.KieuSP;
import Springweb.entity.LoaiSP;
import Springweb.repository.KieuSPRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class KieuSPServiceImpl implements InterfaceService<KieuSP> {
    
    @Autowired
    private KieuSPRepository kieuSPRepository;
    
    @Override
    public Iterable<KieuSP> getAll() {
        return kieuSPRepository.findAll();
    }
    
    @Override
    public KieuSP get(Integer id) {
        return kieuSPRepository.findById(id).get();
    }
    
    @Override
    public String save(KieuSP t) {
        kieuSPRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(KieuSP t) {
        kieuSPRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(KieuSP t) {
        for(LoaiSP loai : t.getListLoaiSP()){
            loai.getListKieuSP().remove(t);
            LoaiSPServiceImpl ser = new LoaiSPServiceImpl();
            ser.update(loai);
            t.getListLoaiSP().remove(loai);
        }
        kieuSPRepository.save(t);
        kieuSPRepository.delete(t);
        return "Delete complete";
    }
    
}
