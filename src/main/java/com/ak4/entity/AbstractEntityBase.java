package com.ak4.entity;

import org.springframework.data.domain.Persistable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntityBase implements Persistable<String> {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @PreUpdate
    public void preUpdate(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            setLastUpdatedBy(authentication.getName());
        }
        setLastUpdatedDate(new Date());
    }

    @PrePersist
    public void prePersist(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
           setCreatedBy(authentication.getName());
           setLastUpdatedBy(authentication.getName());
        }
        setCreatedDate(new Date());
        setLastUpdatedDate(new Date());
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate == null ? null : new Date(lastUpdatedDate.getTime());
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        if (lastUpdatedDate == null) {
            this.lastUpdatedDate = null;
        } else {
            this.lastUpdatedDate = new Date(lastUpdatedDate.getTime());
        }
    }

    public Date getCreatedDate() {
        return createdDate == null ? null : new Date(createdDate.getTime());
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate == null) {
            this.createdDate = null;
        } else {
            this.createdDate = new Date(createdDate.getTime());
        }
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isNew() {
        return getCreatedDate() == null;
    }
}
