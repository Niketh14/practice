package com.myproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myproject.model.TravelPackages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.Services.Packageserive;
import com.myproject.execption.ResourceNotFoundException;
import com.myproject.model.TravelPackages;
import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.repository.PackageRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200/")
public class packageController {
	/*@Autowired
	private PackageRepository packagerepository;
	


	@PostMapping("/upload")
	public ResponseEntity<String> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
	    System.out.println("Original Image Byte Size - " + file.getBytes().length);
	   TravelPackages img = new TravelPackages(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
	    packagerepository.save(img);
	    return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
	}

	@GetMapping(path = { "/get/{imageName}" })
	public TravelPackages getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<TravelPackages> retrievedImage = packagerepository.findByName(imageName);
		TravelPackages img = new TravelPackages(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}*/
	@Autowired
	  private Packageserive packageService;

	  @PostMapping("/upload")
	  public String uploadImage(@RequestParam("image") MultipartFile file) {
	    if (file.isEmpty()) {
	      return "Image upload failed. Please select an image.";
	    }

	    try {
	      // Save the image metadata to the database
	    	TravelPackages image = new TravelPackages(null, null, null, null);
	      image.setName(file.getOriginalFilename());
	      image.setType(file.getContentType());
	      image.setPicByte(file.getBytes());

	      packageService.save(image);

	      return "Image uploaded successfully.";
	    } catch (IOException e) {
	      return "Image upload failed: " + e.getMessage();
	    }
	  }
}