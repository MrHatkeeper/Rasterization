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

    private double rovnice(Coordinate x, Coordinate y) {
        double a = ((double) y.getY() - x.getY()) / (y.getX() - x.getX());
        double result = (double) x.getY() - (a * x.getX());
        return result;
    }


    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        Coordinate[] body = getSelectedPoints().toArray(new Coordinate[getSelectedPoints().size()]);

        try {


            double a = rovnice(body[0], body[1]);

            double test = rovnice(body[0], coordinate);

            if(a < test){
                return true;
            }


        } catch (Exception e) {
        }
        ;

        return false;

    }
}
