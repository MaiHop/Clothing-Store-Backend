/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DonHangChiTiet;
import Springweb.repository.DonHangChiTietRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DonHangChiTietServiceImpl implements InterfaceService<DonHangChiTiet> {

    @Autowired
    private DonHangChiTietRepository donHangChiTietRepository;

    @Override
    public Iterable<DonHangChiTiet> getAll() {
        return donHangChiTietRepository.findAll();
    }

    @Override
    public DonHangChiTiet get(Integer id) {
        return donHangChiTietRepository.findById(id).get();
    }

    @Override
    public String save(DonHangChiTiet t) {
        donHangChiTietRepository.save(t);
        return "Save complete";
    }

    @Override
    public String update(DonHangChiTiet t) {
        donHangChiTietRepository.save(t);
        return "Update complete";
    }

    @Override
    public String delete(DonHangChiTiet t) {
        t.setDonhang(null);
        t.setSanPham(null);
        t.setMau(null);
        t.setKichThuoc(null);
        donHangChiTietRepository.save(t);
        donHangChiTietRepository.delete(t);
        return "Delete complete";
    }

}
