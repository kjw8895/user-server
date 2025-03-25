package com.user.core.domain;

import com.user.common.code.TermsType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TERMS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TermsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "attachment_file_id")
    private Long attachmentFileId;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TermsType type;

    public static TermsEntity toEntity(TermsType type, Long attachmentFileId) {
        TermsEntity entity = new TermsEntity();
        entity.attachmentFileId = attachmentFileId;
        entity.type = type;

        return entity;
    }

}
