package com.membership.system.model;

import java.time.LocalDateTime;

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
    String firstName;
    String lastName;
    LocalDateTime dateOfBirth;
    String title;
    String email;
    String sex;
    String maritalStatus;
    String occupation;
    String userName;
    String password;
}
