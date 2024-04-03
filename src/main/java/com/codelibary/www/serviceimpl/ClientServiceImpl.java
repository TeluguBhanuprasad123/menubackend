package com.codelibary.www.serviceimpl;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.codelibary.www.CustomExcption.AdminExpectionNotFound;
import com.codelibary.www.CustomExcption.ClientNotFoundException;
import com.codelibary.www.entity.Admin;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.LoginTable;
import com.codelibary.www.repository.AdminRepository;
import com.codelibary.www.repository.ClientRepository;
import com.codelibary.www.repository.ConfigFIleRepostiory;
import com.codelibary.www.repository.LoginTableRepository;
import com.codelibary.www.service.ClientService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;



@Service
public  class ClientServiceImpl implements ClientService {

    @Autowired
    private ConfigFIleRepostiory configFIleRepostiory;

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoginTableRepository loginTableRepository;


	@Autowired
	private PasswordGenerator passwordGenerator;
    
    
    private int currentSequentialNumber = 0;

    @Override
    public ClientEntity saveClent(ClientEntity clientEntity,Long adminId) throws WriterException, IOException {


        Optional<Admin>adminOptional = adminRepository.findById(adminId);

        if(!adminOptional.isPresent()){

            throw new AdminExpectionNotFound("admin expecvtion is not found"+ adminId);
        }

        clientEntity.setAdminId(adminOptional.get());

        String generatedPassword = passwordGenerator.generatePassword(8);
        clientEntity.setPassword(generatedPassword);
        
        
        String bussinessName = clientEntity.getBussinessName();
        if (bussinessName == null) {
            // Handle the case where bussinessName is null, throw an exception or return an appropriate response
            throw new RuntimeException("BussinessName cannot be null");
        }
        String shortenedName = bussinessName.substring(0, Math.min(bussinessName.length(), 4));

        // Generate a random 3-digit number
        int randomNumbers = new Random().nextInt(900) + 100; // Gives a random number between 100 and 999

        // Concatenate the shortened name and random numbers to create the custom ID
        String customId = shortenedName + randomNumbers;

        // Set the custom ID in the clientEntity
        clientEntity.setBussiness_id(customId);
		// Generate QR code for the user
		String url = "http://localhost:3000/menu/" + clientEntity.getBussiness_id() ;
		int size = 300;
		int borderSize = 1;
		int imageSize = size - (borderSize * 2);
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 0);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, imageSize, imageSize, hints);
		BufferedImage qrCodeImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = qrCodeImage.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, size, size);
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < imageSize; i++) {
			for (int j = 0; j < imageSize; j++) {
				if (bitMatrix.get(i, j)) {
					graphics.fillRect(borderSize + i, borderSize + j, 1, 1);
				}
			}
		}
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(borderSize));
		graphics.drawRoundRect(borderSize, borderSize, imageSize, imageSize, 20, 20);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(qrCodeImage, "png", out);
		byte[] qrCodeBytes = out.toByteArray();

		// Save the generated QR code for the user
		clientEntity.setQrcode(qrCodeBytes);


        String s = "User";

        clientEntity.setRole(s);



        try {
            handleImages(clientEntity, clientEntity.getAttachments());
        } catch (IOException e) {
            // Handle the image processing exception, e.g., log the error
            throw new RuntimeException("Error handling images: " + e.getMessage());
        }

        
        
        
        
        
        
        
        
        
        // Save the ClientEntity object to the repository
        ClientEntity savedClient = clientRepository.save(clientEntity);

        // Create a new LoginTable object and set its properties
        LoginTable loginTable = new LoginTable();
        loginTable.setUser(savedClient);
        loginTable.setRole(s);
        loginTable.setUserName(savedClient.getUserName());
     
        loginTable.setPassword(generatedPassword);

        
        
        // Save the LoginTable object to the repository
        loginTableRepository.save(loginTable);

        return savedClient;
    }


    private void handleImages(ClientEntity clientEntity, byte[] attachments) throws IOException {
        clientEntity.setAttachments(attachments);
   
    }

    @Override
    public List<ClientEntity> gettall() {


        return clientRepository.findAll();


    }

    @Override
    public void deleteClientById(String bussinessId) {

    }



    @Override
    public ClientEntity updateClient(ClientEntity clientEntity, String businessId, MultipartFile attachments, MultipartFile attachments1, MultipartFile attachments2) {
        ClientEntity existingClient = clientRepository.findById(businessId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + businessId));

        // Update existingClient with properties from clientEntity
        existingClient.setBussinessName(clientEntity.getBussinessName());
        existingClient.setUserName(clientEntity.getUserName());

        existingClient.setContactNumber(clientEntity.getContactNumber());
        existingClient.setAlternateNumber(clientEntity.getAlternateNumber());
        existingClient.setEmail(clientEntity.getEmail());
        existingClient.setPassword(clientEntity.getPassword());
        existingClient.setConfirmPassword(clientEntity.getConfirmPassword());
        existingClient.setAddress(clientEntity.getAddress());
        existingClient.setCity(clientEntity.getCity());
        existingClient.setState(clientEntity.getState());
        existingClient.setCountry(clientEntity.getCountry());
        existingClient.setRole(clientEntity.getRole());

        // Set file data for image fields
        try {
            if (attachments != null && attachments.getSize() > 0) {
                existingClient.setAttachments(attachments.getBytes());
            }
       
        } catch (IOException e) {
            // Log the error

            // Handle the exception more gracefully, e.g., return a response to the client
            throw new RuntimeException("Error handling file upload: " + e.getMessage());
        }



        return clientRepository.save(existingClient);
    }


	@Override
	public    List<ClientEntity>   getClientsOnAdminId(long adminId) {
		
		
		
		return clientRepository.findAllByAdminIdAdminId(adminId);
	}


	@Override
	public ClientEntity getByBussinessId(String businessId) {
		
		return clientRepository.findByBussinessId(businessId);
	}


	@Override
	public List<ClientEntity> getAllClients() {
		
		return clientRepository.findAll();
	}


 @Override
	    public void incrementViews(String businessId) {
	        ClientEntity clientEntity = clientRepository.findByBussinessId(businessId);

	        if (clientEntity != null) {
	            clientEntity.setViews(clientEntity.getViews() + 1);
	            clientRepository.save(clientEntity);
	        }
	    }


}