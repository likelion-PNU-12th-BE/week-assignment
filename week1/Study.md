# 멋쟁이 사자처럼 백엔드 스터디 1주차

## 목차

1. 클라이언트와 서버
2. TCP/IP
3. URI
4. HTTP
5. 개발자 도구

### 클라이언트와 서버

> client란 => 서비스 요청자, 서버에서 받은 서비스를 사용하는 사용자 ex\) 장치=> 노트북 등, 프로그램 => 웹 브라우저
> server란 => 네트워크를 통해 서비스를 제공하는 시스템

### TCP/IP

> TCP/IP => OSI 7 layer 중에서 네트워크와 전송 계층에서 사용하는 프로토콜
>
> > 프로토콜 => 정보를 주고 받은 때 사용되는 통신 규약
> > 네트워크 => 경로와 목적지 찾음 ex\) TCP/UDP
> > 전송 => 논리적 연결 담당(routing) ex\) IP

> TCP(Transmission Control Protocol)
>
> > Segment 사용
> > Port 이용해서 연결
> > TCP Header에 담겨 있는 정보로 신뢰성 보장, 흐름제어, 혼잡 제어 가능
> > 3 way handshake
> >
> > > TCP Header 내의 Syn, Syn/Ack, Ack 사용해서 통신 시도

> IP(Internet Protocol)
>
> > 패킷 사용 => Header에 패킷을 목적지까지 전송하기 위한 정보를 가지고 있다.
> > 비연결성 => 받은 대상이 없어도 패킷 전송
> > 비신뢰성 => 데이터가 정확하게 갔는지 확인하지 않음(전달 여부 보증 x), 순서가 달라질 수도 있다.
> > 같은 IP를 사용하는 서버에서 통신하는 어플이 여러 개일 경우 구분이 어렵다.

### URI(Uniform Resource Identifier)

> URL(Uniform Resource Locator) => 사용자가 원하는 정보의 위치와 종류를 파악할 수 있도록 웹페이지 정보 구조 반영
>
> > ex\) https://www.example.com:433/category/blog/index/html + query
> >
> > > https => 프로토콜 => 서버와 클라이언트 간에 어떤 방법으로 자원을 접근할지 알려주는 통신규약 ex\) ftp, http
> > > www => 서브 도메인 => 특정 웹사이트 접근하는데 사용
> > > example.com => 웹 서버의 위치를 지정
> > > 433 => 포트 => 자원을 접근하기 위해 사용하는 게이트 번호, 프로세스들의 주소 ex\) http -> 80
> > > category/blog => 서브 디렉토리 => 해당 페이지가 위치한 파일 시스템 경로
> > > index.html => 웹 페이지
> > > query => 추가적인 데이터, ?를 기점으로 key = value 형태로 표현

### http

> HyperText Transfer Protocol

### 개발자 도구(Devtools)

1. Elements panel => 웹 페이지의 구성과 CSS를 알 수 있다.
2. Console panel => 동작하기 위한 패널, 브라우저가 어떻게 동작하는지 조절, JS 코드 즉시 실행 가능
3. Network panel => 웹 사이트에서 통신하고 있는 모든 정보, 리소스들이 예상대로 다운로드, 업데이트 되는지, 웹 페이지와 서버 사이에서 데이트 흐름을<br>
   분석하고, 문제 발생시 해결책 찾도록 개발자 지원
4. Application panel
