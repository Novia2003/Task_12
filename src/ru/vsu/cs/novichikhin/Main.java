package ru.vsu.cs.novichikhin;

import ru.vsu.cs.util.SwingUtils;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        SwingUtils.setDefaultFont("Microsoft Sans Serif", 12);
        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
