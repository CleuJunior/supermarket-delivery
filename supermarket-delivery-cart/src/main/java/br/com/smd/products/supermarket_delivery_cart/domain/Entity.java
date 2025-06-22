package br.com.smd.products.supermarket_delivery_cart.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Data
@Document
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Entity {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    @Indexed
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @CreatedDate
    private ZonedDateTime creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @LastModifiedDate
    private ZonedDateTime lastModifiedDate;
    private boolean deleted;

}
