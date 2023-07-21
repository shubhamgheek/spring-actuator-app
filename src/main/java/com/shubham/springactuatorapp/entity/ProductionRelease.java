package com.shubham.springactuatorapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProductionRelease {
    private String changeRequestNumber;
    private String releaseDate;
    private List<String> features;
}
