/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DonHangQuaTrinh;
import Springweb.repository.DonHangQuaTrinhRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DonHangQuaTrinhServiceImpl implements InterfaceService<DonHangQuaTrinh> {
    
    @Autowired
    private DonHangQuaTrinhRepository donHangQuaTrinhRepository;
    
    @Override
    public Iterable<DonHangQuaTrinh> getAll() {
        return donHangQuaTrinhRepository.findAll();
    }
    
    @Override
    public DonHangQuaTrinh get(Integer id) {
        return donHangQuaTrinhRepository.findById(id).get();
    }
    
    @Override
    public String save(DonHangQuaTrinh t) {
        donHangQuaTrinhRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(DonHangQuaTrinh t) {
        donHangQuaTrinhRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(DonHangQuaTrinh t) {
        t.setDonhang(null);
        donHangQuaTrinhRepository.save(t);
        donHangQuaTrinhRepository.delete(t);
        return "Delete complete";
    }
    
}
