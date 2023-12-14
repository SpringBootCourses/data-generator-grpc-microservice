package com.example.datageneratorgrpcmicroservice.service;

import com.example.datageneratorgrpcmicroservice.DataServerGrpc;
import com.example.datageneratorgrpcmicroservice.GRPCData;
import com.example.datageneratorgrpcmicroservice.MeasurementType;
import com.example.datageneratorgrpcmicroservice.model.Data;
import com.google.protobuf.Timestamp;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;

@Service
public class GRPCDataServiceImpl implements GRPCDataService {

    @GrpcClient(value = "data-generator")
    private DataServerGrpc.DataServerBlockingStub blockingStub;

    @Override
    public void send(Data data) {
        GRPCData request = GRPCData.newBuilder()
                .setSensorId(data.getSensorId())
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setSeconds(
                                        data.getTimestamp()
                                                .toEpochSecond(ZoneOffset.UTC)
                                )
                                .build())
                .setMeasurementType(
                        MeasurementType.valueOf(data.getMeasurementType().name())
                )
                .setMeasurement(data.getMeasurement())
                .build();
        blockingStub.addData(request);
    }

}
