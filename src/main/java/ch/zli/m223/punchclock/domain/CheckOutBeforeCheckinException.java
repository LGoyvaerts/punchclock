package ch.zli.m223.punchclock.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Checkout before checkin!")
public class CheckOutBeforeCheckinException extends RuntimeException {}
