/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.repository;

import Springweb.*;
import Springweb.entity.DacDiem;
import Springweb.entity.DanhGia;
import Springweb.entity.DiaChi;
import Springweb.entity.DonHang;
import Springweb.entity.DonHangQuaTrinh;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maiho
 * @param <T>
 */
@Repository
public interface DonHangQuaTrinhRepository extends CrudRepository<DonHangQuaTrinh, Integer> {
    
    
}
