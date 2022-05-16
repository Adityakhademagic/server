
import java.io.*;
import java.net.Socket;

import java.util.Scanner;


public class Client {

    private Socket socket;
    private  InputStreamReader isr = null;
    private  OutputStreamWriter osw = null;
    private BufferedReader br = null;
    private  BufferedWriter bw = null;

    public void Client(String address, int port) {
       try {
           socket = new Socket(address, port);
           isr = new InputStreamReader(socket.getInputStream());
           osw = new OutputStreamWriter(socket.getOutputStream());

           br = new BufferedReader(isr);
           bw = new BufferedWriter(osw);

           Scanner scanner = new Scanner(System.in);
            while (true) {
                String msgToSend = scanner.nextLine();
                bw.write(msgToSend);
                bw.newLine();

                System.out.println("Server" +br.readLine());

                if(msgToSend.equalsIgnoreCase("Bye"))
                    break;
            }



       } catch (IOException e) {
                e.printStackTrace();
       }
       finally {
           try {
               if(socket != null)
                   socket.close();
               if(isr != null)
                   isr.close();
               if(osw != null)
                   osw.close();
               if(br != null)
                   br.close();
               if(bw != null)
                   bw.close();

           } catch (IOException e) {
                    e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
        Client client = new Client(new String[]{"localhost"}, 25000);
    }

}
