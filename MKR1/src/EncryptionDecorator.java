import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class EncryptionDecorator extends TextDecorator {
    public EncryptionDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String processText(String text) {
        String base = super.processText(text);
        return simpleEncrypt(base);
    }

    // Метод шифрування (зміщення кожного символу на 1 позицію)
    private String simpleEncrypt(String data) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            sb.append((char) (c + 1));
        }
        return sb.toString();
    }
}

// 2.2. Декоратор для Стиснення (видалення зайвих пробілів)
class CompressionDecorator extends TextDecorator {
    public CompressionDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String processText(String text) {
        String base = super.processText(text);
        return base.replaceAll("\\s+", " ").trim();
    }
}

// 2.3. Декоратор для Додавання Дати та Часу
class TimestampDecorator extends TextDecorator {
    public TimestampDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String processText(String text) {
        String base = super.processText(text);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = formatter.format(now);
        return base + " [TIMESTAMP: " + timestamp + "]";
    }
}

// 2.4. Декоратор для Додавання ПІБ Автора
class AuthorDecorator extends TextDecorator {
    private final String authorName = "Шеремета Артем Русланович";

    public AuthorDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String processText(String text) {
        String base = super.processText(text);
        return base + " | AUTHOR: " + authorName;
    }
}