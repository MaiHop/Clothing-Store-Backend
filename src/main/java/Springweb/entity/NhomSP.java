package Springweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "nhomsp")
@Table(name = "nhomsp")
public class NhomSP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private Integer idNhomSP;
    @Column
    private String ten;
    
    @Column
    private String imageURL;
    
    @ManyToMany(mappedBy = "listNhomSP")
    private List<LoaiSP> listLoaiSP = new ArrayList<>();
    public NhomSP() {
    }
}
