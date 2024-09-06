/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.KieuSP;
import Springweb.entity.LoaiSP;
import Springweb.entity.NhomSP;
import Springweb.repository.LoaiSPRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class LoaiSPServiceImpl implements InterfaceService<LoaiSP> {
    
    @Autowired
    private LoaiSPRepository loaiSPRepository;
    
    @Override
    public Iterable<LoaiSP> getAll() {
        return loaiSPRepository.findAll();
    }
    
    @Override
    public LoaiSP get(Integer id) {
        return loaiSPRepository.findById(id).get();
    }
    
    @Override
    public String save(LoaiSP t) {
        loaiSPRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(LoaiSP t) {
        loaiSPRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(LoaiSP t) {
        for(KieuSP k : t.getListKieuSP()){
            k.getListLoaiSP().remove(t);
            KieuSPServiceImpl ser = new KieuSPServiceImpl();
            ser.save(k);
            t.getListKieuSP().remove(k);
        }
        for(NhomSP k : t.getListNhomSP()){
            k.getListLoaiSP().remove(t);
            NhomSPServiceImpl ser = new NhomSPServiceImpl();
            ser.save(k);
            t.getListNhomSP().remove(k);
        }
        loaiSPRepository.save(t);
        loaiSPRepository.delete(t);
        return "Delete complete";
    }
    
}
