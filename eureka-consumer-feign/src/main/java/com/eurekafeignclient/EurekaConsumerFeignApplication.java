package com.eurekafeignclient;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerFeignApplication {

//  @Bean
//  @LoadBalanced
//  public RestTemplate restTemplate() {
//
//    //Apache HttpClient supports gzip encoding.
//    // To use it, construct a HttpComponentsClientHttpRequestFactory like so:
//
//    //下面的代码构建的RestTemplate支持gzip编码，因为Apache的HttpClient支持gzip编码
//
//    HttpClient httpClient = HttpClientBuilder.create().build();
//    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
//        httpClient);
//    RestTemplate restTemplate = new RestTemplate(requestFactory);
//
//    return restTemplate;
//  }

//    @Bean
//    public AsyncRestTemplate asyncRestTemplate() {
//
//        //Apache HttpClient supports gzip encoding.
//        // To use it, construct a HttpComponentsClientHttpRequestFactory like so:
//
//        //下面的代码构建的RestTemplate支持gzip编码，因为Apache的HttpClient支持gzip编码
//
//        HttpAsyncClient httpAsyncClient = HttpAsyncClientBuilder.create().build();
//        AsyncClientHttpRequestFactory requestFactory = new HttpComponentsAsyncClientHttpRequestFactory(httpAsyncClient);
//        AsyncRestTemplate restTemplate = new AsyncRestTemplate(requestFactory);
//
//        return restTemplate;
//    }


  public static void main(String[] args) {
    new SpringApplicationBuilder(EurekaConsumerFeignApplication.class)
        .web(WebApplicationType.SERVLET).run(args);
  }

//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }


}
