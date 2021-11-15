public class Main {

    static boolean win = false;

    public static void main(String[] args) {
        int num = (int) (Math.random() * 1000000000);
        System.out.println("Число = " + num);
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int timer = 0;
                    while (win != true) {
                        System.out.println("Секунд прошло: " + timer);
                        timer++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });
        Thread catchNumber = new Thread(new Runnable() {
            @Override
            public void run() {
                int num2 = (int) (Math.random() * 1000000000);
                long count = 0;
                while (num2 != num) {
                    num2 = (int) (Math.random() * 1000000000);
                    count++;
                    if (num2 == num) {
                        System.out.println("Числа совпали: Число 1 = Число 2 " + num + " = " + num2);
                        System.out.println("Всего попыток: " + count);
                        win = true;
                    }
                }

            }
        });
        time.start();
        catchNumber.start();
    }
}
