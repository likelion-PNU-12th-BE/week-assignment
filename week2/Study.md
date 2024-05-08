# week2-assignment

## 객체 생성 알아보기

- week2/likelion-BE-weekly/src/Main 파일에서 확인할 수 있습니다.
- 반복문을 통해서 TV 객체 100개를 생성하였습니다.
- toString 함수를 사용해서 객체의 로그롤 출력하였습니다.

## 스프링 빈과 스프링 컨테이너

- 인프런 김영한 강사님의 강의를 보면서 따라했습니다.
- week2/hello-spring/src/main/java/hello/hellospring/service/SpringConfig에서 확인할 수 있습니다.
- @Bean과 @Configuration을 통해서 스프링 빈을 만들고, 스프링 컨테이너에 등록해보았습니다.
- @Component 어노테이션은 직접 컨트롤 가능한 클래스에 사용하며, week2/hello-spring/src/main/java/hello/hellospring/repository/MemoryMemberRepository에서 확인할 수 있습니다.
- MemoryMemberRepository 클래스에 @Component 에노테이션을 붙임으로서 사용할 수 있다. 프로젝트에서 @Bean과 @Configuration을 통한 방법을 사용했기 때문에 주석 처리하였습니다.

## 의존 주입

- week2/hello-spring/src/main/java/hello/hellospring/controller/MemberController에서 확인할 수 있습니다.
- 필드 주입, setter 주입, 생성자 주입을 구현해보았고, 필드 주입과 setter 주입은 주석 처리하였습니다.
