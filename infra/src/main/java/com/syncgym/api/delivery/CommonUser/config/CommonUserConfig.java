package com.syncgym.api.delivery.CommonUser.config;

import com.syncgym.api.commonUser.usecases.createCommonUserUseCase.CreateCommonUserUseCaseImpl;
import com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase.GetByUsernameCommonUserUseCaseImpl;
import com.syncgym.api.delivery.CommonUser.impl.CommonUserServiceImpl;
import com.syncgym.api.delivery.CommonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.CommonUser.mappers.CommonUserResponseRestMapper;
import com.syncgym.api.delivery.CommonUser.mappers.CommonUserRestMapper;
import com.syncgym.api.permission.getPermissionByDescriptionUseCase.GetPermissionByDescriptionUseCase;
import com.syncgym.api.user.usecases.createUser.CreateUserUseCase;
import com.syncgym.api.user.usecases.findUserByUsername.FindUserByUsernameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUserConfig {

    @Autowired
    private FindUserByUsernameUseCase findUserByUsernameUseCase;

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
    public GetByUsernameCommonUserUseCaseImpl getByUsernameCommonUserUseCase() {
        return new GetByUsernameCommonUserUseCaseImpl(commonUserService(), findUserByUsernameUseCase);
    }
}
