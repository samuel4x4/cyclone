package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.models.constants.FileFormat;
import com.ruby.cyclone.configserver.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_NS;

@RestController
@RequestMapping("cyclone/namespaces/{namespace}/businesses/{business}")
public class FilesController {


    private FileService fileService;

    @Autowired
    public FilesController() {
    }

    @GetMapping("/files")
    public List<String> getFiles(@PathVariable String namespace, @PathVariable String business) {
        return this.fileService.getFiles(namespace, business);
    }

    @PostMapping("/files")
    public String importPropertiesFromFile(@PathVariable String namespace, @PathVariable String business, @RequestParam FileFormat fileFormat, @RequestBody MultipartFile file) {
        return this.fileService.importProperties(namespace, business, fileFormat, file);
    }

    @GetMapping("/files/{file}/properties")
    public Map<String, Object> listProperties(@PathVariable String namespace, @PathVariable String business, @PathVariable String file) {
        return fileService.getPropertiesFromFile(namespace, business, file);

    }

}
