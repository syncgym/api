package com.syncgym.api.controllers;

import com.syncgym.api.data.dto.v1.PaymentMethodDTOV1;
import com.syncgym.api.data.dto.v1.security.TokenDTOV1;
import com.syncgym.api.services.PaymentMethodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/payment-method")
@Tag(name = "Payment Method", description = "Endpoint for Payment Method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    @Operation(summary = "Find all", description = "Find all payment methods",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = PaymentMethodDTOV1.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<?> findAll() {
        return paymentMethodService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find by id", description = "Find payment method by id",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = PaymentMethodDTOV1.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        return paymentMethodService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create", description = "Create payment method",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = PaymentMethodDTOV1.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            }
    )
    public ResponseEntity<?> create(@RequestBody PaymentMethodDTOV1 paymentMethodDTOV1) {
        return paymentMethodService.create(paymentMethodDTOV1);
    }

    @PutMapping
    @Operation(summary = "Update", description = "Update payment method",
            tags = {"Payment Method"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = PaymentMethodDTOV1.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            }
    )
    public ResponseEntity<?> update(@RequestBody PaymentMethodDTOV1 paymentMethodDTOV1) {
        return paymentMethodService.update(paymentMethodDTOV1);
    }
}
