package com.example.springgreencase.services;

import com.example.springgreencase.model.FileTable;
import com.example.springgreencase.repository.FileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class FileService {

    @Autowired

    private FileRepository fileRepository;

@Transactional
    public FileTable saveFile(MultipartFile file) throws IOException {

        FileTable fileTable = new FileTable();

        fileTable.setTitle(file.getOriginalFilename());

        fileTable.setFiledata(file.getBytes());

        fileTable.setCreation_date(LocalDateTime.now());

        fileTable.setDescription(file.getContentType());

        fileRepository.save(fileTable);

    return fileTable;
}


    public FileTable getFile(Integer id) {

        return fileRepository.findById(id).orElse(null);

    }

    public List<FileTable> getAllFiles(int page, int size, String sortBy, String sortOrder) {

        Pageable pageable = PageRequest.of(page, size, getSort(sortBy, sortOrder));
        Page<FileTable> filePage = fileRepository.findAll(pageable);
        return filePage.getContent();

    }


    private Sort getSort(String sortBy, String sortOrder) {

        Sort.Direction direction = sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        return Sort.by(direction, sortBy);

    }

}
