package com.example.springgreencase.repository;

import com.example.springgreencase.model.FileTable;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileRepository extends JpaRepository<FileTable, Integer> {

}
