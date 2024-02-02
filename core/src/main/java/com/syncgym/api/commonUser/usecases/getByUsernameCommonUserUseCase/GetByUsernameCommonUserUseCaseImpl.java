package com.syncgym.api.commonUser.usecases.getByUsernameCommonUserUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.commonUser.ports.CommonUserRepositoryService;
import com.syncgym.api.user.exceptions.UserNotFoundException;
import com.syncgym.api.user.usecases.findUserByUsername.FindUserByUsernameUseCase;

public class GetByUsernameCommonUserUseCaseImpl implements GetByUsernameCommonUserUseCase {

    private final CommonUserRepositoryService commonUserRepository;

    private final FindUserByUsernameUseCase findUserByUsernameUseCase;

    public GetByUsernameCommonUserUseCaseImpl(CommonUserRepositoryService commonUserRepository, FindUserByUsernameUseCase findUserByUsernameUseCase) {
        this.commonUserRepository = commonUserRepository;
        this.findUserByUsernameUseCase = findUserByUsernameUseCase;
    }

    @Override
    public CommonUser execute(String username) throws CommonUserNotFoundException {
        try {
            var user = findUserByUsernameUseCase.execute(username);

            return commonUserRepository.findById(user.id())
                    .orElseThrow(CommonUserNotFoundException::new);
        } catch (UserNotFoundException e) {
            throw new CommonUserNotFoundException();
        }
    }
}
