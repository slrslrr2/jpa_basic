package hellojpa;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity2 {
    private String createBy2;
    private LocalDateTime createdDate2;
    private String updateBy2;
    private LocalDateTime updateDate2;

    public String getCreateBy2() {
        return createBy2;
    }

    public void setCreateBy2(String createBy2) {
        this.createBy2 = createBy2;
    }

    public LocalDateTime getCreatedDate2() {
        return createdDate2;
    }

    public void setCreatedDate2(LocalDateTime createdDate2) {
        this.createdDate2 = createdDate2;
    }

    public String getUpdateBy2() {
        return updateBy2;
    }

    public void setUpdateBy2(String updateBy2) {
        this.updateBy2 = updateBy2;
    }

    public LocalDateTime getUpdateDate2() {
        return updateDate2;
    }

    public void setUpdateDate2(LocalDateTime updateDate2) {
        this.updateDate2 = updateDate2;
    }
}
