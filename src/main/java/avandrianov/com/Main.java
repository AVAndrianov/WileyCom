package avandrianov.com;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpURLConnect http = new HttpURLConnect();

        System.out.println("Testing 1 - Delay");
        http.sendGetDelay(1);

        System.out.println("\nTesting 2 - Image");
        http.sendGetImage();

    }
}
