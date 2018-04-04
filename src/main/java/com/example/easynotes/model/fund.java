package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fund")
@EntityListeners(AuditingEntityListener.class)
public class fund implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fund_id;
    private int asset_manage_company_id;


    public int getAsset_manage_company_id() {
        return asset_manage_company_id;
    }

    public void setAsset_manage_company_id(int asset_manage_company_id) {
        this.asset_manage_company_id = asset_manage_company_id;
    }

    public int getfund_id() {
        return fund_id;
    }

    public void setfund_id(int fund_id) {
        this.fund_id = fund_id;
    }
}