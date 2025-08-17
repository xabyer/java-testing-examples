package nio;

import java.nio.ByteBuffer;

public class ByteBufferExample {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put((byte)'A');
        buffer.put((byte)'B');
        buffer.put((byte)'C');

        //Flip the buffer to prepare for reading
        buffer.flip();

        while (buffer.hasRemaining()) {
            //System.out.println(buffer.get()); //65 66 67
            System.out.print((char)buffer.get()); //ABC
        }
    }
}
