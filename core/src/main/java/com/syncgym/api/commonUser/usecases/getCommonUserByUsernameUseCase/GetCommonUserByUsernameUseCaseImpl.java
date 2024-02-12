package com.syncgym.api.commonUser.usecases.getCommonUserByUsernameUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.commonUser.ports.CommonUserRepositoryService;

public class GetCommonUserByUsernameUseCaseImpl implements GetCommonUserByUsernameUseCase {

    private final CommonUserRepositoryService commonUserRepository;


    public GetCommonUserByUsernameUseCaseImpl(CommonUserRepositoryService commonUserRepository) {
        this.commonUserRepository = commonUserRepository;
    }

    @Override
    public CommonUser execute(String username) throws CommonUserNotFoundException {
        return commonUserRepository.findByUsername(username)
                .orElseThrow(CommonUserNotFoundException::new);
    }
}
