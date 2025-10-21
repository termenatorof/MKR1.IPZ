public class Main {
    public static void main(String[] args) {
        String initialText = "  Це   оригінальне   повідомлення   з   зайвими пробілами.  ";


        TextProcessor currentProcessor = new BaseMessage();
        String processedText = currentProcessor.processText(initialText);

        System.out.println("--- Крок 0: Базове повідомлення ---");
        System.out.println("Результат: " + processedText);
        System.out.println("------------------------------------");


        currentProcessor = new CompressionDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 1: Стиснення (CompressionDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");


        currentProcessor = new EncryptionDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 2: Шифрування (EncryptionDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");


        currentProcessor = new TimestampDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 3: Додавання Дати (TimestampDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("----------------------------------------------------");


        currentProcessor = new AuthorDecorator(currentProcessor);
        processedText = currentProcessor.processText(initialText);

        System.out.println("\n--- Крок 4: Додавання Автора (AuthorDecorator) ---");
        System.out.println("Результат: " + processedText);
        System.out.println("-------------------------------------------------");
    }
}