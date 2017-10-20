package com.codefellows;

public class WindowDecorator implements IWindow {
    private IWindow window;

    public WindowDecorator(IWindow window) {
        this.window = window;
    }

    public void maximize() {
        System.out.println("window is maximized");
    }

    @Override
    public void minimize() {
        window.minimize();
        System.out.println("decorated window minimized");
    }
}
