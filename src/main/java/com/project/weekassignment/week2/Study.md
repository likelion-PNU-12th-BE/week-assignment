## 📕 [기본] **라이브러리와 프레임워크 비교해보기**
### 라이브러리란?
특정 기능을 수행하기 위한 함수나 클래스의 집합.
개발자가 직접 동작을 제어하는 관점이라고 보면 편함.

예를 들어 Java에서 CookieUtils 라는 라이브러리가 있다. 이 라이브러리는 Cookie 를 다루기 위한 기능들을 포함하고 있으며, 개발자가 직접 Cookie를 조작하기 위해 사용한다.
### 프레임워크
소프트웨어나 시스템 등을 쉽게 개발하고 구축할 수 있도록 마련되어 있는 구조.

예를 들어 Spring의 경우 비즈니스 로직 구현이 아닌 로직을 구현하기 위한 기술을 지원하게 되면서, 비즈니스 로직에 더 집중하여 효율적으로 개발할 수 있게 됨. 로직을 적용할 수 있는 기초적인 뼈대가 제공하여 개발 편리성을 제공함.
하지만 애플리케이션을 최적화하거나 효율적인 개발을 위해서는 프레임워크의 동작원리와 기능들을 학습해야하며, 오히려 개발보다 프레임워크를 이해하는데 많은 시간을 허비할 수 있는 단점이 존재함.

### 결론
라이브러리는 특정 기능을 구현하기 위한 도구의 모임이며, 동작을 직접 제어해야 한다. 그렇기 때문에 대규모 프로그램을 제작할 때 많은 동작을 직접 제어해야 한다.
반면 프레임워크는 개발자가 작성한 코드를 프레임워크의 구조에 맞게 동작하도록 하므로 대규모 개발에 적절하다.

#### 📕 **[기본]** 객체, 인스턴스 비교하기
##### 클래스란?
객체와 인스턴스를 비교하기 이전에 클래스에 대해서 이해할 필요가 있다.
클래스는 객체의 속성과 동작을 정의한 틀이나 템플릿이라고 생각하면 된다.
#####  객체란?
객체는 클래스의 인스턴스이다.
객체를 생성할 때 생성하려는 객체의 클래스의 인스턴스를 생성한다.
자바에서 객체를 생성할 때, 자체 속성 집합을 갖고 클래스에 정의된 동작을 기반으로 작업을 수생할 수 있는 해당 클래스의 인스턴스를 생성한다.
#####  인스턴스란?
인스턴스는 런타임 시 특정 클래스 객체가 메모리에 실제로 존재하는 상태이다. "new" 키워드를 사용하여 생성되며 상태를 저장하는 자체 인스턴스 변수 세트를 사용해 `고유한 메모리 할당`을 나타낸다. 구체적인 의미로는 실제로 메모리가 할당되어 동작하는 사례를 의미한다.

```
// Java Program to demonstrate 
// Object in Java 
import java.io.*; 

// Driver Class 
public class Person { 
	String name; 
	int age; 

	public void sayHello() 
	{ 
		System.out.println("Hello, my name is " + name 
						+ " and I'm " + age 
						+ " years old."); 
	} 

	// main function 
	public static void main(String[] args) 
	{ 
		Person person1 = new Person(); // 객체 생성
		person1.name = "kumar"; // 속성 1
		person1.age = 27; // 속성 2
		person1.sayHello(); // 동작

		Person person2 = new Person();  // 객체 생성
		person2.name = "Bob"; // 속성 1
		person2.age = 32; // 속성 2
		person2.sayHello(); // 동작
	} 
}
```
출력 :
```
Hello, my name is kumar and I'm 27 years old.  
Hello, my name is Bob and I'm 32 years old.
```

##### 결론
객체는 인스턴스와 동일하게 생각해도 충분하다. 그럼에도 구분하자면 객체는 변수와 메서드를 가지고 있는 논리적인 인스턴스라고 생각한다. 반대로 인스턴스는 객체의 동작을 물리적으로 수행하는 메모리 상태라고 생각한다.

#### 💻 **[기본]** 자바 객체 100개 생성 해보기
간단한 클래스를 생성한 뒤 객체를 100개 생성해보자

```
package com.project.weekassignment.week2;  
  
public class CreateObject100Times {  
  
    public static void main(String[] args) {  
       for (int i = 0; i < 100; i++) {  
          Service service = new Service();  
          System.out.println(service);  
       }  
    }  
}  
  
class Service {  
    public Service() {  
    }  
}
```
#### 💻 **[심화]** 100개의 객체 로그 찍어보기
출력 :
```
com.project.weekassignment.week2.Service@4517d9a3
com.project.weekassignment.week2.Service@372f7a8d
com.project.weekassignment.week2.Service@2f92e0f4
com.project.weekassignment.week2.Service@28a418fc
com.project.weekassignment.week2.Service@5305068a
.
.
.
.
```

매 인스턴스의 주소가 다름을 알 수 있다. 이는 매번 새로운 인스턴스가 생성됨을 의미한다.

## **싱글톤 패턴**

