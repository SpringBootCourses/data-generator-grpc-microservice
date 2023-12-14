package com.example.datageneratorgrpcmicroservice.web.mapper;

import com.example.datageneratorgrpcmicroservice.model.test.DataTestOptions;
import com.example.datageneratorgrpcmicroservice.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper
        extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
