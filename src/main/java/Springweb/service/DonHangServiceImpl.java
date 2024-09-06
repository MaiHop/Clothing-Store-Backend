/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DonHang;
import Springweb.entity.DonHangChiTiet;
import Springweb.entity.DonHangQuaTrinh;
import Springweb.entity.KhachHang;
import Springweb.entity.KhuyenMai;
import Springweb.repository.DonHangRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class DonHangServiceImpl implements InterfaceService<DonHang> {

    @Autowired
    private DonHangRepository donHangRepository;

    @Override
    public Iterable<DonHang> getAll() {
        return donHangRepository.findAll();
    }

    @Override
    public DonHang get(Integer id) {
        return donHangRepository.findById(id).get();
    }

    public List<DonHang> findByidKhachHang(Integer id){
        return donHangRepository.findByidKhachHang(id);
    }
    @Override
    public String save(DonHang t) {
        donHangRepository.save(t);
        return "Save complete";
    }

    @Override
    public String update(DonHang t) {
        donHangRepository.save(t);
        return "Update complete";
    }

    @Override
    public String delete(DonHang t) {
        t.setKhachHang(null);
        t.setDiachi(null);
        t.setVanchuyen(null);
        t.setThanhToan(null);
        for (DonHangChiTiet ct : t.getListDonHangChiTiet()) {
            ct.setDonhang(null);
            ct.setSanPham(null);
            DonHangChiTietServiceImpl ser = new DonHangChiTietServiceImpl();
            ser.update(ct);
        }
        for (DonHangQuaTrinh qt : t.getListDonHangQuaTrinh()) {
            qt.setDonhang(null);
            DonHangQuaTrinhServiceImpl ser = new DonHangQuaTrinhServiceImpl();
            ser.update(qt);
        }
        for(KhuyenMai km : t.getListKhuyenMai()){
            km.setDonhang(null);
            km.setKhachhang(null);
            km.setSanpham(null);
            KhuyenMaiServiceImpl ser = new KhuyenMaiServiceImpl();
            ser.update(km);
        }
        donHangRepository.save(t);
        donHangRepository.delete(t);
        return "Delete complete";
    }

}
