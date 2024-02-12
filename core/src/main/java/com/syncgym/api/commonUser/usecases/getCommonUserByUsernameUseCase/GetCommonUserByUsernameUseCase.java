package com.syncgym.api.commonUser.usecases.getCommonUserByUsernameUseCase;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;

public interface GetCommonUserByUsernameUseCase {

    CommonUser execute(String username) throws CommonUserNotFoundException;
}
