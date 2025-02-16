package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Monhoc", schema = "dbo", catalog = "TTN")
public class MonhocEntity implements Serializable {
    private Long id;
    private String maMh;
    private String tenMh;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_MH")
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    @Basic
    @Column(name = "ten_MH")
    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonhocEntity that = (MonhocEntity) o;
        return Objects.equals(maMh, that.maMh) && Objects.equals(tenMh, that.tenMh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMh, tenMh);
    }
}
