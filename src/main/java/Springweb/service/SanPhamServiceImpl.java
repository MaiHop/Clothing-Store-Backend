/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.DacDiem;
import Springweb.entity.Kho;
import Springweb.entity.SanPham;
import Springweb.repository.DacDiemRepository;
import Springweb.repository.SanPhamRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maiho
 */
@Service
public class SanPhamServiceImpl implements InterfaceService<SanPham> {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public Iterable<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham get(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public String save(SanPham t) {
        sanPhamRepository.save(t);
        return "Save complete";
    }

    @Override
    public String update(SanPham t) {
        sanPhamRepository.save(t);
        return "Update complete";
    }

    @Override
    public String delete(SanPham t) {
        SanPham sp = sanPhamRepository.findById(t.getIdSanPham()).get();
        sp.setNhomSanPham(null);
        sp.setLoaiSanPham(null);
        sp.setKieuSanPham(null);
        for (Kho k : sp.getListKho()) {
            k.setMau(null);
            k.setSanpham(null);
            for (DacDiem dd : k.getListDacDiem()) {
                dd.setKho(null);
                dd.setKichThuoc(null);
                DacDiemServiceImpl dacDiemServiceImpl = new DacDiemServiceImpl();
                dacDiemServiceImpl.update(dd);

            }
            KhoServiceImpl khoServiceImpl = new KhoServiceImpl();
            khoServiceImpl.update(k);

        }
        sanPhamRepository.save(sp);
        sanPhamRepository.delete(t);
        return "Delete complete";
    }

}
