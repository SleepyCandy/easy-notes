package com.example.easynotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fund_summary")
@EntityListeners(AuditingEntityListener.class)
public class fundSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fund_id;
    private int srank_return3m;
    private int srank_return6m;
    private int srank_return1y;
    private int srank_return3y;
    private int srank_return5y;
    private int srank_return10y;

    private int srank_vola3m;
    private int srank_vola6m;
    private int srank_vola1y;
    private int srank_vola3y;
    private int srank_vola5y;
    private int srank_vola10y;

    private int rank_return3m;
    private int rank_return6m;
    private int rank_return1y;
    private int rank_return3y;
    private int rank_return5y;
    private int rank_return10y;

    private int rank_vola3m;
    private int rank_vola6m;
    private int rank_vola1y;
    private int rank_vola3y;
    private int rank_vola5y;
    private int rank_vola10y;

    private int srank_mngfee;

    public int getFund_id() {
        return fund_id;
    }

    public void setFund_id(int fund_id) {
        this.fund_id = fund_id;
    }

    public int getSrank_return3m() {
        return srank_return3m;
    }

    public void setSrank_return3m(int srank_return3m) {
        this.srank_return3m = srank_return3m;
    }

    public int getSrank_return6m() {
        return srank_return6m;
    }

    public void setSrank_return6m(int srank_return6m) {
        this.srank_return6m = srank_return6m;
    }

    public int getSrank_return1y() {
        return srank_return1y;
    }

    public void setSrank_return1y(int srank_return1y) {
        this.srank_return1y = srank_return1y;
    }

    public int getSrank_return3y() {
        return srank_return3y;
    }

    public void setSrank_return3y(int srank_return3y) {
        this.srank_return3y = srank_return3y;
    }

    public int getSrank_return5y() {
        return srank_return5y;
    }

    public void setSrank_return5y(int srank_return5y) {
        this.srank_return5y = srank_return5y;
    }

    public int getSrank_return10y() {
        return srank_return10y;
    }

    public void setSrank_return10y(int srank_return10y) {
        this.srank_return10y = srank_return10y;
    }

    public int getSrank_vola3m() {
        return srank_vola3m;
    }

    public void setSrank_vola3m(int srank_vola3m) {
        this.srank_vola3m = srank_vola3m;
    }

    public int getSrank_vola6m() {
        return srank_vola6m;
    }

    public void setSrank_vola6m(int srank_vola6m) {
        this.srank_vola6m = srank_vola6m;
    }

    public int getSrank_vola1y() {
        return srank_vola1y;
    }

    public void setSrank_vola1y(int srank_vola1y) {
        this.srank_vola1y = srank_vola1y;
    }

    public int getSrank_vola3y() {
        return srank_vola3y;
    }

    public void setSrank_vola3y(int srank_vola3y) {
        this.srank_vola3y = srank_vola3y;
    }

    public int getSrank_vola5y() {
        return srank_vola5y;
    }

    public void setSrank_vola5y(int srank_vola5y) {
        this.srank_vola5y = srank_vola5y;
    }

    public int getSrank_vola10y() {
        return srank_vola10y;
    }

    public void setSrank_vola10y(int srank_vola10y) {
        this.srank_vola10y = srank_vola10y;
    }

    public int getRank_return3m() {
        return rank_return3m;
    }

    public void setRank_return3m(int rank_return3m) {
        this.rank_return3m = rank_return3m;
    }

    public int getRank_return6m() {
        return rank_return6m;
    }

    public void setRank_return6m(int rank_return6m) {
        this.rank_return6m = rank_return6m;
    }

    public int getRank_return1y() {
        return rank_return1y;
    }

    public void setRank_return1y(int rank_return1y) {
        this.rank_return1y = rank_return1y;
    }

    public int getRank_return3y() {
        return rank_return3y;
    }

    public void setRank_return3y(int rank_return3y) {
        this.rank_return3y = rank_return3y;
    }

    public int getRank_return5y() {
        return rank_return5y;
    }

    public void setRank_return5y(int rank_return5y) {
        this.rank_return5y = rank_return5y;
    }

    public int getRank_return10y() {
        return rank_return10y;
    }

    public void setRank_return10y(int rank_return10y) {
        this.rank_return10y = rank_return10y;
    }

    public int getRank_vola3m() {
        return rank_vola3m;
    }

    public void setRank_vola3m(int rank_vola3m) {
        this.rank_vola3m = rank_vola3m;
    }

    public int getRank_vola6m() {
        return rank_vola6m;
    }

    public void setRank_vola6m(int rank_vola6m) {
        this.rank_vola6m = rank_vola6m;
    }

    public int getRank_vola1y() {
        return rank_vola1y;
    }

    public void setRank_vola1y(int rank_vola1y) {
        this.rank_vola1y = rank_vola1y;
    }

    public int getRank_vola3y() {
        return rank_vola3y;
    }

    public void setRank_vola3y(int rank_vola3y) {
        this.rank_vola3y = rank_vola3y;
    }

    public int getRank_vola5y() {
        return rank_vola5y;
    }

    public void setRank_vola5y(int rank_vola5y) {
        this.rank_vola5y = rank_vola5y;
    }

    public int getRank_vola10y() {
        return rank_vola10y;
    }

    public void setRank_vola10y(int rank_vola10y) {
        this.rank_vola10y = rank_vola10y;
    }

    public int getSrank_mngfee() {
        return srank_mngfee;
    }

    public void setSrank_mngfee(int srank_mngfee) {
        this.srank_mngfee = srank_mngfee;
    }
}