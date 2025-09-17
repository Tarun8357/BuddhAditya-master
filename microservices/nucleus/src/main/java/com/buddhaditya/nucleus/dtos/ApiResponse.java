package com.buddhaditya.nucleus.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.buddhaditya.nucleus.constants.CommonConstants.CREATED;
import static com.buddhaditya.nucleus.constants.CommonConstants.SUCCESS;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private int statusCode;
    private T data;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, SUCCESS, 200, data);
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(true, CREATED, 201, data);
    }

    public static <T> ApiResponse<T> error(String message, int statusCode) {
        return new ApiResponse<>(false, message, statusCode, null);
    }
}
