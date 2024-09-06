/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.LoaiSP;
import Springweb.entity.NhomSP;
import Springweb.repository.NhomSPRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class NhomSPServiceImpl implements InterfaceService<NhomSP> {
    
    @Autowired
    private NhomSPRepository nhomSPRepository;
    
    @Override
    public Iterable<NhomSP> getAll() {
        return nhomSPRepository.findAll();
    }
    
    @Override
    public NhomSP get(Integer id) {
        return nhomSPRepository.findById(id).get();
    }
    
    @Override
    public String save(NhomSP t) {
        nhomSPRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(NhomSP t) {
        nhomSPRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(NhomSP t) {
        for(LoaiSP loai : t.getListLoaiSP()){
            loai.getListNhomSP().remove(t);
            LoaiSPServiceImpl ser = new LoaiSPServiceImpl();
            ser.update(loai);
            t.getListLoaiSP().remove(loai);
        }
        nhomSPRepository.save(t);
        nhomSPRepository.delete(t);
        return "Delete complete";
    }
    
}
