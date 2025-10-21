abstract class TextDecorator implements TextProcessor {
    protected TextProcessor wrappedProcessor;

    public TextDecorator(TextProcessor processor) {
        this.wrappedProcessor = processor;
    }


    @Override
    public String processText(String text) {
        return wrappedProcessor.processText(text);
    }
}