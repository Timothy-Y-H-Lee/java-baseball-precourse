# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## ︎💡 구현할 기능 목록
### ☕️ 객체 종류
* Computer : 상대방(컴퓨터)의 역할, 랜덤 숫자 3개를 가짐
* Player : 게임 플레이어는 컴퓨터가 선택한 숫자라고 생각되는 3개의 숫자를 입력
* Operator : 게임 진행자(MVC의 Controller 역할 담당. Computer의 기능 분리). 상대방(컴퓨터)이 가진 숫자 3개와 게임 플레이어가 제시한 숫자를 비교

### 🖨 게임 규칙을 사용자에게 출력
* MVC의 View단 - 문자열 출력 확인

### 🤹🏼 Operator(컨트롤러)
* Player가 입력한 값을 Computer에게 전달한다.
* Player가 입력한 값에 따라, Computer가 처리한 값을 전달받아, Player에게 응답
    * 이 때, 입력값이 3자리 미만 또는 초과, 0이 입력되면 입력한 값을 Computer에게 전달하지 않고,
      IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 💻 Computer
* 고정된 3자리의 숫자가 숫자 야구 게임의 컴퓨터가 제시한 숫자라고 가정하고, 같은 숫자가 Test Case에서 성공하는지 확인하는 Test Case
* 컴퓨터가 제시한 숫자라고 가정한 숫자의 길이가 3자리인지 확인하는 Test Case
    * Enum 또는 static final
* 컴퓨터가 제시한 숫자라고 가정한 숫자에서 중복된 숫자가 있는지 확인하는 Test Case
* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 통한 난수 발생 확인 Test Case
* 난수의 길이가 3자리인지 확인하는 Test Case
    * camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange()를 사용하는
      camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest() 사용
* 난수에서 중복된 숫자가 있는지 확인하는 Test Case
* 난수 3자리를 발생시키는 구문을 별도의 method로 작성하고 이름을 초기화 또는 설정과 관련된 이름을 method명으로 지정한 뒤,
  이 method호출이 성공하는지 확인하는 Test Case
* 난수 3자리를 발생시키는 구문을 별도의 method를 @BeforeAll로 설정(?)
* 야구 게임을 시작할 때에 3자리 숫자를 생성한 뒤, Operator에게 게임 시작 메시지 전달
* Operator가 전달해준 Player의 입력값에 따라, 야구 게임의 결과를 저장하고, Operator에게 결과를 가져가도록 메시지 전달

### 🧑🏻‍💻Player
* camp.nextstep.edu.missionutils.Console의 readLine()을 통한 입력 테스트
* baseball package의 ApplicationTest.게임종료_후_재시작() Test Case 성공 테스트
* Computer -> Operator -> Player 순서로 전달받은 결과를 보고, Operator에게 문제의 답이라고 생각되는 값을 전달
