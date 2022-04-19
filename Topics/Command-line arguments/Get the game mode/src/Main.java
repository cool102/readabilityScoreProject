class Problem {
    public static void main(String[] args) {
        boolean isFinded = false;
        for (int i = 0; i < args.length; i = i + 2) {
            if (args[i].equals("mode")) {
                System.out.println(args[i + 1]);
                isFinded = true;
                break;
            }
        }

        if (!isFinded) {
            System.out.println("default");
        }

    }
}