package com.codefactory.seat.controller;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.service.IGenerateSeats;
import com.codefactory.seat.service.ISeat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private ISeat seatService;

    @Autowired
    private IGenerateSeats generateSeats;

    @GetMapping("/getAvailableSeats")
    @Operation( responses = {
            @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = Seat.class)))) })
    public Iterable<Seat> getAvailableSeats(@RequestParam String status) {
        return seatService.getAvailableSeats(status.toUpperCase());
    }
    @Operation( responses = {
            @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = Seat.class)))) })
    @GetMapping("/generateSeats")
    public Iterable<Seat> generateSeats(@RequestParam String nSeats) {
        return generateSeats.createSeats(Integer.parseInt(nSeats));
    }

    



}
