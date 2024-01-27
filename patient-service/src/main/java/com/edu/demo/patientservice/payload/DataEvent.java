package com.edu.demo.patientservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataEvent<T>{
    private String eventMsg;
    private T eventData;
}
