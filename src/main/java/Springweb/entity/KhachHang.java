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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name ="khachhang")
@Table(name ="khachhang")
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKhachHang;
    @Column
    private String uid;
    @Column
    private String imageUrl;
    @Column
    private String ten;
    @Column
    private String email;
    @Column
    private Integer gioiTinh;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DiaChi.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKhachHang", nullable = true,insertable=true, updatable=true)
    private List<DiaChi> listDiaChi;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = ThanhToan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKhachHang", nullable = true,insertable=true, updatable=true)
    private List<ThanhToan> listThanhToan;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "yeuthich", joinColumns = {@JoinColumn(name="idKhachHang")},
            inverseJoinColumns = {@JoinColumn(name="idSanPham")})
    private List<SanPham> listYeuThich;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DonHang.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDonHang", nullable = true,insertable=true, updatable=true)
    private List<DonHang> listDonHang;

    public KhachHang() {
    }
    
}
