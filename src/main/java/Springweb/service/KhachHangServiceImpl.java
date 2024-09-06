/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DiaChi;
import Springweb.entity.KhachHang;
import Springweb.entity.SanPham;
import Springweb.entity.ThanhToan;
import Springweb.repository.KhachHangRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class KhachHangServiceImpl implements InterfaceService<KhachHang> {
    
    @Autowired
    private KhachHangRepository khachHangRepository;
    
    @Override
    public Iterable<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }
    
    @Override
    public KhachHang get(Integer id) {
        return khachHangRepository.findById(id).get();
    }
    
    public KhachHang findKhachHangbyUID(String uid){
        return khachHangRepository.findByUID(uid);
    }
    
    @Override
    public String save(KhachHang t) {
        ThanhToan tt = new ThanhToan();
        tt.setKhachhang(t);
        tt.setTrangThai("");
        tt.setLoai("Tiền mặt"); 
        tt.setImageUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/logo%2Fmoney_15525615.png?alt=media&token=43960b59-dee3-4d6a-888e-4070b51411b3");
        
        ThanhToan tt2 = new ThanhToan();
        tt2.setKhachhang(t);
        tt2.setTrangThai("Chưa thanh toán");
        tt2.setLoai("ZaloPay"); 
        tt2.setImageUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/logo%2F1622682588188_zalopay.jpg?alt=media&token=48541b4e-a9d3-4873-91ec-75497f62f0f1");
        
        ThanhToan tt3 = new ThanhToan();
        tt3.setKhachhang(t);
        tt3.setTrangThai("Chưa thanh toán");
        tt3.setLoai("MOMO"); 
        tt3.setImageUrl("https://firebasestorage.googleapis.com/v0/b/otp-verification-e3b3e.appspot.com/o/logo%2FLogo-MoMo-Circle.jpg?alt=media&token=5e2b0efb-7b21-4230-acb3-03227e15e8d0");
        
        List<ThanhToan> list = new ArrayList<>();
        list.add(tt);
        list.add(tt2);
        list.add(tt3);
        t.setListThanhToan(list);
        khachHangRepository.save(t);
        return "Save complete";
    }
    
    @Override
    public String update(KhachHang t) {
        khachHangRepository.save(t);
        return "Update complete";
    }
    
    @Override
    public String delete(KhachHang t) {
        for(SanPham sp : t.getListYeuThich()){
            sp.getListKhachHang().remove(t);
            SanPhamServiceImpl ser = new SanPhamServiceImpl();
            ser.update(sp);
            t.getListYeuThich().remove(sp);
        }
        khachHangRepository.save(t);        
        khachHangRepository.delete(t);
        return "Delete complete";
    }
    
}
