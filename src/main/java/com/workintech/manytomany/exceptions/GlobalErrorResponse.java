package com.workintech.manytomany.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
