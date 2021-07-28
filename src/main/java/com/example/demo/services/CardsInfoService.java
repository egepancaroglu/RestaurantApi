package com.example.demo.services;


import com.example.demo.models.Address;
import com.example.demo.repositories.CardsInfoRepository;
import com.example.demo.models.CardsInfo;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class CardsInfoService {

    private final CardsInfoRepository cardsInfoRepository;

    public CardsInfoService(CardsInfoRepository cardsInfoRepository) {
        this.cardsInfoRepository = cardsInfoRepository;
    }

    public List<CardsInfo> findAll(){
        return cardsInfoRepository.findAll();
    }

    public CardsInfo findById(Long id) {
        return cardsInfoRepository.getById(id);
    }

    public CardsInfo create(CardsInfo cardsInfo) {return cardsInfoRepository.save(cardsInfo); }

    public CardsInfo update(CardsInfo cardsInfo){
        CardsInfo update = cardsInfoRepository.getById((long) cardsInfo.getId());
        if(update != null) {
            cardsInfoRepository.save(cardsInfo);
            return update;
        }
        return cardsInfo;
    }

    public void deleteById(Long id){
        cardsInfoRepository.deleteById(id);
    }














}
