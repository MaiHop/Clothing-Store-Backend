package Springweb.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "vanchuyen")
@Table(name = "vanchuyen")
public class VanChuyen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer idVanChuyen;
    @Column
    private String ten;
    @Column
    private Date ngayGiao;
    @Column
    private String imageURL;
    @Column
    private Double gia;

    public VanChuyen() {
    }

}