### 📕 **[기본]** 객체가 무한히 생성됐을 때의 문제점 알아보기
앞서 동일한 객체를 여러번 생성했다. 특정 동작을 해야한다면 그때마다 객체를 생성해서 대응하게 된다. 하지만 이를 여러번 실행할 경우 메모리에 클래스를 여러번 썼다 지웠다를 반복하게 되거나, 객체를 한번 생성할 때 많은 자원을 요구할 수도 있다. 이를 해결하려면 하나의 인스턴스만으로 동작해야 한다. 이렇게 되면 객체를 여러번 생성하는데 드는 비용을 절감할 수 있다.
### 📕 **[기본]** 싱글톤 패턴 알아보기
위 문제를 해결하기 위해서는 싱글턴 패턴(Singleton Pattern)이라는 디자인 패턴을 사용해야 한다. 싱글턴 패턴은 특정 클래스의 인스턴스가 하나만 생성되도록 보장하며, 이 인스턴스에 대한 글로벌 접근 지점을 제공한다. 그러므로 클래스에 대해 인스턴스는 하나만 존재하게 된다.
또한 전역 변수와 마찬가지로 싱글턴 패턴을 사용하면 프로그램의 모든 곳에서부터 접근할 수 있지만 인스턴스를 덮어쓰지 못하게 보호하는 장점이 있다.
### 💻 **[심화]** Java 코드로 싱글톤 패턴 구현해보기
```
package com.project.weekassignment.week2;  
  
public class SingletonTest {  
    public static void main(String[] args) {  
       for (int i = 0; i < 100; i++) {  
          Singleton singleton = Singleton.getInstance();  
          System.out.println(singleton);  
       }  
    }  
}  
  
class Singleton {  
    private static Singleton instance;  
  
    private Singleton() {  
    }  
  
    public static Singleton getInstance() {  
       if (instance == null) {  
          instance = new Singleton();  
       }  
  
       return instance;  
    }  
}
```
출력 :
```
com.project.weekassignment.week2.Singleton@4517d9a3
com.project.weekassignment.week2.Singleton@4517d9a3
com.project.weekassignment.week2.Singleton@4517d9a3
com.project.weekassignment.week2.Singleton@4517d9a3
.
.
.

```

매번의 인스턴스를 요청할때마다 동일한 인스턴스가 반환됨을 알 수 있다.

### 💻 **[심화]** Java 코드로 싱글톤 패턴 구현 확인해보기

## 📕 [심화] **왜 스프링을 써야하는지 고민해보기**

## **스프링 빈과 스프링 컨테이너**

