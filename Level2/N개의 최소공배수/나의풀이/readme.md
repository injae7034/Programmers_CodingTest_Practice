# 내가 풀이한 코드
```java
class Solution {
    public int solution(int[] arr) {
        int bigger = 0;
        int smaller = 0;
        int commonMinMultiple = 0;
        int multiple = 0;
        for(int i  = 0; i < arr.length - 1; i++)
        {
            bigger = Math.max(arr[i], arr[i + 1]);
            smaller = Math.min(arr[i], arr[i + 1]);
            commonMinMultiple = bigger;
            multiple = 2;
            while(commonMinMultiple % smaller != 0)
            {
                commonMinMultiple = bigger * multiple;
                multiple++;
            }
            arr[i + 1] = commonMinMultiple;
        }
        return commonMinMultiple;
    }
}
```

# 내가 풀이한 코드 설명하기
매개변수로 주어진 arr배열에 저장된 배열원소들의 최소공배수를 구하기 위한 방법으로<br><br>
저는 먼저 앞의 두 원소끼리 최소공배수를 구하고 그 최소공배수와 다음 배열요소와 최소공배수를 구하는 방법을 이용했습니다.<br><br>
이를 위해 더 큰 수를 저장할 bigger 작은 수를 저장할 smaller 최소공배수를 저장할 commonMinMultiple, commonMinMultiple을 구할 때 이용되는 배수인 multiple을 선언하였습니다.<br><br>
i = 0부터 arr의 length에서 1을 뺀값보다 작은동안 반복합니다.<br><br>
-1을 해주는 이유는 반복문 내부에서 arr의 i번째 배열요소와 i + 1번째 배열요소를 비교하기 때문에 arr의 길이에 -1을 뺀 값보다 작은동안 반복을 해야<br><br>
indexOutOfBoundsException이 발생하는 것을 막을 수 있습니다.<br><br>
반복문 내부에서 Math의 max메소드를 호출하여 arr의 i번째와 i+1번째 배열요소 중 더 큰 값을 bigger에 담습니다.<br><br>
Math의 min을 통해 smaller도 구합니다.<br><br>
bigger를 commonMinMultiple에 저장하고, multiple값을 2로 초기화해줍니다.<br><br>
commonMinMultiple를 smaller로 나눈 나머지가 0이 아닌동안 반복을 합니다.<br><br>
반복문 내부에서 commonMinMultiple에 bigger에 multiple을 곱한 값을 저장하고,<br><br>
multiple의 값을 1 증가시켜줍니다.<br><br>
반복문이 끝나면 commonMinMultiple에는 smaller와 bigger의 최소공배수 값이 저장될 것입니다.<br><br>
이 값을 arr의 i + 1번째 값에 저장해줍니다.<br><br>
그래야 다음 반복에서 i + 1과 i + 2번째 배열요소의 최소공배수 값을 구할 수 있기 때문입니다.<br><br>
반복이 끝나면 arr배열의 모든 원소들의 최소공배수를 구하여 반영한 commonMinMultiple을 구할 수 있습니다.
