# 2주차 스터디
### 블로그 링크
https://velog.io/@tim4974/BE-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88%EC%9D%B4-%EB%AD%90%EC%97%90%EC%9A%94
- SOLID 원칙이란?
- 프레임워크 VS 라이브러리
- 스프링 빈이란 무엇일까?
- 스프링 컨테이너란
- Singleton
- 컴포넌트 스캔
- 의존성 주입

### 파일 구조
```
- week2
  ├─ auto
  │   ├─ discount
  │   ├─ member
  │   ├─ order
  │   ├─ AutoAppConfig
  │   └─ OrderApp
  ├─ manual
  │   ├─ discount
  │   ├─ member
  │   ├─ order
  │   ├─ AppConfig
  │   ├─ OrderApp
  │   ├─ PureJavaAppConfig
  │   └─ PureJavaOrderApp
  └─ Study.md
```


## auto
auto 패키지는 @ComponentScan을 이용해 자동으로 스프링 빈을 컨테이너에 등록시키고 
각 클래스 마다 @Autowired 어노테이션을 통해 자동적으로 의존관계를 연결할 수 있도록 해주었습니다.
의존성 주입은 생성자 주입, 필드 주입, Setter주입을 혼용하여 사용하였습니다.

## manual
manual 패키지는 수동으로 스프링 빈에 등록하거나 순수 자바 코드를 통해 의존성 주입을 할 수 있도록 하였습니다.
AppConfig의 경우 @Configuration과 @Bean을 사용해 스프링 컨테이너에 빈을 등록하고 의존성 주입을 해주었습니다.
PureJavaAppConfig의 경우는 스프링 어노테이션 없이 순수 자바를 통해 의존성 주입을 하였습니다.

### discount
discount 인터페이스는 할인정책 인터페이스로 이를 구현한 FixDiscount(정액 할인), RateDiscount(정률 할인)가 있습니다.

### member
멤버 패키지는 MemoryMemberRepository, MemberServiceImpl을 통해 멤버를 메모리에 저장하고, 멤버를 조회 할 수 있도록 하였습니다.
MemberRepository의 경우 추후 다른 종류의 데이터베이스를 추가할 수 있도록 인터페이스로 구현하였습니다.
### order
주문 클래스는 멤버와 할인 정책을 모두 가진 클래스로 주문에 어떤 할인 정책을 적용할지 변경할 수 있도록 DiscountPolicy 인터페이스를 주입 받아 사용합니다.  