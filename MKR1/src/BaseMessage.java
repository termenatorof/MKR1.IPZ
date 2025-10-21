public class BaseMessage implements TextProcessor {
    @Override
    public String processText(String text) {
        return text; // Повертає базовий текст без змін
    }
}

