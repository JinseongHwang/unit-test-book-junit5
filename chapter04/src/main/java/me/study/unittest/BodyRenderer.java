package me.study.unittest;

public class BodyRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return String.format("<b>%s</b>", message.getBody());
    }
}
