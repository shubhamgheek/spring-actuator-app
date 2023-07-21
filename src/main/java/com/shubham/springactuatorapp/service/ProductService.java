package com.shubham.springactuatorapp.service;

import com.shubham.springactuatorapp.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ProductService {

    public List<Employee> getAllEmployee(){
        log.info("getAllEmployee");
        return IntStream.rangeClosed(1, 10)
                .mapToObj(id -> new Employee(id, "mbk" + id))
                .collect(Collectors.toList());
    }
}
