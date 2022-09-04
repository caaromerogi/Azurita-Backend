package com.azurita.azuritaweb.Security.DTO;

import com.azurita.azuritaweb.Security.enums.RoleName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO {

    private Long id;

    private RoleName roleName;

}
