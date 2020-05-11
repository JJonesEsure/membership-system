package com.membership.system.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * The register model, this is the request for
 * the register endpoint and is the data given
 * in the body.
 * @author Jacob Jones
 *
 */
@Data
public class Register
{
    long uniqueEmployeeId;
    String firstName;
    String lastName;
    LocalDateTime dateOfBirth;
    String title;
    String email;
    String mobileNumber;
    String sex;
    String maritalStatus;
    String occupation;
    @Pattern(regexp="^[a-zA-Z0-9]{16}$")
    String cardId;
    @Pattern(regexp = "^[0-9]{4}$")
    String pin;
}
