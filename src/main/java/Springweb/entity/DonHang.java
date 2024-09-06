package Springweb.entity;
import java.io.Serializable;
import java.util.Date;
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
@Getter
@Setter
@Entity(name ="donhang")
@Table(name ="donhang")
public class DonHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer idDonHang;
    @Column
    private String trangThai;
    @Column
    private int tongSoLuong;
    @Column
    private Double thanhTien ;
    @Column
    private Double phiDichVu;
    @Column
    private Double phiGiaoHang;
    @Column
    private Double thue;
    @Column
    private Double tienKhuyenMai;
    @Column
    private Double tongTien;
    @Column
    private boolean thanhToanTrangThai;
    @Column
    private Date ngayThanhToan;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKhachHang",foreignKey = @ForeignKey(name="fk_idKhachHang_donhang"), nullable = true, insertable=true, updatable=true)
    private KhachHang khachHang= null;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idDiaChi",foreignKey = @ForeignKey(name="fk_idDiaChi_donhang"), nullable = true, insertable=true, updatable=true)
    private DiaChi diachi = null;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idVanChuyen",foreignKey = @ForeignKey(name="fk_idVanChuyen_donhang"), nullable = true, insertable=true, updatable=true)
    private VanChuyen vanchuyen= null;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "IdThanhToan",foreignKey = @ForeignKey(name="fk_idThanhToan_donhang"), nullable = true, insertable=true, updatable=true)
    private ThanhToan thanhToan = null;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DonHangQuaTrinh.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDonHang", nullable = true,insertable=true, updatable=true)
    private List<DonHangQuaTrinh> listDonHangQuaTrinh = null;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DonHangChiTiet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDonHang", nullable = true,insertable=true, updatable=true)
    private List<DonHangChiTiet> listDonHangChiTiet = null;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = KhuyenMai.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDonHang", nullable = true,insertable=true, updatable=true)
    private List<KhuyenMai> listKhuyenMai = null;
    
    public DonHang() {
    }
    
}
