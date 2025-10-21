public class Main {
    public static void main(String[] args) {
        String initialText = "  Це   оригінальне   повідомлення   з   зайвими пробілами.  ";

        // 1. Створюємо базове повідомлення
        TextProcessor currentProcessor = new BaseMessage();
        String processedText = currentProcessor.processText(initialText);

        System.out.println("--- Крок 0: Базове повідомлення ---");
        System.out.println("Результат: " + processedText);
        System.out.println("------------------------------------");

        // 2. КРОК 1: Стиснення (видалення зайвих пробілів)
        currentProcessor = new CompressionDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 1: Стиснення (CompressionDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");

        // 3. КРОК 2: Шифрування (EncryptionDecorator)
        // Обгортаємо вже стиснений результат новим декоратором
        currentProcessor = new EncryptionDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 2: Шифрування (EncryptionDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");

        // 4. КРОК 3: Додавання Дати/Часу (TimestampDecorator)
        // Обгортаємо зашифрований результат
        currentProcessor = new TimestampDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 3: Додавання Дати (TimestampDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("----------------------------------------------------");

        // 5. КРОК 4: Додавання Автора (AuthorDecorator)
        // Фінальне обгортання
        currentProcessor = new AuthorDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 4: Додавання Автора (AuthorDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");
    }
}