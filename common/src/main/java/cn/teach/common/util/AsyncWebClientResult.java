package cn.teach.common.util;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class AsyncWebClientResult<T> {
    Mono<T> result;

    public AsyncWebClientResult(Mono<T> result) {
        this.result = result;
    }

    public T get() throws InterruptedException, ExecutionException, TimeoutException {
        return this.result.block(Duration.ofSeconds(10));
    }
}