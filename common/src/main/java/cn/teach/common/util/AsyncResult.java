package cn.teach.common.util;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncResult<T> {
    ListenableFuture<ResponseEntity<T>> result;

    public AsyncResult(ListenableFuture<ResponseEntity<T>> result) {
        this.result = result;
    }

    public T get() throws InterruptedException, ExecutionException, TimeoutException {
        ResponseEntity<T> getResult = this.result.get(10, TimeUnit.SECONDS);
        return getResult.getBody();
    }
}