import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Daniel {
    public static void main(String[] args) {
        String serverAddress = "10.4.73.190"; // Dirección IP del servidor
        int serverPort = 1234; // Puerto en el que el servidor está escuchando

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Conectado al servidor: " + serverAddress + ":" + serverPort);

            // Ruta donde se guardará el archivo recibido
            String filePath = "recibido23.jpg";

            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // Lee el tamaño del archivo del servidor
            int fileSize = inputStream.read()*492;
            System.out.println(fileSize);

            // Si el tamaño es -1, significa que el archivo no existe o hubo un error
            if (fileSize == -1) {
                System.out.println("El archivo no existe en el servidor.");
                return;
            }

            byte[] buffer = new byte[5049818];
            int bytesRead;
            int totalBytesRead = 0;

            // Lee los datos del archivo del servidor y escribe en el archivo local
            while (totalBytesRead < 5049818 && (bytesRead = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            bufferedOutputStream.flush();

            System.out.println("Archivo recibido y guardado en: " + filePath);

            // Cierra los streams y el socket
            bufferedOutputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
