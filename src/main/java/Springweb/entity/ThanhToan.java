package Springweb.entity;

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
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "thanhtoan")
@Table(name = "thanhtoan")
public class ThanhToan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idThanhToan;
    @Column
    private String loai;
    @Column
    private String trangThai;
    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKhachHang", foreignKey = @ForeignKey(name = "fk_idKhachHang_thanhtoan"), nullable = true, insertable = true, updatable = true)
    private KhachHang khachhang = null;

    public ThanhToan() {
    }

}
