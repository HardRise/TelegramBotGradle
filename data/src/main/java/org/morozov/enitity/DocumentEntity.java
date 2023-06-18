package org.morozov.enitity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "id")
@Builder
@Entity
@Table(name = "documents")
public class DocumentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fileId;
    private String documentName;
    @OneToOne
    private BinaryView binaryView;
    private String contentType;
    private Long fileSize;
}
