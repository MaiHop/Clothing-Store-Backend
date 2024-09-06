package Springweb.entity;
import java.io.Serializable;
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
@Entity(name ="diachi")
@Table(name ="diachi")
public class DiaChi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer idDiaChi;
    @Column
    private String tenDiaChi;
    @Column
    private String nguoiNhan;
    @Column
    private String sDT;
    @Column
    private String diaChi;
    @Column
    private String ghiChu;
    @Column
    private boolean xacDinh;
    @Column
    private boolean macDinh;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = KhachHang.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKhachHang", nullable = false,insertable=true, updatable=true)
    private KhachHang khachhang;
    public DiaChi() {
    }

    
}
