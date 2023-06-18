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
@Table(name = "photos")
public class PhotoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fileId;
    @OneToOne
    private BinaryView binaryView;
    private Long fileSize;
}
