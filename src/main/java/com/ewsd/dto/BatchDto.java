package com.ewsd.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BatchDto implements Serializable {
    private Long id;
    private String batchName;
    private String academicYear;
    private Boolean isDelete;
    private LocalDateTime entryDate;
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "BatchDto{" +
                "id=" + id +
                ", batchName='" + batchName + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", isDelete=" + isDelete +
                ", entryDate=" + entryDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
