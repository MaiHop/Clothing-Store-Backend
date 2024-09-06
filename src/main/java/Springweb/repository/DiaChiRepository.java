/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.repository;

import Springweb.*;
import Springweb.entity.DacDiem;
import Springweb.entity.DanhGia;
import Springweb.entity.DiaChi;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maiho
 * @param <T>
 */
@Repository
public interface DiaChiRepository extends CrudRepository<DiaChi, Integer> {
    
    
}
