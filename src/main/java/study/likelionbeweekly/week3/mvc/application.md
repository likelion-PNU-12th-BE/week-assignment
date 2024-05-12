# 유저 로그인, 회원가입 기능 목록 정의

## INPUT
- [ ] 사용자에게 로그인, 회원가입, 종료 메뉴를 입력 받는다.
- [ ] 회원가입 할 아이디를 입력 받는다.
- [ ] 회원가입 할 비밀번호를 입력 받는다.
- [ ] 로그인 할 아이디를 입력 받는다.
- [ ] 로그인 할 비밀번호를 입력 받는다.

## OUTPUT
- [ ] 회원가입에 성공 메시지를 출력한다.
- [ ] 로그인에 성공하면 메시지를 출력한다.

## EXCEPTION
- [ ] 메뉴 입력 시 숫자가 아닌 잘못된 값을 입력하면 IllegalArgumentException 을 throw 한다.
- [ ] 이미 존재하는 아이디로 회원가입을 시도하면 IllegalArgumentException 을 throw 한다.
- [ ] 존재하지 않는 아이디로 로그인을 시도하면 IllegalArgumentException 을 throw 한다.
- [ ] 잘못된 비밀번호로 로그인을 시도하면 IllegalArgumentException 을 throw 한다.