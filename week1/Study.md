# 멋쟁이 사자처럼 백엔드 스터디 1주차

## 목차

1. 클라이언트와 서버
2. TCP/IP
3. URI
4. HTTP
5. 개발자 도구

### 클라이언트와 서버

- client란 => 서비스 요청자, 서버에서 받은 서비스를 사용하는 사용자 ex\) 장치=> 노트북 등, 프로그램 => 웹 브라우저
- server란 => 네트워크를 통해 서비스를 제공하는 시스템

### TCP/IP

##### TCP/IP => OSI 7 layer 중에서 네트워크와 전송 계층에서 사용하는 프로토콜

- 프로토콜 => 정보를 주고 받은 때 사용되는 통신 규약
- 네트워크 => 경로와 목적지 찾음 ex\) TCP/UDP
- 전송 => 논리적 연결 담당(routing) ex\) IP

##### TCP(Transmission Control Protocol)

- Segment 사용
- Port 이용해서 연결
- TCP Header에 담겨 있는 정보로 신뢰성 보장, 흐름제어, 혼잡 제어 가능
- 3-WayHandshake
  1. 클라이언트에서 서버에게 SYN 메시지를 보내서 접속을 허락해달라고 요청
  2. 서버는 접속을 수락하고, ACK메시지를 클라이언트에게 전송하면서, 서버의 접속을 요구하는 SYN메세지를 함께 전송한다.
  3. 클라이언트가 접속을 수락하면 서버에게 ACK 메시지를 전송한다.
  4. 연결이 되면 데이터 전송을 시작한다.

##### IP(Internet Protocol)

- 패킷 사용 => Header에 패킷을 목적지까지 전송하기 위한 정보를 가지고 있다.
- 비연결성 => 받은 대상이 없어도 패킷 전송
- 비신뢰성 => 데이터가 정확하게 갔는지 확인하지 않음(전달 여부 보증 x), 순서가 달라질 수도 있다.
- 같은 IP를 사용하는 서버에서 통신하는 어플이 여러 개일 경우 구분이 어렵다.

### URI(Uniform Resource Identifier)

URN (Uniform Resource Name)

- Name: 리소스에 이름을 부여한다.

URL(Uniform Resource Locator)

- Locator: 리소스가 있는 위치를 지정한다.

ex\) https://www.example.com:433/category/blog/index/html + query

- https => 프로토콜 => 서버와 클라이언트 간에 어떤 방법으로 자원을 접근할지 알려주는 통신규약 ex\) ftp, http
- www => 서브 도메인 => 특정 웹사이트 접근하는데 사용
- example.com => 웹 서버의 위치를 지정
- 433 => 포트 => 자원을 접근하기 위해 사용하는 게이트 번호, 프로세스들의 주소 ex\) http -> 80
- category/blog => 서브 디렉토리 => 해당 페이지가 위치한 파일 시스템 경로
- index.html => 웹 페이지
- query => 추가적인 데이터, ?를 기점으로 key = value 형태로 표현

### http(HyperText Transfer Protocol)

문서 간의 링크를 통해서 하이퍼텍스트 문서를 통해서 연결하는 프로토콜. HTML, TEXT, IMAGE, 음석, 영상, 파일 등 모든 형태의 데이터를 담아서 전송이 가능하며, 서버 간에 데이터를 주고 받을 때도 사용한다.

##### 웹 브라우저 요청 흐름

1. URL을 입력한다.
2. DNS 서버로 IP를 찾아내고 생략된 포트는 scheme로 찾아낸다.
3. 웹 브라우저가 HTTP 요청 메시지를 생성한다.
4. SOCKET 라이브러리를 통해서 TCP/IP로 찾은 IP와 PORT 정보를 3-WayHandshake 방식으로 서버와 연결한다.
5. HTTP 요청 메시지는 OS에 있는 TCP/IP 계층으로 전달한다.
6. TCP/IP 계층에서 HTTP 요청 메시지를 패킷으로 감싼다.
7. 웹 브라우저가 만든 요청 패킷이 서버에 도착하면 패킷을 열어서 HTTP 요청 메시지를 확인하여 서버가 해석한다.
8. 서버가 HTTP 응답 메시지를 만들어서 TCP/IP 패킷을 감싸서 클라이언트에게 도착하면 패킷을 클라이언트가 해석한다.
9. 웹 브라우저가 HTML을 랜더링해서 클라이언트가 HTML 결과를 볼 수 있게 된다.

##### HTTP 특징

- 상태유지 - Stateful
  서버가 클라이언트의 상태를 보존해야하는 것을 말한다.
  ex\) 로그인한 사용자가 로그인 중이라는 상태를 서버에 유지해야한다.

- 무상태 - Stateless
  서버가 클라이언트의 상태를 보존하지 않는다. 클라이언트가 정보를 담아서 요청을 하면 서버는 상태를 보존하지 않고, 응답만 한다.
  로그인할 필요가 없는 단순한 소개 페이지일 때 상태를 유지할 필요가 없기 때문에 무상태가 유리하다.

##### HTTP 메시지

HTTP 요청 메시지

- http method와 Request target, HTTP version으로 구성되어 있다.

HTTP 응답 메세지

- HTTP-version, HTTP 상태 코드, 이유 문구로 구성되어 있다.
- HTTP Header
  헤더에 포함될 수 있는 정보
- Content-Type
- Content-Encoding
- Content-Language
- Content-Length
- From, Referer, Date 등의 일반 정보
- Host, Location, Allow, Retry-After 같은 특별한 정보
- 인증
- 쿠키
- 캐시 관련 정보

Body
실제 전송할 데이터가 담겨있다. HTML 문서, 이미지, 영상 , JSON 등 byte로 표현할 수 있는 모든 데이터 전송이 가능하며, 헤더에 명시되어 있는 정보들에 따라 Body의 데이터가 어떻게 해석되어야 하는지 알 수 있다.

### 개발자 도구(Devtools)

1. Elements panel => 웹 페이지의 구성과 CSS를 알 수 있다.
2. Console panel => 동작하기 위한 패널, 브라우저가 어떻게 동작하는지 조절, JS 코드 즉시 실행 가능
3. Network panel => 웹 사이트에서 통신하고 있는 모든 정보, 리소스들이 예상대로 다운로드, 업데이트 되는지, 웹 페이지와 서버 사이에서 데이트 흐름을<br>
   분석하고, 문제 발생시 해결책 찾도록 개발자 지원
4. Application panel
