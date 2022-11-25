package com.study.common;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
//여러 엔티티가 상속받을 수 있는 superclass가 되었다.
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseDateEntity {
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME(3) COMMENT '생성일'")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME(3) COMMENT '수정일'")
    private LocalDateTime updateDate;
}
