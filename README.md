# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 연료 주입

- [x] 회사를 생성한다
    - [x] 차량 별 상태를 반환한다
- [x] 차를 생성한다
    - [x] 차가 이동할 거리를 인스턴스로 받는다
    - [x] 차종의 이름, 여행하려는 거리, 연비를 저장한다
    - [x] 주입해야 할 연료량을 구한다

## 1단계 - 블랙잭

### 입력

- [ ] 참여자 이름 입력 받는 기능
    - [ ] 쉼표 기준으로 입력받지 않을 경우
    - [ ] 공백을 입력받은 경우
    - [ ] 중복된 이름이 입력된 경우
- [ ] 한장 더 받는지 여부 확인 기능
    - [ ] y 또는 n이 아닌 문자를 입력받은 경우

### 블랙잭 게임 진행

- [x] 카드 생성
- [x] 플레이어 객체 생성
- [ ] 딜러, 참여자에게 두 장의 카드를 지급
- [ ] 카드 숫자 계산
    - [ ] 21을 초과 시 패배
    - [ ] Ace는 1 또는 11로 계산
    - [ ] King, Queen, Jack은 각각 10으로 계산
- [ ] 카드 추가 기능
    - [ ] 참여자 : 숫자를 합쳐 21을 초과하지 않으면 한장 더 받는지 묻기
    - [ ] 딜러 : 2장의 합계가 16이하이면 반드시 1장의 카드 추가
- [ ] 승패 계산 기능
    - [ ] 카드 숫자를 합쳐 21을 초과하지 않거나 21에 가깝게 만들면 이긴다

### 출력

- [ ] 카드 목록 및 점수 출력
- [ ] 최종 승패 결과 출력
