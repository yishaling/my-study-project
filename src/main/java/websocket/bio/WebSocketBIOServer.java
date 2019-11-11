package websocket.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocketBIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        for (; ; ) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            System.out.println("有个一东西来了---------");
            new Thread(()->{
                byte[] bs=new byte[1024];

                while (true){

                    int read = 0;
                    try {
                        read = inputStream.read(bs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(read!=-1){
                        System.out.println(read);
                    }

                }
            }).start();


        }
    }
}
