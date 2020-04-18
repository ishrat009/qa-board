package com.ewsd.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Entity
    @Table(name = "tbl_terms_and_condition")
    public class TermsAndConditions implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name="name", length=50, nullable=false)
        private String name;

        @Column(name = "text_message", length =300)
        private String textMessage;


        @Column(name = "e_by")
        private User entryBy;

        @Column(name = "e_date")
        private LocalDateTime entryDate;

        @Column(name = "u_by")
        private User updateBy;

        @Column(name = "u_date")
        private LocalDateTime updateDate;

        public TermsAndConditions() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTextMessage() {
            return textMessage;
        }

        public void setTextMessage(String textMessage) {
            this.textMessage = textMessage;
        }

        public User getEntryBy() {
            return entryBy;
        }

        public void setEntryBy(User entryBy) {
            this.entryBy = entryBy;
        }

        public LocalDateTime getEntryDate() {
            return entryDate;
        }

        public void setEntryDate(LocalDateTime entryDate) {
            this.entryDate = entryDate;
        }

        public User getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(User updateBy) {
            this.updateBy = updateBy;
        }

        public LocalDateTime getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
        }


    }