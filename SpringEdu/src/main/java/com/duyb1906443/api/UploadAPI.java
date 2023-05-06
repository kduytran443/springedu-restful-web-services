package com.duyb1906443.api;


import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.utils.ByteToBase64;

@RestController
public class UploadAPI {
	
	@PostMapping(value = "/api/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@CrossOriginsList
    public ResponseEntity<FileDTO> uploadFile(@RequestParam MultipartFile file) throws IOException {
        System.out.println(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        //System.out.println(ByteToBase64.byteToBase64(file));
        FileDTO fileDTO = new FileDTO();
		String data = Base64.encodeBase64String(file.getBytes());
		fileDTO.setData(data);
		fileDTO.setName(file.getOriginalFilename());
		//fileDTO.setSize(file.getSize());
		fileDTO.setType(file.getContentType());
		return ResponseEntity.status(200).body(fileDTO);
    }
	
}
