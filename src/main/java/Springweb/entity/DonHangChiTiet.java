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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "donhangchitiet")
@Table(name = "donhangchitiet")
public class DonHangChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer soLuong;
    @Column
    private Double thanhTien;
    @Column
    private Double thanhTienKhuyenMai;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKichThuoc", foreignKey = @ForeignKey(name = "fk_idKichThuoc_donhangchitiet"), nullable = true, insertable = true, updatable = true)
    private KichThuoc kichThuoc;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idMau", foreignKey = @ForeignKey(name = "fk_idMau_donhangchitiet"), nullable = true, insertable = true, updatable = true)
    private Mau mau;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idDonHang", foreignKey = @ForeignKey(name = "fk_idDonHang_donhangchitiet"), nullable = true, insertable = true, updatable = true)
    private DonHang donhang;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idSanPham", foreignKey = @ForeignKey(name = "fk_idSanPham_donhangchitiett"), nullable = true, insertable = true, updatable = true)
    private SanPham sanPham;

    public DonHangChiTiet() {
    }

}
