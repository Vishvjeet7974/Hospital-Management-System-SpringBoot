package Com.Singh.HospitalServices.ServicesImplement;


import Com.Singh.HospitalServices.Dto.UserRequestDto;
import Com.Singh.HospitalServices.Dto.UserResponseDto;
import Com.Singh.HospitalServices.Entity.User;
import Com.Singh.HospitalServices.Repository.UserRepository;
import Com.Singh.HospitalServices.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImplement implements UserServices {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    @Override
    public UserResponseDto createUserAccount(UserRequestDto userRequestDto) {
        User user= User.builder()
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .providerId(userRequestDto.getProviderId())
                .providerType(userRequestDto.getProviderType())
                .roles(userRequestDto.getRoles())
                .build();



        user =   userRepository.save(user);

        return modelMapper.map(user,UserResponseDto.class);

    }
}
