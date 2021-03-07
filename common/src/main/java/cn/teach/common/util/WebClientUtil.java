package cn.teach.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class WebClientUtil {
    @Value(value = "${api.domain}")
    private String api;

    private WebClient webClient;

    public WebClientUtil() {
        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(clientDefaultCodecsConfigurer -> {
                    clientDefaultCodecsConfigurer.defaultCodecs()
                            .jackson2JsonEncoder(new Jackson2JsonEncoder(new ObjectMapper(), MediaType.APPLICATION_JSON));
                    clientDefaultCodecsConfigurer.defaultCodecs()
                            .jackson2JsonDecoder(new Jackson2JsonDecoder(new ObjectMapper(), MediaType.APPLICATION_JSON));

                }).build();

        this.webClient = WebClient.builder().exchangeStrategies(strategies).build();
    }

    public <T> T postRequest(String url, Object object, Class bodyType, ParameterizedTypeReference<T> type) {
        HttpHeaders requestHeaders = new HttpHeaders();
        Mono<T> result = webClient.method(HttpMethod.POST).uri(api + url).accept(MediaType.APPLICATION_JSON_UTF8).headers(new Consumer<HttpHeaders>() {

            @Override
            public void accept(HttpHeaders t) {
                for (String key : requestHeaders.keySet()) {
                    t.add(key, requestHeaders.getFirst(key));
                }
            }
        }).body(Mono.just(object), bodyType).retrieve().bodyToMono(type);

        return result.block();
    }

    public <T> AsyncWebClientResult<T> postRequestAsync(String url, Object object, Class bodyType, ParameterizedTypeReference<T> type) {
        HttpHeaders requestHeaders = new HttpHeaders();

        Mono<T> result = webClient.method(HttpMethod.POST).uri(api + url).accept(MediaType.APPLICATION_JSON_UTF8).headers(new Consumer<HttpHeaders>() {

            @Override
            public void accept(HttpHeaders t) {
                for (String key : requestHeaders.keySet()) {
                    t.add(key, requestHeaders.getFirst(key));
                }
            }
        }).body(Mono.just(object), bodyType).retrieve().bodyToMono(type);

        return new AsyncWebClientResult(result);
    }

    public <T> T getRequest(String url, Map<String, Object> object, ParameterizedTypeReference<T> type) {
        HttpHeaders requestHeaders = new HttpHeaders();
        url = api + url;
        if (object != null && !object.isEmpty()) {
            url += "?";
            for (String key : object.keySet()) {
                url += key + "=" + object.get(key) + "&";
            }

            url = url.substring(0, url.length() - 1);
        }

        Mono<T> result = webClient.method(HttpMethod.GET).uri(url).accept(MediaType.APPLICATION_JSON_UTF8).headers(new Consumer<HttpHeaders>() {

            @Override
            public void accept(HttpHeaders t) {
                for (String key : requestHeaders.keySet()) {
                    t.add(key, requestHeaders.getFirst(key));
                }
            }
        }).retrieve().bodyToMono(type);

        return result.block();
    }

    public <T> AsyncWebClientResult<T> getRequestAsync(String url, Map<String, Object> object, ParameterizedTypeReference<T> type) {
        HttpHeaders requestHeaders = new HttpHeaders();

        url = api + url;
        if (object != null && !object.isEmpty()) {
            url += "?";
            for (String key : object.keySet()) {
                url += key + "=" + object.get(key) + "&";
            }

            url = url.substring(0, url.length() - 1);
        }
        Mono<T> result = webClient.method(HttpMethod.GET).uri(url).accept(MediaType.APPLICATION_JSON_UTF8).headers(new Consumer<HttpHeaders>() {

            @Override
            public void accept(HttpHeaders t) {
                for (String key : requestHeaders.keySet()) {
                    t.add(key, requestHeaders.getFirst(key));
                }
            }
        }).retrieve().bodyToMono(type);

        return new AsyncWebClientResult(result);
    }
}