package me.study.unittest;

public class HeaderRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return String.format("<h1>%s</h1>", message.getHeader());
    }
}
