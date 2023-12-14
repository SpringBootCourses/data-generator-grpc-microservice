package com.example.datageneratorgrpcmicroservice.service;

import com.example.datageneratorgrpcmicroservice.model.Data;

public interface GRPCDataService {

    void send(Data data);

}
