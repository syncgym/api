package com.syncgym.api.delivery.subscription.impl;

import com.syncgym.api.commonUser.exceptions.CommonUserNotFoundException;
import com.syncgym.api.delivery.subscription.SubscriptionController;
import com.syncgym.api.delivery.subscription.mappers.SubscriptionResponseRestMapper;
import com.syncgym.api.delivery.subscription.responses.ListOfSubscriptionResponse;
import com.syncgym.api.delivery.subscription.responses.SubscriptionResponse;
import com.syncgym.api.delivery.subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.delivery.subscription.rest.SubscriptionRest;
import com.syncgym.api.plan.exceptions.PlanNotFoundException;
import com.syncgym.api.shared.constants.CommonConstants;
import com.syncgym.api.shared.exceptions.BadRequestException;
import com.syncgym.api.shared.exceptions.NotFoundException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.exceptions.handler.ExceptionResponse;
import com.syncgym.api.shared.responses.SyncgymResponse;
import com.syncgym.api.subscription.exceptions.SubscriptionNotFoundException;
import com.syncgym.api.subscription.usecases.createSubscriptionUseCase.CreateSubscriptionUseCase;
import com.syncgym.api.subscription.usecases.getActiveSubscriptionByUserUseCase.GetActiveSubscriptionByUserUseCase;
import com.syncgym.api.subscription.usecases.getAllSubscriptionsByUserUseCase.GetAllSubscriptionsByUserUseCase;
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

@RestController
@RequestMapping("/api/v1/subscription")
@Tag(name = "Subscription", description = "Endpoint for subscription management")
public class SubscriptionControllerImpl implements SubscriptionController {

    @Autowired
    private CreateSubscriptionUseCase createSubscriptionUseCase;

    @Autowired
    private GetAllSubscriptionsByUserUseCase getAllSubscriptionsByUserUseCase;

    @Autowired
    private GetActiveSubscriptionByUserUseCase getActiveSubscriptionByUserUseCase;

    @Autowired
    private SubscriptionResponseRestMapper subscriptionResponseRestMapper;

    @Override
    @GetMapping("/{username}")
    @Operation(summary = "Get all subscriptions by user", description = "Get all subscriptions by user",
            tags = {"Subscription"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = ListOfSubscriptionResponse.class))),
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
    public ResponseEntity<SyncgymResponse<List<SubscriptionResponseRest>>> getSubscriptionsByUser(@PathVariable("username") String username) throws SyncgymException {
        var subscriptions = getAllSubscriptionsByUserUseCase.execute(username);

        var res = new SyncgymResponse<>(
                CommonConstants.OK,
                CommonConstants.OK_STATUS,
                CommonConstants.SUCCESS_MESSAGE,
                subscriptions.stream().map(subscriptionResponseRestMapper::mapToRest).toList()
        );

        return ResponseEntity.status(CommonConstants.OK_STATUS).body(res);
    }

    @Override
    @GetMapping("/active/{username}")
    @Operation(summary = "Get active subscription by user", description = "Get active subscription by user",
            tags = {"Subscription"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = SubscriptionResponse.class))),
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
    public ResponseEntity<SyncgymResponse<SubscriptionResponseRest>> getActiveSubscriptionByUser(@PathVariable("username") String username) throws SyncgymException {
        try {
            var subscription = getActiveSubscriptionByUserUseCase.execute(username);

            var res = new SyncgymResponse<>(
                    CommonConstants.OK,
                    CommonConstants.OK_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    subscriptionResponseRestMapper.mapToRest(subscription)
            );

            return ResponseEntity.status(CommonConstants.OK_STATUS).body(res);
        } catch (SubscriptionNotFoundException e) {
            throw new NotFoundException("Subscription not found for user: " + username);
        }
    }

    @Override
    @PostMapping
    @Operation(summary = "Create subscription", description = "Create subscription",
            tags = {"Subscription"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = SubscriptionResponse.class))),
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
    public ResponseEntity<SyncgymResponse<SubscriptionResponseRest>> createSubscription(@Valid @RequestBody SubscriptionRest subscriptionRest) throws SyncgymException {
        try {
            var subscription = createSubscriptionUseCase.execute(subscriptionRest.planName(), subscriptionRest.userUsername(), subscriptionRest.monthsDuration());

            var res = new SyncgymResponse<>(
                    CommonConstants.CREATED,
                    CommonConstants.CREATED_STATUS,
                    CommonConstants.SUCCESS_MESSAGE,
                    subscriptionResponseRestMapper.mapToRest(subscription)
            );

            return ResponseEntity.status(CommonConstants.CREATED_STATUS).body(res);
        } catch (PlanNotFoundException e) {
            throw new BadRequestException("Plan not found: " + subscriptionRest.planName());
        } catch (CommonUserNotFoundException e) {
            throw new BadRequestException("User not found: " + subscriptionRest.userUsername());
        }
    }
}
