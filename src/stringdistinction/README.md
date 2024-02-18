Java 3주차 Weekly 과제

---
##  괄호 짝 맞추기

<aside>
💡 괄호들이 올바른 순서와 짝을 이루고 있는지를 확인하는 프로그램을 만들어봅시다.

</aside>

###  예시 1

아래와 같이 괄호로 이루어진 문자열이 input으로 주어졌다고 가정해봅시다.

```java
((())())
```

위의 괄호는 올바른 순서와 짝을 이루었습니다.

- 여는 괄호 `(` 와 닫는 괄호 `)` 의 개수가 같습니다.
- 괄호가 올바른 순서로 되어있습니다. (여는 괄호 `(` 가 앞에 닫는 괄호 `)` 뒤에 있습니다.)

올바른 순서와 짝을 이룬 괄호이므로 output은 `true` 입니다.

### 예시 2

아래와 같이 괄호로 이루어진 문자열이 input으로 주어졌다고 가정해봅시다.

```java
(()()))(
```

위의 괄호는 올바르지 않습니다.

- 여는 괄호 `(` 와 닫는 괄호 `)` 의 개수가 같습니다.
- 하지만 괄호의 순서가 맞지 않습니다. (여는 괄호 `(` 보다 닫는 괄호 `)` 가 앞에 있습니다.)

올바르지 않은 괄호 이므로 output은 `false` 입니다.

### 예시 3

아래와 같이 괄호로 이루어진 문자열이 input으로 주어졌다고 가정해봅시다.

```java
((())
```

위의 괄호는 올바르지 않습니다.

- 여는 괄호 `(` 와 닫는 괄호 `)` 의 개수가 다릅니다. (짝이 맞지 않습니다.)
- 하지만 올바른 순서로 되어있습니다. (여는 괄호 `(` 가 앞에 닫는 괄호 `)` 뒤에 있습니다.)

올바르지 않은 괄호 이므로 output은 `false` 입니다.

### 힌트

자료구조 `스택` 을 사용합니다. 알고리즘을 간략히 설명하면 아래와 같습니다.

1. 주어진 문자열을 순회하면서 여는 괄호 `(` 인 경우 스택에 푸시(push)합니다.
2. 닫는 괄호 `)`를 만나면 스택이 비어있는지 확인하고, 만약 비어있다면 순서 혹은 짝이 맞지 않는 것이므로 `false`를 리턴합니다.
3. 닫는 괄호 `)`를 만났고 스택이 비어있지 않았다면 스택에서 팝(pop)하여 가장 최근에 푸시한 여는 괄호 `(`를 없애줍니다.
4. 문자열을 모두 순회한 뒤에도 스택에 여는 괄호 `(`가 남아있다면 짝이 맞지 않는 것이므로 `false`를 리턴합니다.
5. 문자열을 모두 순회한 뒤에 스택이 비어있다면 올바른 순서와 짝을 가진 괄호이니 `true`를 리턴합니다.