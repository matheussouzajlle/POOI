import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de logger: 'console' ou 'file'");
        String loggerType = scanner.nextLine().trim().toLowerCase();
        Logger logger;

        if (loggerType.equals("console")) {
            logger = factory.onConsole();
        } else if (loggerType.equals("file")) {
            logger = factory.onFile();
        } else {
            System.out.println("Tipo de logger inválido.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("Digite o nível do log ('DEBUG', 'WARNING', 'ERROR') ou 'exit' para sair:");
            String levelInput = scanner.nextLine().trim().toUpperCase();

            if (levelInput.equals("EXIT")) {
                break;
            }

            Level level;
            try {
                level = Level.valueOf(levelInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Nível de log inválido.");
                continue;
            }

            System.out.println("Digite a mensagem do log:");
            String message = scanner.nextLine().trim();

            logger.log(level, message);
        }

        scanner.close();
    }
}
