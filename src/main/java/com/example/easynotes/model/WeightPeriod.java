package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class WeightPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int asset_class_id;
    private int weight6m;
    private int weight1y;
    private int weight3y;
    private int weight5y;
    private int weight10y;

    public int getAsset_class_id() {
        return asset_class_id;
    }

    public void setAsset_class_id(int asset_class_id) {
        this.asset_class_id = asset_class_id;
    }

    public int getWeight6m() {
        return weight6m;
    }

    public void setWeight6m(int weight6m) {
        this.weight6m = weight6m;
    }

    public int getWeight1y() {
        return weight1y;
    }

    public void setWeight1y(int weight1y) {
        this.weight1y = weight1y;
    }

    public int getWeight3y() {
        return weight3y;
    }

    public void setWeight3y(int weight3y) {
        this.weight3y = weight3y;
    }

    public int getWeight5y() {
        return weight5y;
    }

    public void setWeight5y(int weight5y) {
        this.weight5y = weight5y;
    }

    public int getWeight10y() {
        return weight10y;
    }

    public void setWeight10y(int weight10y) {
        this.weight10y = weight10y;
    }
}
