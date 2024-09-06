package Springweb.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Entity(name ="danhgia")
@Table(name ="danhgia")
public class DanhGia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDanhGia;
    @Column
    private String nhanXet;
    @Column
    private Date ngayDanhGia;
    @Column
    private Double diemDanhGia;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = KhachHang.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKhachHang", nullable = false,insertable=true, updatable=true)
    private KhachHang khachHang;   
    @OneToOne(fetch = FetchType.EAGER, targetEntity = SanPham.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idSanPham", nullable = false,insertable=true, updatable=true)
    private SanPham sanpham;

    public DanhGia() {
    }

    
}
