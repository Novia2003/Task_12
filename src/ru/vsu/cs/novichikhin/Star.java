package ru.vsu.cs.novichikhin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Star {
    public void drawImage(int size, int depth, Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, size, size);
        graphics2D.setColor(Color.BLACK);

        int lineLength = size / 3;
        Point centreStar = new Point(size / 2, size / 2);

        List<Point> centres = new ArrayList<>();
        centres.add(centreStar);

        findCentresOfStarsOfNextLevel(graphics2D, depth, lineLength, centres);
    }

    private void findCentresOfStarsOfNextLevel(Graphics2D graphics2D, int depth, int lineLength, List<Point> centres) {
        List<Point> newCentres = new ArrayList<>();
        Point firstCenter, secondCenter, thirdCenter, fourthCenter, fifthCenter, sixthCentre;

        for (Point centre : centres) {
            firstCenter = new Point(centre.getX() + lineLength, centre.getY());
            newCentres.add(firstCenter);

            secondCenter = new Point((int) (centre.getX() + lineLength * Math.tan(Math.PI / 6)), centre.getY() - lineLength);
            newCentres.add(secondCenter);

            thirdCenter = new Point((int) (centre.getX() - lineLength * Math.tan(Math.PI / 6)), centre.getY() - lineLength);
            newCentres.add(thirdCenter);

            fourthCenter = new Point(centre.getX() - lineLength, centre.getY());
            newCentres.add(fourthCenter);

            fifthCenter = new Point((int) (centre.getX() - lineLength * Math.tan(Math.PI / 6)), centre.getY() + lineLength);
            newCentres.add(fifthCenter);

            sixthCentre = new Point((int) (centre.getX() + lineLength * Math.tan(Math.PI / 6)), centre.getY() + lineLength);
            newCentres.add(sixthCentre);

            drawStar(graphics2D, new Point[]{firstCenter, secondCenter, thirdCenter, fourthCenter, fifthCenter, sixthCentre});
        }

        depth--;
        if (depth != 0) {
            findCentresOfStarsOfNextLevel(graphics2D, depth, lineLength / 3, newCentres);
        }
    }

    private void drawStar(Graphics2D graphics2D, Point[] newCentres) {
        for (int i = 0; i < 3; i++) {
            graphics2D.drawLine(newCentres[i].getX(), newCentres[i].getY(),
                    newCentres[i + 3].getX(), newCentres[i + 3].getY());
        }
    }
}