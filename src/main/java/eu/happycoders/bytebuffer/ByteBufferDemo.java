package eu.happycoders.bytebuffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferDemo {

    public static void main(String[] args) {
        // Section 2 - Creating a ByteBuffer
        var buffer = ByteBuffer.allocate(1_000);
        printMetrics(buffer);

        // Section 4.1 - Writing to the ByteBuffer with put()
        for (int i = 0; i < 100; i++) {
            buffer.put((byte) 1);
        }
        printMetrics(buffer);

        byte[] twos = new byte[200];
        Arrays.fill(twos, (byte) 2);
        buffer.put(twos);
        printMetrics(buffer);

        // Section 4.2 - Switching to read mode with flip()
        // buffer.limit(buffer.position());
        // buffer.position(0);
        buffer.flip();
        printMetrics(buffer);

        // Section 4.3 - Reading from the ByteBuffer with get()
        buffer.get(new byte[200]);
        printMetrics(buffer);

        // Section 4.4 - Switching to write mode - how not to do it
        // buffer.position(buffer.limit());
        // buffer.limit(buffer.capacity());

        // Section 4.5 - Switching to write mode with compact()
        buffer.compact();
        printMetrics(buffer);

        // Section 4.6 - The next cycle
        byte[] threes = new byte[300];
        Arrays.fill(threes, (byte) 3);
        buffer.put(threes);
        printMetrics(buffer);

        buffer.flip();
        printMetrics(buffer);
    }

    private static void printMetrics(ByteBuffer buffer) {
        System.out.printf("position = %4d, limit = %4d, capacity = %4d%n",
                buffer.position(), buffer.limit(), buffer.capacity());
    }

}
