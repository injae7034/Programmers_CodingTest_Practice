# 내가 풀이한 코드
```java
class Solution {
    public int solution(int n) {
        //자연수 n을 2진수로 변경
        String binaryString = Integer.toBinaryString(n);
        //문자 변경을 위해 2진수 문자열에서 2진수 문자배열을 구한다
        char[] binaryArr = binaryString.toCharArray();
        //뒤에서부터 시작하여 최초 1의 위치를 찾는다.
        int oneIndex = binaryString.lastIndexOf('1');
        //뒤에서 최초 1의 위치부터 시작하여 뒤에서 0의 위치를 찾는다.
        int zeroIndex = binaryString.lastIndexOf('0', oneIndex);
        ///뒤에서 최초 1의 위치부터 시작하여 뒤에서 0의 위치를 찾았으면
        int oneCount = 0;
        if(zeroIndex > 0)
        {
            //0의 위치부터 뒤에 존재하는 1의 개수를 센다.
            for(int i = zeroIndex; i < binaryString.length(); i++)
            {
                if(binaryString.charAt(i) == '1')
                {
                    oneCount++;
                }
            }
            //0을 1로 변경하고 1의 개수를 감소시킨다.
            binaryArr[zeroIndex] = '1';
            oneCount--;
            //1로 변경한 위치뒤부터 모든 문자를 0으로 변경한다.
            for(int i = zeroIndex + 1; i < binaryArr.length; i++)
            {
                binaryArr[i] = '0';
            }
            //마지막 위치부터 시작하여 1의 개수만큼 1로 변경해준다.
            int lastIndex = binaryArr.length - 1;
            while(oneCount > 0)
            {
                binaryArr[lastIndex--] = '1';
                oneCount--;
            }
        }
        ///뒤에서 최초 1의 위치부터 시작하여 뒤에서 0의 위치를 찾지 못했으면
        else
        {
            //문자열의 마지막 위치부터시작 해서 0의 위치를 찾는다.
            zeroIndex = binaryString.lastIndexOf(0);
            //앞에 1을 더해준다.
            binaryString = "1" + binaryString;
            //1을 더해준 문자열에 문자배열을 구한다.
            binaryArr = binaryString.toCharArray();
            //두번째 1을 0으로 바꿔준다.
            binaryArr[1] = '0';
            //0으로 바꿔준 위치 다음부터 1의 개수와 0의 개수를 센다.
            int zeroCount = 0;
            for(int i = 2; i < binaryArr.length; i++)
            {
                if(binaryArr[i] == '1')
                {
                    oneCount++;
                }
                else
                {
                    zeroCount++;
                }
            }
            //0의 개수가 0보다 크고 1의 개수가 0보다 크면
            if(zeroCount > 0 && oneCount > 0)
            {
                //1의 개수만큼 반복한다.
                while(oneCount > 0)
                {
                    binaryString = new String(binaryArr);
                    //뒤에서부터 시작하여 최초 0의 위치를 찾는다.
                    zeroIndex = binaryString.lastIndexOf('0');
                    //뒤에서 최초 0의 위치부터 시작하여 뒤에서 1의 위치를 찾는다.
                    oneIndex = binaryString.lastIndexOf('1', zeroIndex);
                    //서로 값을 바꾼다.
                    binaryArr[zeroIndex] = '1';
                    binaryArr[oneIndex] = '0';
                    oneCount--;
                }
            }
        }
        //바뀐 문자배열을 바탕으로 새로운 문자열을 만든다
        binaryString = new String(binaryArr);
        //2진수 기준 새로운 문자열을 10진수로 바꿔준다.
        return Integer.parseInt(binaryString, 2);
    }
}
```

# 내가 풀이한 코드 설명하기

주어진 자연수 n을 이진수로 변경하여 그것을 바탕으로 이진수 문자 배열을 생성합니다.<br><br>
그 문자를 기준으로 하여 변경하면서 문제에서 제시하는 조건대로 같은 1의 개수를 구하려다 보니<br><br>
코드가 굉장히 길어지고 복잡해졌습니다.<br><br>

# 아쉬운 점
기존의 수에서 변경을 하려고 하다 보니 굉장히 복잡하고 헷갈립니다.<br><br>
이럴 때는 차라리 발상의 전환을 하여 기존 것에서 조건에 맞게 변경하는 것이 아니라<br><br>
조건에 맞는 새로운 수를 생성하는 것이 훨씬 낫습니다.<br><br>
즉, 자연수 n의 이진수에서 변경을 하는 것보다 새로 만드는 것이 훨씬 간단합니다.<br><br>
다른 사람의 코드를 보니 애초에 자연수 n을 이진수로 바꾼 다음 거기서 먼저 1의 개수를 셉니다.<br><br>
그 다음 n에 +1을 해준 값을 2진수로 바꿔서 1의 개수가 자연수 n과 같을때동안 반복하면<br><br>
손쉽게 문제에서 제시한 기준대로 다음 큰 수를 구할 수 있습니다.
