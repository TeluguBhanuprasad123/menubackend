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

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelibary.www.entity.Cart;
import com.codelibary.www.entity.ClientEntity;
import com.codelibary.www.entity.DiningTable;
import com.codelibary.www.repository.CartRepository;
import com.codelibary.www.repository.DinningRepository;
import com.codelibary.www.service.DinningtableService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class DinningtableServiceimpl implements DinningtableService {
	
	@Autowired
	private DinningRepository dinningRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public DiningTable save(String tableName, ClientEntity businessId) throws WriterException, IOException {
		DiningTable d=new DiningTable();
		
		d.setTableName(tableName);
		d.setClientEntity(businessId);
		
	
        DiningTable savedDiningTable = dinningRepository.save(d);
    	System.out.println("Generated Table ID: " + d.getTableId());
		String url = "http://localhost:3000/dinningmenu/" + d.getTableId() + "/" + d.getClientEntity().getBussiness_id();
		System.out.println("Constructed URL: " + url);
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
        d.setQrcode(qrCodeBytes);
        DiningTable ds= dinningRepository.save(d);
        Cart cart = new Cart();
        cart.setDiningTable(savedDiningTable);
     

        cartRepository.save(cart);

		
		return savedDiningTable;
	}

	   @Override
	    public List<DiningTable> getAllDiningTables() {
	        return dinningRepository.findAll();
	    }

	    @Override
	    public DiningTable getDiningTableById(Long tableId) {
	        Optional<DiningTable> optionalDiningTable = dinningRepository.findById(tableId);
	        return optionalDiningTable.orElse(null);
	    }
	    @Override
	    public DiningTable updateDiningTable(Long tableId, DiningTable diningTable) {
	        Optional<DiningTable> existingDiningTableOptional = dinningRepository.findById(tableId);

	        if (existingDiningTableOptional.isPresent()) {
	            DiningTable existingDiningTable = existingDiningTableOptional.get();

	            // Check if diningTable.getTableName() is not null before updating
	            if (diningTable.getTableName() != null) {
	                existingDiningTable.setTableName(diningTable.getTableName());
	            }

	            return dinningRepository.save(existingDiningTable);
	        }

	        return null;
	    }

	    @Override
	    public List<DiningTable> findByBusinessIdNative(String businessId) {
	        return dinningRepository.findByBusinessIdNative(businessId);
	    }
	    @Override
	    public void deleteDiningTable(Long tableId) {
	    	dinningRepository.deleteById(tableId);
	    }
	    
	    
	    @Override
	    public Optional<DiningTable> findByBusinessIdAndTableId(String businessId, Long tableId) {
	        return dinningRepository.findByBusinessIdAndTableId(businessId, tableId);
	    }
}
