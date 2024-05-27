# week3 assignment : spring MVC 이해

## 스프링 부트 사용하는 이유 
스프링 부트는 스프링을 편리하게 사용할 수 있도록 지원해주는 기술입니다.

1. 내장 웹서버가 제공되어 **별도의 웹서버를 설치할 필요가 없습니다.**
: 스프링은 별도의 외장 웹서버를 설치하고, war 파일을 생성하여 배포해야 했기 때문에 번거롭고 처리 속도도 느렸다.
: 스프링 부트는 내장 웹서버(톰캣 or 리액터 네티)를 가지고 있어서 별도의 작업없이 빠르게 서버를 실행할 수 있다.
: 내장 톰캣을 사용하기 위해서는 별도 설치 없이 build.gradle 아래 의존성을 추가해주면 된다.

    > org.springframework.boot:spring-boot-stater-web

    > @SpringBootApplication 어노테이션이 선언되어 있는 클래스의 main()을 실행하는 것만으로 서버를 구동시킬 수 있다.
2. 독립적으로 실행가능한 **JAR**을 통해 애플리케이션을 실행할 수 있습니다.
  
: 스프링 부트는 내장 Tomcat을 지원하기 때문에 웹 애플리케이션을 .jar 파일로 패키징해 웹 애플리케이션을 실행 시킬 수 있다.

3. **손쉬운 빌드 구성**을 위한 starter 종속성을 제공합니다.

: built.gradle에 필요한 라이브러리를 추가하면 필요한 나머지 라이브러리도 묶음으로 같이 받아와 줘서 편리하다.

> dependencies {
> 
>      implement 'org.springframework.boot:spring-boot-stater-web'
> }

4. **라이브러리 버전을 자동으로 관리해줍니다.**
: 프레임워크나 라이브러리에는 기본적으로 버전이 존재해서 올바르게 조합하지 않으면 예상치 못한 오류가 발생할 수 있다.
: 스프링에서는 개발자가 직접 버전 관리를 해야 했지만 스프링부트에서는 build.gradle에 스프링 부트 버전을 입력해 놓으면 알아서 다운로드 및 관리를 해준다.

   > plugins{
   > 
   >        id 'io.spring.dependency-management' version '1.1.0'
   >  }

과거의 Spring은 외장 Tomcat에 war 파일을 만들어 배포해야 했으며, 설정이 필요한 부분들을 직접 구성하는 등 번거로움이 상다히 많았다.

**스프링부트**는 이러한 스프링의 불편함과 문제점을 해결해서 _**손쉽게 애플리케이션을 만들고 실행할 수 있도록 도와준다.**_

---
## MVC

- model
  : 데이터와 관련된 부분
  : 모델 내부에 컨트롤러와 뷰에 관련된 코드가 있으면 안된다.

- view
  : 사용자에게 보여지는 부분
  : 뷰 내부에 모델의 코드만 있을 수 있고, 컨트롤러의 코드가 있으면 안된다.
  : 모델로부터 데이터를 받을 때, 사용자마다 다르게 보여줘야 하는 데이터에 대해서만 받아야 한다.

- controller
  : model과 view를 이어주는 부분
  : 컨트롤러 내부에는 모델과 뷰의 코드가 있을 수 있다.
  : 뷰가 데이터를 받을 떄는 반드시 컨트롤러를 통해서 받아야 한다.

---

### MVC 패턴이란?

1. 사용자가 웹 사이트에서 검색을 한다.
2. 컨트롤러가 모델에게 검색결과 데이터를 달라고 요청한다.
3. 컨트롤러가 모델에게 받은 데이터를 뷰에 전달한다.
4. 뷰는 사용자가 보는 UI에 검색 결과 데이터를 넣어서 웹 페이지를 보여준다.

MVC 패턴을 사용하면 각각의 요소가 분리되어 동작한다는 것을 알 수 있다.
유지보수 등의 관리가 쉽다는 장점이 있다.
---
### 로깅이란?
시스템 동작시 시스템의 상태와 작동 정보를 시간에 따라 기록하는 것이다.
그 기록을 로그라고 한다.

로깅에는 로그 레벨을 통해서 로그를 기록한다.

- Fatal : 매우 심각한 에러, 프로그램 종료됨
- Error : 의도하지 않은 에러, 프로그램 종료되지 않음
- Warn : 에러가 될 수 있는 잠재적 가능성
- Info : 명확한 의도가 있는 에러, 요구 사항에 따라 시스템 동작을 보여줄 때
- Debug : Info 레벨보다 더 자세한 정보가 필요한 경우, Dev 환경
- Trace : Debug 레벨보다 더 자세한 환경, Dev 환경에서 디버그하기 위해 사용
---
### sout 과 slf4j로 로깅

    > system.out.println()을 사용
        System.out.println("logging 로깅 !!");
        System.err.println("error 에러 !!");

    > Slf4j 사용
        logger.error("에러!! {}", count);
        logger.debug("디버그!! {}, count);
        logger.warn("워닝!! {}, count);
        logger.trace("트레이스!! {}, count);
        logger.info("인포!! {}, count);

---
### @Slf4j 애노테이션

클래스를 생성할 때마다 항상 로그를 남기기 위해 Logger 변수를 선언해야 했는데 
Lombok의 @Slf4j 어노테이션을 사용하면
자동으로 log 변수를 선언하여 편리하게 log를 찍을 수 있다.
변수명이 log로 고정된다.

    @Slf4j
    log.Info("인포!! 테스트!! ");
    log.warn("경고!!");
    ...
---
## Spring MVC 프레임워크

---

### @controller 어노테이션

[구글링](https://velog.io/@garamflow/%EC%8A%A4%ED%94%84%EB%A7%81-Controller-%EA%B5%AC%ED%98%84-%EB%B0%8F-%EA%B4%80%EB%A0%A8-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)

컨트롤러 어노테이션이 있는 클래스가 해당 웹 애플리케이션의 컨트롤러임을 의미한다.

스프링 컨테이너는 @controller 어노테이션이 지정된 클래스를 빈으로 등록하고, 요청을 해당 컨트롤러에 매핑하여 처리한다.

---

@controller 어노테이션이 지정된 클래스는 일반적으로 HTTP 요청을 처리하기 위한 **메소드**들을 포함한다.

@Controller
: 컨트롤러 어노테이션이 적용되면 스프링 빈으로 등록된다. 
Spring IoC 컨테이너가 관리하는 객체가 된다.

: 주로 View를 반환한다.

@ResponseBody
: Data를 반환할 때, 이 어노테이션을 활용하면 
자바 객체를 JSON 형태 데이터로 반환할 수 있다.

: 역으로 변환하는 것도 가능하다.

: HTTP 응답 본문에 작성된다.

> **json 객체 사용 이유**
> - 사람이 읽을 수 있는 문서이기 때문이다.
> - 특정 언어에 종속되지 않는다.
> - 경량 데이터이다.

@ResponseBody
: 

---   
    @Controller
    @RequestMapping("/products")
    public class ProductController {
        @Autowired
        private ProductService productService;

    @RequestMapping("/{id}")
    pubic ModelAndView getProduct(@PathVariable("id") int id) {
    ...