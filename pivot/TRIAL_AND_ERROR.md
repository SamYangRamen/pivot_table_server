# 시행착오

본 토이 프로젝트를 진행하면서 막히거나 해결했던 부분들을 요약 정리한 내용을 작성함



## 테스트 코드 작성에 대하여



### JUnit Version 문제


HTTP 통신을 테스트하는 코드를 작성하기 위해 자료들을 검색해봤는데 `@RunWith` 라는 Annotation을 사용하는 예제를 보여주는 블로그들이 많았음
따라서 `@RunWith`를 사용해보려 했으나 Import가 되지 않아 좀 더 알아봤더니 최신 버전의 SpringBoot에서는 더 이상 볼 수 없게 되었다는 블로그 글이 있었음

https://www.whiteship.me/springboot-no-more-runwith/

요약하면, JUnit 4.x까지는 사용 가능하나, JUnit 5.x부터는 사용이 불가능하고 `@ExtendWith`를 대신 써야한다는 내용임. 그런데 `@SpringBootTest`가 이미 `@ExtendWith`를 가지고 있으므로 생략해도 된다고 함



### INFO: 0 containers and 1 tests were Method or class mismatch

테스트 Method를 N개 작성하였는데 그 중 N-1 이하의 개수만 실행하였을 경우 발생하는 메시지이므로 무시해도 됨

테스트 코드를 모두 실행하면 이 메시지는 발생하지 않음



## CORS Policy

한 컴퓨터에서 클라이언트 및 서버를 실행하고 서로에게 HTTTP 요청/응답을 보내려고 하면 **Access to XMLHttpRequest has been blocked by CORS policy** 라는 메시지를 콘솔에 띄우며 오류가 발생한다.
그 이유는 CORS Policy 때문임

https://coding-groot.tistory.com/91
https://kamang-it.tistory.com/entry/Web%EB%8F%99%EC%9D%BC-%EC%B6%9C%EC%B2%98-%EC%A0%95%EC%B1%85-CORS-%EB%8F%84%EB%8C%80%EC%B2%B4-%EB%AD%98%EA%B9%8C

따라서 CORS 표준을 지키기 위해 아래와 같은 클래스를 작성하였음

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "PUT", "POST", "DELETE");
  }
}
```

