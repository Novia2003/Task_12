package ru.vsu.cs.novichikhin;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FrameMain extends JFrame {
    private JButton buttonDrawStar;
    private JButton buttonSaveToFile;
    private JPanel panelMain;
    private JSpinner spinnerSize;
    private JSpinner spinnerRecursionDepth;
    private JLabel labelImage;
    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Звёздочка");
        this.setContentPane(panelMain);
        this.setBounds(450, 10, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserSave = new JFileChooser();
        fileChooserSave.setCurrentDirectory(new File("C:\\Users\\ВЯЧЕСЛАВ\\ВГУ\\ВВП\\Twelve\\twelve"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("image", "jpg");
        fileChooserSave.addChoosableFileFilter(filter);

        spinnerSize.setValue(512);
        spinnerRecursionDepth.setValue(3);

        buttonDrawStar.addActionListener(actionEvent -> {
            int size = (int) spinnerSize.getValue();
            int depth = (int) spinnerRecursionDepth.getValue();

            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_BGR);
            Graphics2D graphics2D = image.createGraphics();
            Star star = new Star();
            star.drawImage(size, depth, graphics2D);
            labelImage.setIcon(new ImageIcon(image));
            setBounds(450, 10, size + 20, size + 140);
        });

        buttonSaveToFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    ImageIcon imageIcon = (ImageIcon) labelImage.getIcon();
                    BufferedImage image = (BufferedImage) imageIcon.getImage();

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".jpg")) {
                        file += ".jpg";
                    }

                    DrawUtil.printImageToFile(image, file);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Не уадётся сохранить в файл", "Ошибка");
            }
        });
    }
}
