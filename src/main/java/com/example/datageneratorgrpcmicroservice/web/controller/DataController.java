package com.example.datageneratorgrpcmicroservice.web.controller;

import com.example.datageneratorgrpcmicroservice.model.Data;
import com.example.datageneratorgrpcmicroservice.model.test.DataTestOptions;
import com.example.datageneratorgrpcmicroservice.service.GRPCDataService;
import com.example.datageneratorgrpcmicroservice.service.TestDataService;
import com.example.datageneratorgrpcmicroservice.web.dto.DataDto;
import com.example.datageneratorgrpcmicroservice.web.dto.DataTestOptionsDto;
import com.example.datageneratorgrpcmicroservice.web.mapper.DataMapper;
import com.example.datageneratorgrpcmicroservice.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final GRPCDataService GRPCDataService;
    private final TestDataService testDataService;

    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        Data data = dataMapper.toEntity(dataDto);
        GRPCDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
