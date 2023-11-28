package uz.online.springbootpractica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.online.springbootpractica.domein.FileStorage;
import uz.online.springbootpractica.service.FileStorageService;

import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FieStorageController {

    private final FileStorageService fileStorageService;

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile multipartFile) {
        fileStorageService.save(multipartFile);
        return ResponseEntity.ok(multipartFile.getOriginalFilename() + "file upload");
    }

    @GetMapping("/preview/{hashId}")
    public ResponseEntity previewFile(@PathVariable String hashId) throws MalformedURLException {
        FileStorage fileStorage = fileStorageService.findByHahId(hashId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline ; fileName = \"" + URLEncoder.encode(fileStorage.getName()))
                    .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                    .contentLength(fileStorage.getFileSize())
                    .body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getUploadPth())));
        }

        @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws MalformedURLException {
        FileStorage fileStorage = fileStorageService.findByHahId(hashId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment ; fileName = \"" + URLEncoder.encode(fileStorage.getName()))
                    .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                    .contentLength(fileStorage.getFileSize())
                    .body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getUploadPth())));
        }

    @DeleteMapping("/delete/{hashId}")
    public ResponseEntity delete(@PathVariable String hashId) {
        fileStorageService.delete(hashId);
        return ResponseEntity.ok("File delete");
    }
}
