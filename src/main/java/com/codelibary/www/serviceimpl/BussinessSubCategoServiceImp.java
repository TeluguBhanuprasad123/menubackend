//package com.codelibary.www.serviceimpl;
//
//import com.codelibary.www.CustomExcption.BussinesSubCatBussinesidNotFount;
//import com.codelibary.www.CustomExcption.BussinessCategoryIdNotFoundExcpetion;
//import com.codelibary.www.CustomExcption.CongfileNotFoundException;
//import com.codelibary.www.entity.BussinessCategories;
//import com.codelibary.www.entity.BussinessSubCatego;
//import com.codelibary.www.entity.Congfile;
//import com.codelibary.www.repository.BussinessCategorRepostiory;
//import com.codelibary.www.repository.BussinessSubCaRepository;
//import com.codelibary.www.repository.ConfigFIleRepostiory;
//import com.codelibary.www.service.BussinessSubCategoService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLOutput;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BussinessSubCategoServiceImp  implements BussinessSubCategoService {
//
//    @Autowired
//    private BussinessSubCaRepository bussinessSubCaRepository;
//
//
//    @Autowired
//    private ConfigFIleRepostiory  configFIleRepostiory;
//    @Autowired
//    private BussinessCategorRepostiory bussinessCategorRepostiory;
//
//
//    @Transactional
//
//    @Override
//    public BussinessSubCatego saveBussiness(BussinessSubCatego bussinessSubCatego, String bussinessCategId,Long configId) {
//
//        Optional<BussinessCategories> bussinessCategoriesOptional = bussinessCategorRepostiory.findBybussinessCategId(bussinessCategId);
//
//        if (!bussinessCategoriesOptional.isPresent()) {
//            throw new BussinessCategoryIdNotFoundExcpetion("BussinessCategories not found for bussinessCategId: " + bussinessCategId);
//        }
//
////
////        try {
////            BussinessSubCatego bussinessSubCatego1 = new BussinessSubCatego();
////
////
////            bussinessSubCatego1.setCongfileId(configId);
////        } catch (CongfileNotFoundException e){
////
////            throw new CongfileNotFoundException("confd nopt fount"+configId);
////        }
//
//Optional<Congfile>optionalCongfile = configFIleRepostiory.findById(configId);
//
//        if(!optionalCongfile.isPresent()){
//            throw new CongfileNotFoundException("config fle not found"+configId);
//
//        }
//
//
//        bussinessSubCatego.setCongfileId(optionalCongfile.get());
//
//        System.out.println(optionalCongfile.get());
//
//        BussinessCategories bussinessCategories = bussinessCategoriesOptional.get();
//        bussinessSubCatego.setBussinessCategories(bussinessCategories);
//
//        String bussinessType = bussinessSubCatego.getBussinessType();
//        String customIdPrefix = bussinessType.substring(0, Math.min(bussinessType.length(), 4));
//        String customId = customIdPrefix + "001";
//        bussinessSubCatego.setBussinessSubCateId(customId);
//
//        // Save the bussinessSubCatego
//        BussinessSubCatego savedBussiness = bussinessSubCaRepository.save(bussinessSubCatego);
//
//        // Log success
//        System.out.println("BussinessSubCatego saved successfully: " + savedBussiness);
//
//        return savedBussiness;
//
//
//    }
//
//    @Override
//    public List<BussinessSubCatego> gettall() {
//
//
//        return bussinessSubCaRepository.findAll();
//    }
//
//    @Override
//    public BussinessSubCatego findById(String bussinessSubCateId) {
//
//
//
//        Optional<BussinessSubCatego> bussinessSubCategoOptional = bussinessSubCaRepository.findById(bussinessSubCateId);
//
//        if (bussinessSubCategoOptional.isPresent()) {
//
//
//
//            return bussinessSubCategoOptional.get();
//        } else {
//            throw new BussinesSubCatBussinesidNotFount("Bussiness SubCategory not found with id: " + bussinessSubCateId);
//        }
//    }
//
//    @Override
//    public BussinessSubCatego UpDateBussinesub(BussinessSubCatego bussinessSubCatego, String bussinessSubCateId) {
//
//        Optional<BussinessSubCatego> bussinessSubCategoOptional = bussinessSubCaRepository.findById(bussinessSubCateId);
//
//        if (bussinessSubCategoOptional.isPresent()) {
//            BussinessSubCatego existingBussinessSubCatego = bussinessSubCategoOptional.get();
//            existingBussinessSubCatego.setBussinessType(bussinessSubCatego.getBussinessType());
//            existingBussinessSubCatego.setTaxId(bussinessSubCatego.getTaxId());
//            existingBussinessSubCatego.setBussinessNumber(bussinessSubCatego.getBussinessNumber());
//            existingBussinessSubCatego.setEmail(bussinessSubCatego.getEmail());
//            existingBussinessSubCatego.setAddress(bussinessSubCatego.getAddress());
//
//            if (bussinessSubCatego.getImage() != null) {
//                existingBussinessSubCatego.setImage(bussinessSubCatego.getImage());
//            }
//
//            return bussinessSubCaRepository.save(existingBussinessSubCatego);
//        } else {
//            throw new BussinessCategoryIdNotFoundExcpetion("Bussiness ID not found: " + bussinessSubCateId);
//        }
//    }
//
//
//
//    }
