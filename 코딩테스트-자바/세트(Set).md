
# Set
유일한 요소들의 컬렉션.
+ 유일성 : 중복된 요소가 존재하지 않는다. 셋에 요소 추가 시, 중복되는 요소가 존재하면 무시된다.
+ 순서 미보장 : 순서가 보장되지 않는다.
+ 빠른 검색 : 요소의 유무를 빠르게 확인할 수 있도록 최적화되어 있다.


## 해시 사용
배열을 통해 조회하고 반환하는 로직은 O(N)의 시간이 소모된다. 해시를 사용하면 조회 성능을 O(1)로 고도화할 수 있다.


## Set 인터페이스
`HashSet`, `LinkedHashSet`, `TreeSet`은 `Set` 인터페이스를 구현한다.

### 등록
+ add()
+ addAll()

### 조회
+ contains()
+ containsAll()
+ isEmpty()
+ iterator()

### 삭제
+ remove()
+ removeAll()
+ retainAll()
+ clear()

### 수정
+ toArray()


## HashSet 

`데이터의 유일성`, `순서가 중요하지 않을 경우`

## LinkedHashSet 

`HashSet` 에 `LinkedList`를 병합한 것과 같다. 주요 연산은 O(1)의 시간을 소모한다. 단 `LinkedList`와 관련된 연산은 O(N)의 시간을 소모한다.
