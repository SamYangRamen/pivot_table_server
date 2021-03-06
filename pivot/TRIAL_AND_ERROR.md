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





## Database 연결



### Linux에 MariaDB 설치하는 과정

1. 설치

    - `sudo apt-get instrall mariadb-server`

2. 비밀번호 설정 (https://m.blog.naver.com/6116949/221992559683)

    1. `sudo mysql`

    2. 아래 둘 중 하나를 적용

       ```mariadb
       update user set plugin='' where User='root';
       set password = password('777777');
       flush privileges;
       ```

       ```mariadb
       set password for 'root'@'localhost' = password('777777');
       ```

3. DB 편집기

    - DBeaver 21.2.4 (https://dbeaver.io/download/)

4. Linux OS에 MariaDB를 설치했을 때 기본적으로 설정되는 URL

    - `jdbc:mysql://localhost:3306/`



### JPA vs MyBatis?

혼용하고자 한다.
단순한 CRUD 작업은 JPA를, 복잡한 데이터를 추출해야 하는 경우에는 직접 쿼리문을 작성하여 MyBatis를 통해 데이터를 가져올 수 있는 개발 환경을 구축해보고자 함



### JPQL 사용 시 주의점

https://stay-hungry.tistory.com/20

https://kkamdung.tistory.com/120

`JpaRepository`를 `extends`하는 Repository 안에서 어떤 메서드에 `@Query` Annotation을 붙이고 `SELECT ... FROM table_name` String을 안에 집어넣어줬을 때, 즉 `@Query("SELECT ... FROM table_name")` 라고 작성했을 때, 'table_name' 위치에는 실제 데이터베이스의 테이블명도 아니고 `@Table(name = "...")` Annotation 안의 '...'도 아닌, 해당 Entity의 클래스명을 입력해주어야 한다.



### JPA 사용 시 테이블명이 대문자일 때 테이블을 찾지 못하는 문제

https://velog.io/@gillog/JPA-Spring-Boot-JPA-Entity-Table-%EB%8C%80-%EC%86%8C%EB%AC%B8%EC%9E%90-%EA%B5%AC%EB%B6%84-%EB%AA%BB%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0-%ED%95%B4%EA%B2%B0

TEST_DB DB에 "TEST_TABLE"라는 이름의 테이블을 생성하고, Entity 클래스에 `@Table(name="TEST_TABLE")` 라고 작성하고 나서 앱을 실행하면, `Table 'TEST_DB.TEST_TABLE' doesn't exist' 에러가 발생한다. 그 이유는 Spring Boot의 기본 DB Physical Naming 전략이 아래와 같기 때문이다.

- **모든 도트는 밑줄**로 대체, **Camel Case 대문자는 밑줄**로 대체, 모든 **테이블은 소문자**로 구성

따라서 아래와 같은 설정을 `application.properties`에 추가해야 한다.

- `spring.jpa.hibernate.naming.physical-strategy = org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl`



### JPA 사용 시 delete가 안 되는 문제

https://velog.io/@moonyoung/JPA-JPA-Repository-%EC%88%98%EC%A0%95%EC%82%AD%EC%A0%9C%EC%99%80-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98

https://happyer16.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9A%94%EC%B2%ADrequest%EC%8B%9C-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%8B%9C%EC%9E%91%EC%9D%80-%EC%96%B4%EB%94%94%EC%84%9C-%ED%95%A0%EA%B9%8C

Custom delete 메서드에 `@Transactional` Annotation을 붙이면 정상적으로 delete가 된다.
