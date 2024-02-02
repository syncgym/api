package com.syncgym.api.delivery.PaymentMethod.config;

import com.syncgym.api.delivery.PaymentMethod.impl.PaymentMethodServiceImpl;
import com.syncgym.api.delivery.PaymentMethod.mappers.PaymentMethodRepositoryMapper;
import com.syncgym.api.delivery.PaymentMethod.mappers.PaymentMethodRestMapper;
import com.syncgym.api.paymentMethod.usecases.createPaymentMethodUseCase.CreatePaymentMethodUseCaseImpl;
import com.syncgym.api.paymentMethod.usecases.getAllPaymentMethodsUseCase.GetAllPaymentMethodsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentMethodConfig {

    @Bean
    public PaymentMethodRepositoryMapper paymentMethodRepositoryMapper() {
        return new PaymentMethodRepositoryMapper();
    }

    @Bean
    public PaymentMethodRestMapper paymentMethodReqMapper() {
        return new PaymentMethodRestMapper();
    }

    @Bean
    public PaymentMethodServiceImpl paymentMethodService() {
        return new PaymentMethodServiceImpl();
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
