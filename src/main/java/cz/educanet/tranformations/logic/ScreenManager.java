package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }


    private double rovnice(Coordinate fc, Coordinate sc){
        double a = ((double)sc.getY() - fc.getY()) / (sc.getX() - fc.getX());
        double result = (double)sc.getY() - a * fc.getX();
        return result;
    }



    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        Coordinate[] body = getSelectedPoints().toArray(new Coordinate[getSelectedPoints().size()]);

        // y = ax+b


        try {

            double a = rovnice(body[0],body[1]);

            //double b = rovnice(body[1],body[2]);

            //double c = rovnice(body[0],body[2]);

            double test = rovnice(body[0], coordinate);

            if (a < test)
                return true;


        } catch (Exception e) {

        }
        return false;
    }
}