### 📕 **[기본]** 스프링 빈이 무엇인지 알아보기
우리는 백엔드 프레임워크로써 스프링을 사용하기로 했다. 그러므로 스프링의 핵심 개념인 Bean 을 이해할 필요가 있다.
[스프링 공식 문서](https://docs.spring.io/spring-framework/reference/core/beans/introduction.html)에서는 빈을 이렇게 정의했다.
스프링에서 애플리케이션의 백본을 형성하고 스프링 IoC Container에 의해 관리되는 객체를 Bean 이라고 한다. 여기서 IoC 에 의해 관리된다는 것은 인스턴스화, 어셈블링 및 관리됨을 의미한다.
### 📕 **[기본]** 스프링 컨테이너가 무엇인지 알아보기
또 여기서 IoC Container는 무엇인지 알 필요가 있다. IoC(Inversion of Control)은 객체가 종속성을 생성하지 않고 정의하는 프로세스이다. 한 객체가 종속성을 생성하지 않는다는 것은 이 객체가 요구하는 다른 객체를 별도로 정의하지 않는다는 것을 의미한다. 즉 의존해야하는 객체를 생성하지 않고 정의하는 것이다. 이 의존성을 IoC Container 해결해준다. 필요한 의존성을 충족하는 것을 IoC Container에게 떠넘기는 방식이다. IoC Container가 등록된 인스턴스를 제공해서 의존성을 충족해주는 방식으로 동작한다.

### 📕 **[기본]** `@Bean`, `@Configuration` 애노테이션 알아보기
`@Bean`은 IoC 컨테이너에 Bean을 등록하는 어노테이션으로 직접 빈을 등록할 때 사용한다. 메서드에 적용한다.
`@Configuration`의 경우는 클래스에 지정하며 `@Bean`을 구성하기 위한 클래스라고 지정하는 역할을 한다.
`@Component` 어노테이션은 클래스에 지정하며 클래스를 `Bean`으로 등록하기 위한 어노테이션이다.
### 💻 **[기본] `@Bean`** 애노테이션으로 스프링 빈 만들어보기
### 💻 **[기본]** **`@Configuration`** 애노테이션으로 스프링 컨테이너에 빈 등록하기
### 💻 **[기본]** **`@Component`** 애노테이션으로 클래스 레벨 빈 만들어보기
### 💻 **[심화]** **`@ComponentScan`** 애노테이션으로 스프링 컨테이너에 빈 등록하기

별도의 디렉토리에서 애플리케이션을 구축하려다보니 컴포넌트와 컴포넌트 스캔까지 사용되었다. 각각의 역할은 다음과 같다.
1. `@Bean` 특정 객체를 IoC 컨테이너에 등록하기 위한 어노테이션. `@Configuration` 어노테이션이 적용된 클래스에서 사용되며, 메서드에 적용해서 등록한다.
2. `@Configuration` Bean 을 구성하기 위한 클래스를 지정하는 어노테이션. 클래스에 적용하는 어노테이션이다.
3. `@Component` 클래스를 Bean으로 등록하기 위한 어노테이션. 등록하려는 클래스에 적용한다.
4. `@ComponentScan` 설정된 경로에 있는 `@Component` 객체들이 DI 컨테이너에 등록되어 의존성을 해결해준다.

기존 의존관계의 객체 생성 방식
```
Address address = new Address("High Street", 1000);
Company company = new Company(address);
```
`@Bean`으로 변경된 방식
```
@Configuration  
@ComponentScan(basePackageClasses = Company.class)  
public class Config {  
    @Bean  
    public Address getAddress(){  
       return new Address("High Street", 1000);  
    }  
}
```

```
@Component  
public class Company {  
    private Address address;  
  
    public Company(Address address) {  
       this.address = address;  
    }  
  
    public Address getAddress() {  
       return address;  
    }  
  
    public void setAddress(final Address address) {  
       this.address = address;  
    }  
}
```

```
@SpringBootApplication  
public class MainApplication {  
    public static void main(String[] args) {  
       ApplicationContext context = new AnnotationConfigApplicationContext(  
          Config.class);  
  
       Company company = context.getBean("company", Company.class);  
       System.out.println("High Street".equals(company.getAddress().getStreet()));  
       System.out.println(1000 == company.getAddress().getNumber());  
    }  
}
```
## **의존 주입(DI ; Dependency Injection)**


### 📕 **[기본]** 의존 주입이 무엇인지 알아보기
하나의 객체가 다른 객체의 의존성을 제공하는 방법.  
예를 들어 클라이언트는 어떠한 서비스를 제공받아야 한다.  
이때 클라이언트가 어떤 서비스를 받는지 **지정하는 것이 아니다**.  
클라이언트에게 어떤 서비스인지를 **전달해주는 것이다**.  
이렇게 되면 클라이언트는 추상적으로 설계된 서비스를 정해진 동작으로 수행하지만, 
서비스의 구체화된 동작은 외부에서 제어할 수 있다.  
이 방식의 장점은 객체의 생성과 사용의 **관심을 분리**하는것이다.  
클라이언트와 서비스는 각각 자신의 동작만을 구현하면하면되므로, 가독성과 코드 재사용이 높아지는 효과가 있다.

### 📕 **[기본]** 스프링에서 어떻게 의존 주입이 일어나는지 알아보기
### 💻 **[기본]** Java 코드로 필드 주입 실습해보기
### 💻 **[기본]** Java 코드로 생성자 주입 실습해보기
### 💻 **[기본]** Java 코드로 Setter 주입 실습해보기
#### 1. 생성자 주입
생성자가 한번만 호출되는 특징을 활용하는 방법이다.
생성자 호출시점에 파라미터로 의존관계를 정의할 수 있다.
```
@Component
public class CustomServiceImpl implements Service {
    private final CustomRepository repository;
    
    @Autowired
    public CustomServiceImpl(CustomRepository repository) {
        this.repository = repository;
    }
}
```

#### 2. 수정자 주입 (setter 주입)
setter 메서드를 활용한 방법이다.
`@Autowired` 어노테이션이 setter 메서드에 붙게되며, 의존변수에서 final 설정이 사라진다.  
그러므로 해당 값이 바뀔 수 있다.
```
@Component
public class CustomServiceImpl implements Service {
    private CustomRepository repository;
    
    @Autowired
    public void setCustomRepository(CustomRepository repository) {
        this.repository = repository;
    }
}
```
#### 3. 필드 주입
필드값 자체에 주입하는 방법이 있다.
이 방법은 DI 기능이 동작하지 않으면 오류가 발생한다.
다르게 해석하면, DI 기능이 동작하지 않으면 외부에서 변경이 불가능하고 별도의 설정이 없으면 null 값으로 설정된다.

```
@Component
public class CustomServiceImpl implements Service {
    @Autowired
    private CustomRepository repository;
}
```
#### 4. 일반 메서드 주입
별도의 메서드에서 주입하는 방법.
setter 와 비슷한 방식이지만, 
```
@Component
public class CustomServiceImpl implements Service {
    private CustomRepository repository;
    
    @Autowired
    public void init(CustomRepository repository) {
        this.repository = repository;
    }
}
```


## **제어의 역전(IoC ; Inversion of Control)**
### 📕 **[기본]** 제어의 역전이 무엇인지 알아보기
프로그래머가 작성한 프로그램이 재사용 라이브러리의 흐름 제어를 받게 되는 소프트웨어 디자인 패턴.  
즉 내가 짠 코드를 프래임워크가 제어하는 것.
예를 들어 Controller, Service, Repository 를 작성하면 프레임워크가 자동으로 각 동작을 연결하는 방식.
