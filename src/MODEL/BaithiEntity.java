package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Baithi", schema = "dbo", catalog = "TTN")
@IdClass(BaithiEntityPK.class)
public class BaithiEntity implements Serializable {
    private Long id;
    private String maBaithi;
    private Integer maCh;
    private String da;
    private String maKq;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_Baithi")
    public String getMaBaithi() {
        return maBaithi;
    }

    public void setMaBaithi(String maBaithi) {
        this.maBaithi = maBaithi;
    }

    @Basic
    @Column(name = "ma_CH")
    public Integer getMaCh() {
        return maCh;
    }

    public void setMaCh(Integer maCh) {
        this.maCh = maCh;
    }

    @Basic
    @Column(name = "DA")
    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    @Id
    @Column(name = "ma_KQ")
    public String getMaKq() {
        return maKq;
    }

    public void setMaKq(String maKq) {
        this.maKq = maKq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaithiEntity that = (BaithiEntity) o;
        return Objects.equals(maBaithi, that.maBaithi) && Objects.equals(maCh, that.maCh) && Objects.equals(da, that.da) && Objects.equals(maKq, that.maKq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBaithi, maCh, da, maKq);
    }
}
