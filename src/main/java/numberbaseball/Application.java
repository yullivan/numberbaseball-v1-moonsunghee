package numberbaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("1부터 9까지의 서로 다른 숫자 3개를 맞춰보세요.");

        List<Integer> randomNumber = generateRandomNumbers();

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean isCorrect = false;

        System.out.println(randomNumber);

        while (!isCorrect) {
            // 사용자 입력 받기 (이 부분은 완성되어 있음)
            System.out.print("\n첫 번째 숫자를 입력하세요: ");
            int user1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int user2 = scanner.nextInt();
            System.out.print("세 번째 숫자를 입력하세요: ");
            int user3 = scanner.nextInt();
            List<Integer> inputNumber = new ArrayList<>();
            inputNumber.add(user1);
            inputNumber.add(user2);
            inputNumber.add(user3);
            System.out.println(inputNumber);
            count++;

            // TODO: strike 개수를 계산하세요
            int[] result = calculateResult(randomNumber, inputNumber);

            // TODO: 결과를 출력하세요 (예: "1 스트라이크")
            int strikes = result[0];
            int balls = result[1];

            System.out.println("결과: "+count+"번째 시도, " + strikes + " 스트라이크, " + balls + " 볼");

            // TODO: 3 스트라이크인 경우 게임을 끝내세요
            if (strikes == 3) {
                System.out.println("축하합니다! 정답을 맞췄습니다.");
                System.out.println("총 시도 횟수: " + count);
                isCorrect = true;
            }
        }
    }

    //랜덤넘버생성
    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3); // 앞에서부터 3개만 선택
    }

    //결과계산
    private static int[] calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }

}
