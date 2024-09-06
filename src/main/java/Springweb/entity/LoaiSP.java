package Springweb.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@Entity(name = "loaisp")
@Table(name = "loaisp")
public class LoaiSP implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLoaiSP;
    @Column
    private String ten;
    
    @Column
    private String imageURL;
    
    
    @ManyToMany(mappedBy = "listLoaiSP")
    private List<KieuSP> listKieuSP = new ArrayList<>();
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "nhomsp_loaisp", joinColumns = {@JoinColumn(name="idLoaiSP")},
            inverseJoinColumns = {@JoinColumn(name="idNhomSP")})
    private List<NhomSP> listNhomSP = new ArrayList<>();
    public LoaiSP() {
    }

    
}
