package com.DiamondCafe.DiamondCafe.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @CREATED 04/05/2023 - 4:11 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Data
@Getter
@Setter
public class ServiceResponse {
    private Boolean bool;
    private String message;
}