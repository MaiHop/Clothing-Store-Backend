package Springweb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "sanpham")
@Table(name = "sanpham")
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer idSanPham;
    @Column
    private String tenSanPham;
    @Column
    private String thongTin;
    
    @Column
    private Date ngayTao;    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idNhomSP",foreignKey = @ForeignKey(name="fk_idNhomSanPham_sanpham"), nullable = true, insertable=true, updatable=true)
    private NhomSP nhomSanPham;
    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idLoaiSP",foreignKey = @ForeignKey(name="fk_idLoaiSanPham_sanpham"), nullable = true, insertable=true, updatable=true)
    private LoaiSP loaiSanPham;
    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKieuSP",foreignKey = @ForeignKey(name="fk_idKieuSanPham_sanpham"), nullable = true, insertable=true, updatable=true)
    private KieuSP kieuSanPham;
    
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = Kho.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSanPham", nullable = true,insertable=true, updatable=true)
    private List<Kho> listKho;     
    
    @JsonIgnore
    @ManyToMany(mappedBy = "listYeuThich")
    private List<KhachHang> listKhachHang = new ArrayList<>();
}
