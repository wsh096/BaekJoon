class Main {

    private static final String ERROR = "error";
    private static final int BIT = 5;
    private static final int MASK = 31;

    public static void main(String[] args) throws Exception {

        int T = read();
        int[] x = new int[100000];
        int[] p = new int[(100000 >> BIT) + 1];
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            int c, numOperations = 0;

            while ((c = System.in.read()) > 64) {
                if (c != 68) p[numOperations >> BIT] |= 1 << (numOperations & MASK);
                numOperations++;
            }

            int n = read();

            System.in.read(); // [
            if (n == 0) read(); // ]
            else for (int i = 0; i < n; i++) x[i] = read();

            boolean isError = false;
            boolean isFront = true;

            int head = 0;
            int tail = n - 1;

            for (int i = 0; i < numOperations; i++) {

                if (((p[i >> BIT] >> (i & MASK)) & 1) == 1) {
                    isFront = !isFront;
                } else {
                    if (n-- == 0) {
                        isError = true;
                        break;
                    }
                    if (isFront)
                        head++;
                    else
                        tail--;
                }

            }

            if (isError) sb.append(ERROR);
            else {

                sb.append('[');

                int size = tail - head + 1;

                if (size > 0) {

                    if (isFront) {
                        head -= 1;
                        c = 1;
                    } else {
                        head = tail + 1;
                        c = -1;
                    }

                    while (size-- > 1) sb.append(x[head += c]).append(',');

                    sb.append(x[head + c]);

                }

                sb.append(']');

            }

            sb.append('\n');

            c = (numOperations >> BIT) + 1;
            for (int i = 0; i < c; i++) p[i] = 0;

        }

        System.out.print(sb);

    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 44 && c < 93)
            n = (n << 3) + (n << 1) + (c & 15);

        if (c == 93) c = System.in.read();

        return n;

    }

}