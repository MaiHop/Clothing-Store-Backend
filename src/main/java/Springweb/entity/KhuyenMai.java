package Springweb.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name ="khuyenmai")
@Table(name ="khuyenmai")
public class KhuyenMai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKhuyenMai;
    @Column
    private String tenKhuyenMai;
    @Column
    private String noiDung;
    @Column
    private String dieuKien;
    @Column
    private String toiDaGiam;
    @Column
    private Date hanSuDung;
    @Column
    private boolean trangThai= true;
    @Column
    private boolean trangThaiSD=false;
    
    
    @OneToOne(fetch = FetchType.LAZY, targetEntity = SanPham.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idSanPham", nullable = false,insertable=true, updatable=true)
    private SanPham sanpham;
    
    @OneToOne(fetch = FetchType.LAZY, targetEntity = DonHang.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idDonHang", nullable = false,insertable=true, updatable=true)
    private DonHang donhang;
    
    @OneToOne(fetch = FetchType.LAZY, targetEntity = KhachHang.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKhachHang", nullable = false,insertable=true, updatable=true)
    private KhachHang khachhang;

    
}
