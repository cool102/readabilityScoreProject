class Problem {
    public static void main(String[] args) {
        for (int i = 0; i < args.length ; i=i+2) {
            String output = String.format("%s=%s\n",args[i],args[i+1]);
            System.out.print(output);
        }
    }
}