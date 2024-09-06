/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author maiho
 */
@Getter
@Setter
@Entity(name ="kho")
@Table(name ="kho")
public class Kho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKho;    
    @Column
    private String imageURL;
    @Column
    private Double giaBan ;
    @Column
    private Double giaKhuyenMai ;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSanPham",foreignKey = @ForeignKey(name="fk_idSanPham_kho"), nullable = true, insertable=true, updatable=true)
    private SanPham sanpham = null;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idMau",foreignKey = @ForeignKey(name="fk_idMau_kho"), nullable = true, insertable=true, updatable=true)
    private Mau mau = null;
    
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DacDiem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKho", nullable = true,insertable=true, updatable=true)
    private List<DacDiem> listDacDiem = null;
}
