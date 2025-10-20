- [X] ## 자바 코드 컨벤션을 지키면서 프로그래밍했는가?
- ### `intellij-java-wooteco-style.xml` 적용

* https://google.github.io/styleguide/javaguide.html, https://myeonguni.tistory.com/1596 참고한다.
* IntelliJ 또는 Eclipse 통합 개발 도구에서 formatting을 한다.

---

- [X] ## 한 메서드에 오직 한 단계의 들여쓰기(indent)만 허용했는가?
- ### 검색 결과 들여쓰기 지속 외엔 한 단계까지만 존재.

---

- [X] ## else 예약어를 쓰지 않았는가?
- ### 검색 결과 `gradlew` 에만 존재.

---

- [X] ## 모든 원시값과 문자열을 포장했는가?
- ### 유의미한 원시값들은 포장.

---

- [X] ## 콜렉션에 대해 일급 콜렉션을 적용했는가?
- ### 연산 스택은 제외하고 래핑.

---

- [ ] ## 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?

```java
private Line preprocessingLine(String userInput) {
    String checkedLine = checkBlank(userInput);
    String custom = getCustom(checkedLine);
    String expression = getExpression(custom, checkedLine);
    return new Line(custom, expression);
}
```

- ### 가시성을 위한 변수 분리를 제거하면 3개 미만으로 구현 가능.
- ### 가시성보단 축약 단축이 더 우선시되는가?

* 쉽지 않은 연습일 수 있다. 가능하면 인스턴스 변수의 수를 줄이기 위해 노력한다.

---

- [ ] ## getter/setter 없이 구현했는가?

- ### 도메인 객체 간에도 데이터 전달이 발생하지 않나?
- ### getter/setter 없이 데이터 전달을 구현할 방법은?

* 핵심 로직을 구현하는 도메인 객체에 getter/setter를 쓰지 않고 구현했는가?
* 단, DTO는 허용한다.

---

- [X] ## 메소드의 인자 수를 제한했는가?
- ### Application 생성자 제외, 모든 메소드 통계
- ### 인자 0개 : 8
- ### 인자 1개 : 12
- ### 인자 2개 : 6
- ### 인자 3개 : 0

* 4개 이상의 인자는 허용하지 않는다.
* 3개도 가능하면 줄이기 위해 노력해 본다.

---

- [ ] ## 코드 한 줄에 점(.)을 하나만 허용했는가?

* 디미터(Demeter)의 법칙(“친구하고만 대화하라”)을 지켰는가?
* 예를 들어 location.current.representation.substring(0, 1)와 같이 여러 개의 점(.)이 등장하면 리팩토링할 부분을 찾아본다.

---

- [X] ## 메소드가 한가지 일만 담당하도록 구현했는가?

```java
    private Line preprocessingLine(String userInput) {
    String checkedLine = checkBlank(userInput);
    String custom = getCustom(checkedLine);
    String expression = getExpression(custom, checkedLine);
    return new Line(custom, expression);
}
```

- ### 위와 같이 전처리 메소드는
    - 라인을 검사하고,
    - 검사한 라인에서 커스텀 구분자를 추출하고,
    - 추출한 커스텀 구분자와 검사한 라인으로 수식을 추출하고,
    - 추출한 커스텀 구분자와 수식으로 라인 객체를 생성해 리턴한다.
- == 라인 처리라는 하나의 일을 수행한다.

---

- [X] ## 클래스를 작게 유지하기 위해 노력했는가?
- ### 10줄 내외의 메소드
- ### 10개 이내의 메소드