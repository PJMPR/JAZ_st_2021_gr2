package com.example.demo.status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProcessStatus {
    int ramUsed;
    int executionTime;
}