package org.morozov.enitity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@Entity
@Table(name = "audio")
public class AudioEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fileId;
    @OneToOne
    private BinaryView binaryView;
    private Long fileSize;
}
