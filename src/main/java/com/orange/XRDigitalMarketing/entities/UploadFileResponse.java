package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri ;
    private String fileType;
    private Long size;
}
