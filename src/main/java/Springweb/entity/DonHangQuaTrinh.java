/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name ="donhangquatrinh")
@Table(name ="donhangquatrinh")
public class DonHangQuaTrinh implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    @Column
    private String trangThai;
    @Column
    private String moTa;
    @Column
    private Date ngay;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DonHang.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDonHang", nullable = false,insertable=true, updatable=true)
    private DonHang donhang;
}
