package com.myProject.mapper;


import com.myProject.dto.H_CONTR_Dto;
import com.myProject.dto.H_SDate_Dto;
import com.myProject.model.H_CONTR;
import com.myProject.model.H_SData;
import com.myProject.repositories.H_CONTR_Repo;
import com.myProject.repositories.H_SDate_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class H_CONTR_Mapper {

    @Autowired
    H_CONTR_Repo h_contr_repo;

    @Autowired
    H_SDate_Repo h_sDate_repo;

    public H_CONTR_Dto map_H_CONTR_to_H_CONTR_Dto(H_CONTR h_contr)
    {
        H_CONTR_Dto h_contr_dto = new H_CONTR_Dto();

        h_contr_dto.setID(h_contr.getID());
        h_contr_dto.setNAME(h_contr.getNAME());
        h_contr_dto.setMAGID(h_contr.getMAGID());
        return h_contr_dto;
    }

    public H_SDate_Dto map_H_CONTR_and_H_SDate_to_H_SDate_Dto(H_CONTR contr){
        H_SDate_Dto hSDateDto = new H_SDate_Dto();
        H_SData sData = h_sDate_repo.findAllByCONTROLLERIDOrderByID(contr.getID()).get(h_sDate_repo.findAllByCONTROLLERIDOrderByID(contr.getID()).size() - 1);
        hSDateDto.setID(contr.getID());
        hSDateDto.setNAME(contr.getNAME());
        hSDateDto.setTMP1(sData.getTMP1());
        hSDateDto.setTMP2(sData.getTMP2());
        hSDateDto.setTMP3(sData.getTMP3());
        hSDateDto.setTMP4(sData.getTMP4());
        hSDateDto.setTMP5(sData.getTMP5());
        hSDateDto.setBAR1(sData.getBAR1());
        hSDateDto.setBAR2(sData.getBAR2());
        hSDateDto.setBAR3(sData.getBAR3());
        hSDateDto.setWAT1(sData.getWAT1());
        hSDateDto.setWAT2(sData.getWAT2());
        hSDateDto.setWAT3(sData.getWAT3());
        hSDateDto.setBOOL1(sData.isBOOL1());
        hSDateDto.setBOOL2(sData.isBOOL2());
        hSDateDto.setBOOL3(sData.isBOOL3());
        hSDateDto.setSTATUS(sData.isSTATUS());
        return hSDateDto;
    }
}
