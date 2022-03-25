package com.ostk.workexperience.twittermachine.controller;

import javax.inject.Inject;

import org.jetbrains.annotations.Async;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ostk.workexperience.twittermachine.service.Twitter;

import lombok.extern.log4j.Log4j2;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
@RequestMapping(value = "/")
public class TwitterController {

  @Inject
  private Twitter twitter;


  @PostMapping(value = "SpamTweet")
  public ResponseEntity spamTweets(final String tweetMessage) {
    log.info("Message received: {}", tweetMessage);
    final String message = tweetMessage;
    int i = 0;
    while (i < 263)
      twitter.publish(message + i++);
    return ResponseEntity.ok("Message Successfully published");
  }

  @PostMapping(value = "hourly tweet")
  public ResponseEntity hourlyTweet(final String tweetMessage) {
    log.info("Message received: {}", tweetMessage);
    final String message = tweetMessage;
    twitter.publish(message);
    return ResponseEntity.ok("Message Successfully published");
  }
};

