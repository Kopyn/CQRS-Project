package com.kopyn.cqrs.client.web;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "jplaceholder", url = "localhost:something")
public class WebClient {
}
