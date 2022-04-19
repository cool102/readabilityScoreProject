import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        String[] onlyParams = url.split("\\?");

        String[] arr = onlyParams[1].replace("&", "=").split("=");
        System.out.println();
        boolean isPassFinded = false;
        int passwordIdx = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].equals("pass")) {
                passwordIdx = j + 1;
                isPassFinded = true;
            }

            if (arr[j].isEmpty()) {
                String temp = "not found";
                arr[j] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            String str = String.format("%s : %s", arr[i], arr[i + 1]);
            System.out.println(str);
            i = i + 1;
        }

        if (isPassFinded) {
            String str = String.format("password : %s", arr[passwordIdx]);
            System.out.println(str);
        }


    }
}
