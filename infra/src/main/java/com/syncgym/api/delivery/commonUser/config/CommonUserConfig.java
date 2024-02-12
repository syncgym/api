package com.syncgym.api.delivery.commonUser.config;

import com.syncgym.api.commonUser.usecases.createCommonUserUseCase.CreateCommonUserUseCaseImpl;
import com.syncgym.api.commonUser.usecases.getCommonUserByUsernameUseCase.GetCommonUserByUsernameUseCaseImpl;
import com.syncgym.api.delivery.commonUser.impl.CommonUserServiceImpl;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserResponseRestMapper;
import com.syncgym.api.delivery.commonUser.mappers.CommonUserRestMapper;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUserConfig {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetPermissionByDescriptionUseCase getPermissionByDescriptionUseCase;

    @Bean
    public CommonUserRepositoryMapper commonUserRepositoryMapper() {
        return new CommonUserRepositoryMapper();
    }

    @Bean
    public CommonUserResponseRestMapper commonUserResponseRestMapper() {
        return new CommonUserResponseRestMapper();
    }

    @Bean
    public CommonUserRestMapper commonUserRestMapper() {
        return new CommonUserRestMapper();
    }

    @Bean
    public CommonUserServiceImpl commonUserService() {
        return new CommonUserServiceImpl();
    }

    @Bean
    public CreateCommonUserUseCaseImpl createCommonUserUseCase() {
        return new CreateCommonUserUseCaseImpl(commonUserService(), createUserUseCase, getPermissionByDescriptionUseCase);
    }

    @Bean
    public GetCommonUserByUsernameUseCaseImpl getCommonUserByUsernameUseCase() {
        return new GetCommonUserByUsernameUseCaseImpl(commonUserService());
    }
}
