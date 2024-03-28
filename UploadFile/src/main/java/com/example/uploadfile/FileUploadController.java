package com.example.uploadfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

import com.example.uploadfile.storage.StorageService;
import com.example.uploadfile.storage.StorageFileNotFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName){
        Resource file = storageService.loadAsResource(fileName);

        if(file == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" +file.getFilename() +"\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded"+ file.getOriginalFilename());

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException storageFileNotFoundException){
        return ResponseEntity.notFound().build();
    }
}
