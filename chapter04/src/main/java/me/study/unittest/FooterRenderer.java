package me.study.unittest;

public class FooterRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return String.format("<i>%s</i>", message.getFooter());
    }
}
