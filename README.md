# kotlin-calculator-precourse

## 구현해야하는 기능 목록

- [ ] 빈 문자열이 입력으로 들어오면 0을 출력
- [ ] 쉼표(,)로 구분된 문자열의 합 계산
- [ ] 콜론(:)으로 구분된 문자열의 합 계산
- [ ] 커스텀 구분자 지정 기능 (`//;\n1;2;3` → 6)
- [ ] 잘못된 입력 시 IllegalArgumentException 발생
- [ ] 결과를 "결과 : n" 형태로 출력


## 아키텍처 구조

본 프로그램은 MVC(Model-View-Controller) 아키텍처를 기반으로 구성한다.

- Model: 입력된 문자열을 파싱하고 계산 로직을 담당한다.
- View: 사용자 입력 및 결과 출력을 담당한다.
- Controller: Model과 View를 연결하며 전체 흐름을 제어한다.

calculator/
├── model/
│ └── CalculatorModel.kt
├── view/
│ └── CalculatorView.kt
├── controller/
│ └── CalculatorController.kt
└── App.kt