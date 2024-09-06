/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Entity(name ="dacdiem")
@Table(name ="dacdiem")
public class DacDiem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="idDacDiem")
    private Integer idDacDiem;
    @Column
    private Integer soLuong =0;
    @Column
    private Integer soLuongBan=0;
    
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = KichThuoc.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKichThuoc", nullable = true,insertable=true, updatable=true)
    private KichThuoc kichThuoc =null;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKho",foreignKey = @ForeignKey(name="fk_idKho_dacdiem"), nullable = true, insertable=true, updatable=true)
    private Kho kho;
}
