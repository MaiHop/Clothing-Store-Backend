/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.repository;

import Springweb.entity.KichThuoc;
import Springweb.entity.KieuSP;
import Springweb.entity.Mau;
import Springweb.entity.NhomSP;
import Springweb.entity.ThanhToan;
import Springweb.entity.VanChuyen;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maiho
 * @param <T>
 */
@Repository
public interface VanChuyenRepository extends CrudRepository<VanChuyen, Integer> {
    
    
}
