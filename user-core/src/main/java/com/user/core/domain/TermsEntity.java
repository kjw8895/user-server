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
public class TermsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TermsType type;

}
