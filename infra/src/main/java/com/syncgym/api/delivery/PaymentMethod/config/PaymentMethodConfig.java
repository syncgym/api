package com.syncgym.api.delivery.PaymentMethod.config;

import com.syncgym.api.delivery.PaymentMethod.impl.PaymentMethodServiceImpl;
import com.syncgym.api.delivery.PaymentMethod.mappers.PaymentMethodRepositoryMapper;
import com.syncgym.api.delivery.PaymentMethod.mappers.PaymentMethodReqMapper;
import com.syncgym.api.delivery.PaymentMethod.repositories.PaymentMethodRepository;
import com.syncgym.api.paymentMethod.usecases.createPaymentMethodUseCase.CreatePaymentMethodUseCaseImpl;
import com.syncgym.api.paymentMethod.usecases.getAllPaymentMethodsUseCase.GetAllPaymentMethodsUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentMethodConfig {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Bean
    public PaymentMethodRepositoryMapper paymentMethodRepositoryMapper() {
        return new PaymentMethodRepositoryMapper();
    }

    @Bean
    public PaymentMethodReqMapper paymentMethodReqMapper() {
        return new PaymentMethodReqMapper();
    }

    @Bean
    public PaymentMethodServiceImpl paymentMethodService() {
        return new PaymentMethodServiceImpl(paymentMethodRepository, paymentMethodRepositoryMapper());
    }

    @Bean
    public GetAllPaymentMethodsUseCaseImpl getAllPaymentMethodsUseCase() {
        return new GetAllPaymentMethodsUseCaseImpl(paymentMethodService());
    }

    @Bean
    public CreatePaymentMethodUseCaseImpl createPaymentMethodUseCase() {
        return new CreatePaymentMethodUseCaseImpl(paymentMethodService());
    }
}
