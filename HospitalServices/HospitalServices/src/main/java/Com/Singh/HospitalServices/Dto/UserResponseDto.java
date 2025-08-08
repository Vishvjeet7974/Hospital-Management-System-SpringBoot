package Com.Singh.HospitalServices.Dto;

import Com.Singh.HospitalServices.Entity.Type.AuthProviderType;
import Com.Singh.HospitalServices.Entity.Type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;
    private String username;
    private String providerId;
    private AuthProviderType providerType;
    private Set<RoleType> roles;

}
