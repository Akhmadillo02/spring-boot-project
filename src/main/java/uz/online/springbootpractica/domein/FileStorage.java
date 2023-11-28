package uz.online.springbootpractica.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String extension;

    private String name;

    private Long fileSize;

    private String hashId;

    private String contentType;

    private String uploadPth;

    @Enumerated(EnumType.STRING)
    private FileStorageStatus fileStorageStatus;
}
