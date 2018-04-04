package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "weight_set")
@EntityListeners(AuditingEntityListener.class)
public class WeightSet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int asset_class_id;
    private int performance;
    private int vola;
    private int am;
    private int fee;

    public int getAsset_class_id() {
        return asset_class_id;
    }

    public void setAsset_class_id(int asset_class_id) {
        this.asset_class_id = asset_class_id;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getVola() {
        return vola;
    }

    public void setVola(int vola) {
        this.vola = vola;
    }

    public int getAM() {
        return am;
    }

    public void setAM(int am) {
        this.am = am;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
