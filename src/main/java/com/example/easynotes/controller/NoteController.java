package com.example.easynotes.controller;
import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.*;
import com.example.easynotes.repository.WeightSetRepository;
import com.example.easynotes.repository.am_summaryRepository;
import com.example.easynotes.repository.fundRepository;
import com.example.easynotes.repository.fundSumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    fundSumRepository fundSumRepository;
    @Autowired
    WeightSetRepository weightsetRepository;
    @Autowired
    am_summaryRepository am_SummaryRepository;
    @Autowired
    fundRepository fundRepository;
    // Get All weight
    @GetMapping("/weight")
    public List<WeightSet> getAllNotes() {
        return weightsetRepository.findAll();
    }

//    @PostMapping("/backTest")
//    public WeightSet createNote(@Valid @RequestBody WeightSet weightset, WeightPeriod weightperiod) {
//        return weightsetRepository.save(weightset);
//    }

    @GetMapping("/summary")
    public List<fundSummary> getAllSummary() {
        return fundSumRepository.findAll();
    }


    // Create a new weight
    @PostMapping("/weight")
    public WeightSet createNote(@Valid @RequestBody WeightSet weight) {
        return weightsetRepository.save(weight);
    }
    // Get a Single weight
    @GetMapping("/weight/{id}")
    public WeightSet getNoteById(@PathVariable(value = "id") int asset_id) {
        return weightsetRepository.findById(asset_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", asset_id));
    }


    @GetMapping("/summary/weightReturn/{f_id}")
    public double getReturnById(@PathVariable(value = "f_id") int fund_id) {
        fundSummary fundSummary = fundSumRepository.findById(fund_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", fund_id));
        double return6m = fundSummary.getSrank_return6m()*0.07;
        double return1y = (fundSummary.getSrank_return1y())*0.254;
        double return3y = (fundSummary.getSrank_return3y())*0.327;
        double return5y = (fundSummary.getSrank_return5y())*0.2095;
        double return10y = (fundSummary.getSrank_return10y())*0.1395;
        double weightTotalreturn = (return6m + return1y + return3y + return5y + return10y)*30.6/100;

        return weightTotalreturn;
    }

    @GetMapping("/summary/weightVola/{f_id}")
    public double getVolaByid(@PathVariable(value = "f_id") int fund_id) {
        fundSummary fundSummary = fundSumRepository.findById(fund_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", fund_id));
        double vola6m = (fundSummary.getSrank_vola6m())*0.07;
        double vola1y = (fundSummary.getSrank_vola1y())*0.254;
        double vola3y = (fundSummary.getSrank_vola3y())*0.327;
        double vola5y = (fundSummary.getSrank_vola5y())*0.2095;
        double vola10y = (fundSummary.getSrank_vola10y())*0.1395;
        double weightTotalvola = (vola6m + vola1y + vola3y + vola5y + vola10y)*37.61/100;

        return weightTotalvola;
    }


    @GetMapping("/summary/weightAM/{f_id}")
    public double getAMByid(@PathVariable(value = "f_id") int fund_id) {// am use 99 but use normal rank !?

        fund fundname = fundRepository.findById(fund_id).orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", fund_id));
        int company_id = fundname.getAsset_manage_company_id();
        //return company_id;
        amSummary fundSummary = am_SummaryRepository.findfund(99,company_id);
        double return6m = fundSummary.getRank_return6m()*0.07;
        double return1y = (fundSummary.getRank_return1y())*25.4/100;
        double return3y = (fundSummary.getRank_return3y())*32.7/100;
        double return5y = (fundSummary.getRank_return5y())*20.95/100;
        double return10y = (fundSummary.getRank_return10y())*13.95/100;
        double weightTotalreturn = ((return6m + return1y + return3y + return5y + return10y)*20.6/100)*50/100;

        double vola6m = (fundSummary.getRank_vola6m())*0.07;
        double vola1y = (fundSummary.getRank_vola1y())*25.4/100;
        double vola3y = (fundSummary.getRank_vola3y())*32.7/100;
        double vola5y = (fundSummary.getRank_vola5y())*20.95/100;
        double vola10y = (fundSummary.getRank_vola10y())*13.95/100;
        double weightTotalvola = ((vola6m + vola1y + vola3y + vola5y + vola10y)*20.6/100)*50/100;
        return weightTotalreturn + weightTotalvola;
    }

    @GetMapping("/summary/weightFee/{f_id}")
    public double getfeeByid(@PathVariable(value = "f_id") int fund_id) {
        fundSummary fundSummary = fundSumRepository.findById(fund_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", fund_id));
        return fundSummary.getSrank_mngfee()*11.19/100;
    }

    @GetMapping("/summary/weightTotal/{f_id}")
    public double getTotalweight(@PathVariable(value = "f_id") int fund_id){
        return this.getReturnById(fund_id) + this.getVolaByid(fund_id) + this.getAMByid(fund_id) + this.getfeeByid(fund_id);
    }
    // Update a weight

    @PutMapping("/weight/{id}")
    public WeightSet updateNote(@PathVariable(value = "id") int asset_id,
                           @Valid @RequestBody WeightSet weightDetail) {

        WeightSet weight = weightsetRepository.findById(asset_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", asset_id));

        weight.setPerformance(weightDetail.getPerformance());
        weight.setVola(weightDetail.getVola());
        weight.setAM(weightDetail.getAM());
        weight.setFee(weightDetail.getFee());

        WeightSet weightUpdate = weightsetRepository.save(weight);
        return weightUpdate;
    }
    // Delete a weight
    @DeleteMapping("/weight/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int asset_id) {
        WeightSet weight = weightsetRepository.findById(asset_id)
                .orElseThrow(() -> new ResourceNotFoundException("weight", "asset_class_id", asset_id));
        weightsetRepository.delete(weight);
        return ResponseEntity.ok().build();
    }
}