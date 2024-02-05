package com.syncgym.api.delivery.paymentMethod.impl;

import com.syncgym.api.delivery.paymentMethod.PaymentMethodController;
import com.syncgym.api.delivery.paymentMethod.mappers.PaymentMethodRestMapper;
import com.syncgym.api.delivery.paymentMethod.responses.CreatePaymentMethodResponse;
import com.syncgym.api.delivery.paymentMethod.responses.GetPaymentMethodsResponse;
import com.syncgym.api.delivery.paymentMethod.rest.PaymentMethodRest;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.exceptions.CreatePaymentMethodException;
import com.syncgym.api.paymentMethod.usecases.createPaymentMethodUseCase.CreatePaymentMethodUseCase;
import com.syncgym.api.paymentMethod.usecases.getAllPaymentMethodsUseCase.GetAllPaymentMethodsUseCase;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/payment-method")
@Tag(name = "Payment Method", description = "Endpoint for payment methods management")
public class PaymentMethodControllerImpl implements PaymentMethodController {

    @Autowired
    private GetAllPaymentMethodsUseCase getAllPaymentMethodsUseCase;

    @Autowired
    private CreatePaymentMethodUseCase createPaymentMethodUseCase;

    @Autowired
    private PaymentMethodRestMapper paymentMethodReqMapper;

    @Override
    @Operation(summary = "Find all", description = "Find all payment methods",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = GetPaymentMethodsResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<SyncgymResponse<List<String>>> getPaymentMethods() throws SyncgymException {
        var res = new SyncgymResponse<>(CommonConstants.OK, CommonConstants.OK_STATUS, CommonConstants.SUCCESS_MESSAGE,
                getAllPaymentMethodsUseCase.execute().stream().map(PaymentMethod::name)
                        .collect(Collectors.toList()));

        return ResponseEntity.ok(res);
    }

    @Override
    @PostMapping
    @Operation(summary = "Create", description = "Create payment method",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = CreatePaymentMethodResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "401", description = "Unauthorized",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "403", description = "Forbidden",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
            }
    )
    public ResponseEntity<SyncgymResponse<PaymentMethodRest>> createPaymentMethod(@Valid @RequestBody final PaymentMethodRest paymentMethodReq) throws SyncgymException {
        try {
            createPaymentMethodUseCase.execute(paymentMethodReqMapper.mapToDomain(paymentMethodReq));
        } catch (CreatePaymentMethodException e) {
            throw new BadRequestException("Payment method already exists");
        }

        var res = new SyncgymResponse<>(CommonConstants.CREATED, CommonConstants.CREATED_STATUS, CommonConstants.SUCCESS_MESSAGE, paymentMethodReq);

        return ResponseEntity.status(CommonConstants.CREATED_STATUS).body(res);
    }
}
