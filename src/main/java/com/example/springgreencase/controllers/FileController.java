package com.example.springgreencase.controllers;

import com.example.springgreencase.model.FileTable;
import com.example.springgreencase.repository.FileRepository;
import com.example.springgreencase.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController
{
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        try {
            FileTable savedFile = fileService.saveFile(file);
            return ResponseEntity.ok("File ID = "+ savedFile.getId());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Uploading error: "+ e.getMessage());
        }
    }

    @GetMapping("/getFile/{id}")
    public ResponseEntity<FileTable> getFile(@PathVariable Integer id) {

        FileTable fileTable = fileService.getFile(id);

        if (fileTable != null) {

            return ResponseEntity.ok(fileTable);

        } else {

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/getFile")

    public ResponseEntity<List<FileTable>> getAllFiles(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(defaultValue = "creationDate") String sortBy,
                                                       @RequestParam(defaultValue = "asc") String sortOrder
    ) {

        List<FileTable> fileTables = fileService.getAllFiles(page,size,sortBy,sortOrder);

        return ResponseEntity.ok(fileTables);

    }

}
