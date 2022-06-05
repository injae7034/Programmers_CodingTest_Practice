# 내가 푼 코드

```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
       String[] arr1String = new String[arr1.length];
        for(int i = 0; i < arr1String.length; i++)
        {
            arr1String[i] = "";
        }
        for(int i  = 0; i < arr1.length; i++)
        {
            while(arr1[i] > 0)
            {
                arr1String[i] = (arr1[i] % 2) + arr1String[i];
                arr1[i] /= 2;
            }
            while(arr1String[i].length() < n)
            {
                arr1String[i] = 0 + arr1String[i];
            }
        }
        String[] arr2String = new String[arr2.length];
        for(int i = 0; i < arr2String.length; i++)
        {
            arr2String[i] = "";
        }
        for(int i  = 0; i < arr2.length; i++)
        {
            while(arr2[i] > 0)
            {
                arr2String[i] = (arr2[i] % 2) + arr2String[i];
                arr2[i] /= 2;
            }
            while(arr2String[i].length() < n)
            {
                arr2String[i] = 0 + arr2String[i];
            }
        }
        String[] answer = new String[n];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = "";
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr1String[i].charAt(j) == '1' || arr2String[i].charAt(j) == '1')
                {
                    answer[i] += "#";
                }
                else
                {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

매개변수로 입력 받은 정수배열 arr1의 각 배열요소를<br><br>
2진수로 바꿔 저장할 문자열 배열 arr1String을 arr1의 length만큼 힙에 할당합니다.<br><br>
**힙에 할당했기 때문에 문자열 배열 arr1String의 각 배열요소(문자열)의 초기값은 null입니다.**<br><br>
반복을 통해 arr1String의 모든 배열요소의 초기값을 ""(빈칸)으로 초기화해줍니다.<br><br>
다음으로 arr1배열의 첫 배열요소부터 마지막 배열요소까지 반복을 합니다.<br><br>
반복문 내부에서 다시 arr1의 i번째 배열요소가 0보다 큰 동안 반복합니다.<br><br>
arr1String의 i번째 배열요소에 arr1을 2로 나눈 나머지를 누적시킵니다.<br><br>
그리고 arr1의 i번째 배열요소를 2로 나눈 몫을 arr1의 i번째 배열요소에 저장합니다.<br><br>
while반복이 끝나면 arr1String의 i번째 배열요소에는 arr1의 i번째 배열요소를 2진법으로 바꾼 수가 저장되어 있습니다.<br><br>
다음으로 2진법 숫자의 자리수를 n으로 맞추기 위해 2진법 숫자가 n자리수가 될 때까지 앞자리에 0을 붙여 줍니다.<br><br>
2진법 숫자가 n자리 숫자가 되면 반복문을 빠져나가고, 또는 처음부터 자리수가 n이면 반복문에 들어가지 않습니다.<br><br>
이 반복을 통해서 arr1의 모든 배열요소가 자리수가 같은 2진법 숫자로 바뀌어 arr1String에 저장됩니다.<br><br>
arr2배열도 arr1과 동일한 방식으로 실행합니다.<br><br>
문자열배열 answer를 크기 n만큼 힙에 할당하고, 반복문을 통해 배열요소(문자열)의 초기값을 모두 ""(빈칸)으로 설정합니다.<br><br>
이중반복을 통해 arr1String과 arr2String의 각각의 배열요소(문자열)을 구하고, 그 문자열의 각 자리수의 글자를 확인합니다.<br><br>
arr1String과 arr2String의 두 문자열 배열의 배열요소 중에 하나라도 1이 있으면 answer의 i번째 배열요소에 #을 누적시키고,<br><br>
그게 아니면 " "(공백)을 누적시킵니다.<br><br>
반복문이 끝나고 answer를 반환하면 정답이 도출됩니다.

# 아쉬운 점

정수형 배열을 힙에 할당할 때 그 배열요소의 초기값은 0이고,<br><br>
**문자열 배열 또는 참조변수형 배열의 배열요소의 초기값은 null**인 것을 기억하자.<br><br>
이것을 까먹어서 +연산을 하고, 로직이 올바른데 답이 안나와서 시간을 많이 소모했다.
