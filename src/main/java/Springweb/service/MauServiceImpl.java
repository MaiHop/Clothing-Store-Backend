/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Mau;
import Springweb.repository.MauRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class MauServiceImpl implements InterfaceService<Mau> {
    
    @Autowired
    private MauRepository mauRepository;
    
    @Override
    public Iterable<Mau> getAll() {
        return mauRepository.findAll();
    }
    
    @Override
    public Mau get(Integer id) {
        return mauRepository.findById(id).get();
    }
    
    @Override
    public String save(Mau t) {
        mauRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(Mau t) {
        mauRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(Mau t) {
        mauRepository.delete(t);
        return "Delete complete";
    }
    
}
