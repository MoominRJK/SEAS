package com.example.seas.person.dto;

import com.example.seas.security.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrganizatorDTO extends UserDTO {

    //validsasyon yaz.
    private boolean isOnline;
}
