package com.codelibary.www.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.CustomExcption.ClientNotFoundException;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.ClientUsers;
import com.codelibary.www.entity.GenericResponse;
import com.codelibary.www.service.ClientService;
import com.google.zxing.WriterException;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;



    @PostMapping("/createCleint/{adminId}")
    public ResponseEntity<ClientEntity> createClient(
            @PathVariable Long adminId,
            @RequestParam("bussinessName") String bussinessName,
            @RequestParam(value = "userName", required = false) String userName, //
            @RequestParam(value = "contactNumber", required = false) Long contactNumber, //
            @RequestParam(value = "alternateNumber", required = false) Long alternateNumber, //
            @RequestParam(value = "email", required = false) String email, //
            @RequestParam(value = "password", required = false) String password, //
            @RequestParam(value = "confirmPassword", required = false) String confirmPassword, //
            @RequestParam(value = "address", required = false) String address, //
            @RequestParam(value = "city", required = false) String city, //
            @RequestParam(value = "state", required = false) String state, //
            @RequestParam(value = "country", required = false) String country, // 
            @RequestParam(value = "role", required = false) String role, //
            @RequestParam(value = "pinCode", required = false) long pinCode, //
            @RequestParam(value = "gstInNumber", required = false) String gstInNumber, //
            @RequestParam(value = "location", required = false) String location, //
            @RequestParam(value = "managerFirstName", required = false)    String managerFirstName,
            @RequestParam(value = "managerLastName", required = false)    String    managerLastName,
            @RequestParam(value = "managerNumber", required = false)     long  managerNumber,
            @RequestParam(value = "bankName", required = false)    String  bankName,
            @RequestParam(value = "bankBranch", required = false)       String  bankBranch,
            @RequestParam(value = "ifscCode", required = false)     String  ifscCode,
            @RequestParam(value = "bankType", required = false)     String   bankType,
            @RequestParam(value = "accountNumber", required = false)       String    accountNumber,
            @RequestParam(value = "typeOfUser", required = false)      String   typeOfUser,
            @RequestParam(value = "numberOfDays", required = false)      Long  numberOfDays,
            @RequestParam(value = "attachments", required = false) MultipartFile attachments
    ) throws IOException, WriterException {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setBussinessName(bussinessName);
        clientEntity.setUserName(userName);
        clientEntity.setContactNumber(contactNumber);
        clientEntity.setAlternateNumber(alternateNumber);
        clientEntity.setEmail(email);
        clientEntity.setPassword(password);
        clientEntity.setConfirmPassword(confirmPassword);
        clientEntity.setAddress(address);
        clientEntity.setCity(city);
        clientEntity.setState(state);
        clientEntity.setCountry(country);
        clientEntity.setRole(role);
        clientEntity.setPinCode(pinCode);
        clientEntity.setGstInNumber(gstInNumber);
        clientEntity.setLocation(location);
        clientEntity.setManagerFirstName(managerFirstName);
        clientEntity.setManagerLastName(managerLastName);
        clientEntity.setManagerNumber(managerNumber);
        clientEntity.setBankName(bankName);
        clientEntity.setBankBranch(bankBranch);
        clientEntity.setIfscCode(ifscCode);
        clientEntity.setBankType(bankType);
        clientEntity.setAccountNumber(accountNumber);
        clientEntity.setTypeOfUser(typeOfUser);
        clientEntity.setNumberOfDays(numberOfDays);

        // Set attachments if provided
        if (attachments != null) {
            clientEntity.setAttachments(attachments.getBytes());
        }
        


        ClientEntity savedClient = clientService.saveClent(clientEntity,adminId);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> getAllClients() {

        List<ClientEntity> clientEntityList = clientService.gettall();

        return new ResponseEntity<>(clientEntityList, HttpStatus.OK);
    }

//    @DeleteMapping("/{bussinessId}")
//    public ResponseEntity<String> deleteClientById(@PathVariable String bussinessId) {
//        clientService.deleteClientById(bussinessId);
//        return ResponseEntity.ok("Client with ID " + bussinessId + " deleted successfully.");
//    }

    @DeleteMapping("/delete/{bussinessId}")
    public ResponseEntity<GenericResponse<String>> deleteClientById(@PathVariable String bussinessId) {
        try {
            clientService.deleteClientById(bussinessId);
            // If deletion is successful, return a success response
            GenericResponse<String> successResponse = new GenericResponse<>();
            successResponse.setSuccess(true);
            successResponse.setMessage("Client deleted successfully.");
            successResponse.setData("Client with ID " + bussinessId + " deleted.");
            return ResponseEntity.ok(successResponse);
        } catch (ClientNotFoundException ex) {
            // If the client is not found, return an error response
            GenericResponse<String> errorResponse = new GenericResponse<>();
            errorResponse.setSuccess(false);
            errorResponse.setMessage("Client not found");
            errorResponse.setData(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception ex) {
            // Handle other exceptions if needed
            GenericResponse<String> errorResponse = new GenericResponse<>();
            errorResponse.setSuccess(false);
            errorResponse.setMessage("An error occurred");
            errorResponse.setData(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/update/{businessId}")
    public ResponseEntity<ClientEntity> updateClient(
            @PathVariable String businessId,
            @RequestParam String bussinessName,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String dob,
            @RequestParam int age,
            @RequestParam(required = false) Long contactNumber,
            @RequestParam(required = false) Long alternateNumber,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam String country,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) MultipartFile attachments,
            @RequestParam(required = false) MultipartFile attachments1,
            @RequestParam(required = false) MultipartFile attachments2
    ) {
        // Create a ClientEntity object with the provided parameters
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setBussinessName(bussinessName);
        clientEntity.setUserName(userName);

        clientEntity.setContactNumber(contactNumber);
        clientEntity.setAlternateNumber(alternateNumber);
        clientEntity.setEmail(email);
        clientEntity.setPassword(password);
        clientEntity.setConfirmPassword(confirmPassword);
        clientEntity.setAddress(address);
        clientEntity.setCity(city);
        clientEntity.setState(state);
        clientEntity.setCountry(country);
        clientEntity.setRole(role);

        // Call the updateClient method in the service

            ClientEntity updatedClient = clientService.updateClient(clientEntity, businessId, attachments, attachments1, attachments2);
            return ResponseEntity.ok(updatedClient);


            // Handle the exception more gracefully, e.g., return a response to the client

    }
    
    @GetMapping("/getallByAdminId/{adminId}")
    public ResponseEntity<List<ClientEntity>> getClientsOnAdminId(@PathVariable long adminId) {
        List<ClientEntity> clients = clientService.getClientsOnAdminId(adminId);
        
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }
    }

    @GetMapping("/clients/{businessId}")
    public ResponseEntity<ClientEntity> getByBusinessId(@PathVariable String businessId) {
        ClientEntity clientEntity = clientService.getByBussinessId(businessId);

        // Check if the clientEntity is found
        if (clientEntity != null) {
            return ResponseEntity.ok(clientEntity);
        } else {
            // Return a 404 Not Found status if the clientEntity is not found
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getallClients")
    public ResponseEntity<List<ClientEntity>> getTotalClientUsers() {
        List<ClientEntity> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }
    
    @GetMapping("/{businessId}/increment-views")
	public ResponseEntity<String> incrementViews(@PathVariable String businessId) {
		clientService.incrementViews(businessId);
		return ResponseEntity.ok("Views incremented successfully");
	}
    
}