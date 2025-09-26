package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CewDto {
    private String user_id;          	// user_id
    private String login_id;         	// login_id
    private String password;        	// password
    private String user_name;        	// user_name
    private String email;           	// email
    private String phone_number;     	// phone_number
    private String position;        	// position (권한/직급)
    private int status;             	// status (0,1 같은 값)
    private LocalDateTime created_at; 	// created_at
    private LocalDateTime updated_at; 	// updated_at
    private LocalDateTime expired_at; 	// expired_at (DATETIME)
}