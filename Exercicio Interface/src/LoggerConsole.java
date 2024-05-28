import java.time.LocalDateTime;

class LoggerConsole implements Logger {

    @Override
    public void log(Level level, String message) {
        String color;
        switch (level) {
            case DEBUG:
                color = "\u001B[32m"; // Verde
                break;
            case WARNING:
                color = "\u001B[33m"; // Amarelo
                break;
            case ERROR:
                color = "\u001B[31m"; // Vermelho
                break;
            default:
                color = "\u001B[0m"; // Reset
                break;
        }
        String currentTime = LocalDateTime.now().toString();
        System.out.println(color + "[" + level + "] " + currentTime + " - " + message + "\u001B[0m");
    }
}
