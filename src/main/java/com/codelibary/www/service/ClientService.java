package com.codelibary.www.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.entity.ClientEntity;
import com.google.zxing.WriterException;

public interface ClientService {

ClientEntity saveClent(ClientEntity clientEntity, Long adminId) throws WriterException, IOException;

//    ClientEntity saveClent(ClientEntity clientEntity, String bussinessName, long configId, MultipartFile headerImage, MultipartFile logoImage, MultipartFile otherImage, String userName, String dob, int age, Long contactNumber, Long alternateNumber, String email, String password, String confirmPassword, String address, String city, String state, String country, String role);

    List<ClientEntity>gettall();
    void deleteClientById(String bussinessId);

    ClientEntity updateClient(ClientEntity clientEntity, String businessId, MultipartFile attachments, MultipartFile attachments1, MultipartFile attachments2);
    List<ClientEntity>   getClientsOnAdminId(long adminId);

    ClientEntity getByBussinessId(String businessId);
    
    List<ClientEntity> getAllClients();

    void incrementViews(String businessId);
}