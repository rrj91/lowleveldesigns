package com.scaler.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass //Don't create a separte table instead add attribute in individual table
public class BaseModel {
    @Id
    private Long id;
}
