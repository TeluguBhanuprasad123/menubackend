//package com.codelibary.www.controller;
//
//
//import com.codelibary.www.CustomExcption.BussinessCategoryIdNotFoundExcpetion;
//import com.codelibary.www.entity.BussinessSubCatego;
//import com.codelibary.www.entity.Congfile;
//import com.codelibary.www.service.BussinessSubCategoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/bussiness-sub-catego")
//public class BussinessCatSubController {
//
//    @Autowired
//    private BussinessSubCategoService bussinessSubCategoService;
//
//    @PostMapping("/save/{bussinessCategId}/{configId}")
//    public ResponseEntity<BussinessSubCatego> saveBussiness(
//            @PathVariable("configId") Long configId,
//            @PathVariable String bussinessCategId,
//            @RequestParam String bussinessType,
//            @RequestParam int bussinessNumber,
//            @RequestParam String email,
//            @RequestParam String address,
//            @RequestParam String taxId,
//            @RequestParam(required = false) MultipartFile image) throws IOException {
//
//        byte[] imageBytes = null;
//
//        // Handle the MultipartFile (image) logic only if it's provided
//        if (image != null && !image.isEmpty()) {
//            imageBytes = image.getBytes();
//            // Other image processing logic can be added here
//        }
//
//        BussinessSubCatego bussinessSubCatego = new BussinessSubCatego();
//        bussinessSubCatego.setBussinessType(bussinessType);
//        bussinessSubCatego.setBussinessNumber(bussinessNumber);
//        bussinessSubCatego.setEmail(email);
//        bussinessSubCatego.setAddress(address);
//        bussinessSubCatego.setImage(imageBytes);
//        bussinessSubCatego.setTaxId(taxId);
//        // Assuming you have other properties and logic to set in the BussinessSubCatego entity
//
//        BussinessSubCatego savedBussiness = bussinessSubCategoService.saveBussiness(bussinessSubCatego, bussinessCategId,configId);
//
//        return new ResponseEntity<>(savedBussiness, HttpStatus.OK);
//    }
//
////    @GetMapping("/{bussinessSubCateId}")
////    public BussinessSubCatego getById(@PathVariable String bussinessSubCateId) {
////        return bussinessSubCategoService.findById(bussinessSubCateId);
////    }
//
//    @GetMapping("/{bussinessSubCateId}")
//    public ResponseEntity<BussinessSubCatego> getById(@PathVariable String bussinessSubCateId) {
//        try {
//            BussinessSubCatego bussinessSubCatego = bussinessSubCategoService.findById(bussinessSubCateId);
//            return new ResponseEntity<>(bussinessSubCatego, HttpStatus.OK);
//        } catch (BussinessCategoryIdNotFoundExcpetion e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    @PutMapping("/{bussinessSubCateId}")
//    public ResponseEntity<BussinessSubCatego> updateById(
//            @PathVariable String bussinessSubCateId,
//            @RequestParam("image") MultipartFile image,
//            @RequestParam("bussinessType") String bussinessType,
//            @RequestParam(value = "registrationDate", required = false) LocalDate registrationDate,
//            @RequestParam("bussinessNumber") int bussinessNumber,
//            @RequestParam("email") String email,
//            @RequestParam("address") String address,
//            @RequestParam("taxId") String taxId
//    ) throws IOException {
//        BussinessSubCatego updatedBussinessSubCatego = new BussinessSubCatego();
//        updatedBussinessSubCatego.setBussinessType(bussinessType);
//        updatedBussinessSubCatego.setRegistrationDate(registrationDate);
//        updatedBussinessSubCatego.setBussinessNumber(bussinessNumber);
//        updatedBussinessSubCatego.setEmail(email);
//        updatedBussinessSubCatego.setAddress(address);
//        updatedBussinessSubCatego.setTaxId(taxId);
//
//        // Set the image data if provided
//        if (image != null && !image.isEmpty()) {
//            updatedBussinessSubCatego.setImage(image.getBytes());
//        }
//
//        BussinessSubCatego savedBussinessSubCatego = bussinessSubCategoService.UpDateBussinesub(updatedBussinessSubCatego, bussinessSubCateId);
//
//        return new ResponseEntity<>(savedBussinessSubCatego, HttpStatus.OK);
//    }
//
//
//
//}
