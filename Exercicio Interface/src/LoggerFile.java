import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

class LoggerFile implements Logger {

    private static final String FILE_NAME = "log.txt";

    public LoggerFile() {
        // Criar o arquivo se ele não existir
        try {
            if (Files.notExists(Paths.get(FILE_NAME))) {
                Files.write(Paths.get(FILE_NAME), "".getBytes(), StandardOpenOption.CREATE);
                System.out.println("Arquivo de log criado: " + FILE_NAME);
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de log");
            e.printStackTrace();
        }
    }

    @Override
    public void log(Level level, String message) {
        String currentTime = LocalDateTime.now().toString();
        String logMessage = "[" + level + "] " + currentTime + " - " + message + System.lineSeparator();

        try {
            Files.write(
                    Paths.get(FILE_NAME),
                    logMessage.getBytes(),
                    StandardOpenOption.APPEND   // Adiciona ao final do arquivo existente
            );
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo de log");
            e.printStackTrace();
        }
    }
}
