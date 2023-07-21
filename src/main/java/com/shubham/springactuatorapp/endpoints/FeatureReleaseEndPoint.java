package com.shubham.springactuatorapp.endpoints;

import com.shubham.springactuatorapp.entity.ProductionRelease;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint(id = "releases")
@Component
public class FeatureReleaseEndPoint {

    private List<ProductionRelease> productionReleaseList = new ArrayList<>();

    @WriteOperation
    public void addNewFeatureRelease(@Selector String changeRequestNo,
                                     @Selector String releaseDate,
                                     String features) {
        ProductionRelease release = ProductionRelease.builder()
                .changeRequestNumber(changeRequestNo)
                .releaseDate(releaseDate)
                .features(Arrays.stream(features.split(",")).collect(Collectors.toList()))
                .build();
        productionReleaseList.add(release);
    }

    @ReadOperation
    public List<ProductionRelease> getAllReleases(){
        return productionReleaseList;
    }

    @ReadOperation
    public ProductionRelease getReleaseByChangeRequestNumber(@Selector String changeRequestNumber){
        return productionReleaseList.stream()
                .filter(productionRelease -> productionRelease.getChangeRequestNumber().equals(changeRequestNumber))
                .findAny()
                .get();
    }

    @DeleteOperation
    public void deleteRelease(@Selector String changeRequestNumber){
        productionReleaseList.remove(getReleaseByChangeRequestNumber(changeRequestNumber));
    }
}
